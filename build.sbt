import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "kurtlogan",
      scalaVersion := "2.13.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "string-literal-types-2.13"
  )
