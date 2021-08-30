package com.qbrainx.main

import scala.io.StdIn
import com.qbrainx.util.JsonHelper.{jsArray, toJson, vector}
import spray.json.JsArray
object Main extends App {

  def readInput(): Any = {
    val input: String = StdIn.readLine()

    input match {

      case _ if (input.charAt(0)=='A' &&input.charAt(1)=='-' &&input.charAt(2)=='>') =>
        val list: List[String] = input.split("->").toList
        toJson(list(1))
        readInput()

      case _ if (input.charAt(0) == 'R') =>
        if (vector.nonEmpty ) {
          println(jsArray.prettyPrint)
          jsArray = JsArray.empty
          vector = Vector.empty
          readInput()
        }
        else
          println("Json is empty")
          readInput()
      case _=>
        println("invalid input from the user")
        readInput()
    }
  }
  readInput()

}