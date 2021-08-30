import sbt._
object Dependencies {


  val sprayJsonversion="1.3.6"
  val spray= "io.spray" %% "spray-json" % sprayJsonversion
 def compileDependencies: ModuleID =spray

}
