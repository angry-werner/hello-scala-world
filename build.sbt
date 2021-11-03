import sbt.Keys.libraryDependencies

val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
        "com.novocode" % "junit-interface" % "0.11" % "test",
        "org.scalameta" %% "munit" % "0.7.27" % Test,
        "org.scalameta" %% "munit-scalacheck" % "0.7.27" % Test),
    testFrameworks += new TestFramework("munit.Framework")
  )
