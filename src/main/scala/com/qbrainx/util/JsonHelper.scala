package com.qbrainx.util
import com.qbrainx.model.Student
import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, jsonFormat2}
import spray.json._

object JsonHelper {

  var jsArray: JsArray = JsArray.empty
  var vector: Vector[JsValue] = Vector.empty

  def toJson(input: String):Unit = {
    implicit val rootJsonFormat: RootJsonFormat[Student] = jsonFormat2(Student)

    input.split(",") match {
      case Array(name, id) =>
        val jsArray1: Student = Student(name.replace("(", ""),
          id.replace(")", "").toInt)

        val jsVal: JsValue = jsArray1.toJson
        vector = vector.appended(jsVal)
        jsArray = JsArray.apply(vector)

      case _ => println("invalid input")
    }
  }
  }
