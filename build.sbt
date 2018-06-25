
name := "TenPinBowling"

version := "1.0"

scalaVersion := "2.12.1"

logLevel := sbt.Level.Info

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.12" % "3.0.5" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5")