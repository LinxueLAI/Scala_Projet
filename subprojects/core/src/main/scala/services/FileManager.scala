package services

import java.io._
import java.nio.file.Path
import java.util.UUID
import java.util.zip.GZIPInputStream

import scala.language.postfixOps

/**
  * Created by loick on 3/7/16.
  */
object FileManager{


  def read_from_file(
                      path: String
                    ) : String ={
    return  scala.io.Source.fromFile(
      path,
      "UTF-8"
    ).mkString
  }


  def write_into_file(
                       path: String,
                       content: String,
                       appendToFile: Boolean = false
                     ) : Unit = {
    val fw = new FileWriter(
      path,
      appendToFile
    )
    fw.write(content)
    fw.close()
  }


  def get_files(dir: String): List[String] = {

    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList.map( x => x.getAbsolutePath())
    } else {
      List[String]()
    }
  }

  def mkdir(path: String) : Boolean = {
    if(new File(path).exists()){
      return true
    } else {
      try{
        new File(path).mkdirs()
        return true
      } catch {
        case e : Throwable => return false
      }
    }
  }


  def get_subfolders(dir: String): List[String] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isDirectory).toList.map( x => x.getAbsolutePath())
    } else {
      List[String]()
    }
  }



}
