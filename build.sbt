

lazy val api = project in file("api")

lazy val server = (project in file("server"))
  .settings(
    name := "test-heroku",
    version := "0.1",
    scalaVersion := "2.12.7",
    mainClass in Compile := Some("it.test.heroku.TestHeroku"),

    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "18.10.0"
    )
  )
  .enablePlugins(JavaAppPackaging)
  .dependsOn(api)

lazy val `test-heroku` = (project in file("."))
  .aggregate(api, server)
  .settings(
    run := {
      (run in server in Compile).evaluated
    }
  )