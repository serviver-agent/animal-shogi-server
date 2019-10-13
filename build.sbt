import Dependencies._

ThisBuild / scalaVersion     := "0.19.0-RC1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

scalacOptions ++= "-deprecation" :: "-feature" :: Nil

lazy val root = (project in file("."))
  .settings(
    name := "animal-shogi-server",
    libraryDependencies += junit % "test"
  )
  .aggregate(rules)

lazy val rules = (project in file("domain/rules"))
  .settings(
    name := "domain-rules",
    libraryDependencies += junit % "test"
  )
