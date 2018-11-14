val scalatestVersion = "3.0.4"

lazy val api = (project in file("api"))
  .enablePlugins(ReleasePlugin)
  .settings(
    name := "test-heroku-api",
    scalaVersion := "2.12.7",
  )

lazy val server = (project in file("server"))
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "test-heroku",
    scalaVersion := "2.12.7",
    mainClass in Compile := Some("it.test.heroku.TestHeroku"),

    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "18.10.0",
      "org.scalatest" %% "scalatest" % scalatestVersion % Test
    )
  )
  .dependsOn(api)

lazy val `test-heroku` = (project in file("."))
  .aggregate(api, server)
  .settings(
    run := {
      (run in server in Compile).evaluated
    }
  )