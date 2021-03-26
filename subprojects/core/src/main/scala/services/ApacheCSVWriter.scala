package services

import java.io.{FileReader, FileWriter}

import org.apache.commons.csv.{CSVFormat, CSVParser, CSVPrinter}

import scala.collection.Seq
import scala.util.Try


/**
  * Created by lbriot on 8/29/17.
  *
  *
  * Class that enable to write line of data in a CSV file :
  *
  *   - file_path : path of the file
  *
  *   - column_labels : a sequence with the value of the header row
  *
  *   - append_to_file : optional, define if you want to erase the file if the file already exists or if you prefer to append the new value at the end of the file. Default, it delete the previous values.
  *
  */


case class ApacheCSVWriter(
                            file_path : String,
                            column_labels: Seq[String],
                            private val append_to_file : Boolean = false
                          ) {

  private val csvFileFormat = CSVFormat.DEFAULT
  private val labels= new java.util.ArrayList[String]()
  private val foutput = new FileWriter(file_path, append_to_file)
  private val csv_writer =  new CSVPrinter(foutput, csvFileFormat);
  private var rows_written = 0

  {

    column_labels.foreach(labels.add)

    // Read the file to know if the header is empty. If yes, we write the header row.
    val fileReader = new FileReader(file_path);
    val csvFileReadingFormat = CSVFormat.DEFAULT.withHeader()
    val csvFileParser = new CSVParser(fileReader, csvFileReadingFormat);

    if (Try(csvFileParser.getHeaderMap.size()).getOrElse(0) == 0) {
      csv_writer.printRecord(labels)
      foutput.flush()
    }
  }


  def append_row(map_to_append: Map[String,String])  : Unit = {
    csv_writer.synchronized {
      foutput.synchronized {
        val line_to_append = new java.util.ArrayList[String]()
        column_labels.foreach(e => line_to_append.add(map_to_append.getOrElse(e, "")))
        csv_writer.printRecord(line_to_append)
        foutput.flush()
        rows_written += 1
      }
    }
  }

  def append_row(line_to_append: Seq[String])  : Unit = {
    csv_writer.synchronized {
      foutput.synchronized {
        val line_to_append2 = new java.util.ArrayList[String]()
        line_to_append.foreach(e => line_to_append2.add(e))
        csv_writer.printRecord(line_to_append2)
        foutput.flush()
        rows_written += 1
      }
    }
  }


  def close()  : Unit = {
    csv_writer.close()
    foutput.close()
  }

}
