name := "scala-basic-learning"

/*** COMMON SETTINGS ***/
lazy val commonSettings = Seq(
  organization := "eu.tetrao",
  version := "0.1.1",
  scalaVersion := "2.12.12",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-target:jvm-1.8")
)


val sharedDependencies = Seq(
  "org.apache.commons" % "commons-csv" % "1.4",
  "com.lihaoyi" %% "upickle" % "0.4.4",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "org.slf4j" % "slf4j-simple" % "2.0.0-alpha1"

)


lazy val core  = (project in file("subprojects/core"))
  .settings(name := "core")
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= sharedDependencies ++ Seq( )
  )



/*** ROOT PROJECT ***/
lazy val scala_first_samples = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(core)


