package services

import java.io._
import java.util.zip.GZIPInputStream

import org.apache.commons.csv.{CSVFormat, CSVParser, CSVRecord}

import scala.collection.Seq
import scala.collection.mutable.ListBuffer





object CSVManager {


  def init_csv_writer(
                       output_filepath : String,
                       labels_seq: Seq[String],
                       append: Boolean = false
                     ) : ApacheCSVWriter = {
    ApacheCSVWriter(
      output_filepath,
      labels_seq,
      append
    )
  }


  def load(
                     csv_file_path: String,
                     with_header : Boolean = true
                   ): List[CSVRecord] = {
    load_csv_file_from_reader(
      new FileReader(csv_file_path),
      with_header
    )
  }



  def load_from_gzip(
                               csv_file_path: String,
                               with_header : Boolean = true
                             ): List[CSVRecord] = {
    load_csv_file_from_reader(
      new InputStreamReader(
        new GZIPInputStream(
          new FileInputStream(
            new File(csv_file_path)
          )
        )
      ),
      with_header
    )
  }


  /*
   * Load a CSV file in memory
   * Note: it should not be used for big CSV files.
   */
  private def load_csv_file_from_reader(
                                         file_reader: Reader,
                                         with_header : Boolean = true
                                       ): List[CSVRecord] = {
    val csv_file_format = if (with_header) {
      CSVFormat.DEFAULT.withHeader()
    } else {
      CSVFormat.DEFAULT
    }
    val parser = new CSVParser(file_reader, csv_file_format);
    parser.getHeaderMap
    val records = ListBuffer[CSVRecord]()
    val iterator = parser.iterator()
    while(iterator.hasNext){
      records.append(iterator.next())
    }
    parser.close()
    file_reader.close()
    records.toList
  }

}
