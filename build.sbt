val scalatestVersion = "3.0.4"

lazy val api = (project in file("api"))
  .settings(PublishSettings.settings)
  .settings(CommonSettings.settings)
  .settings(
    name := "test-heroku-api",
    scalaVersion := "2.12.7"
  )

lazy val server = (project in file("server"))
  .dependsOn(api)
  .enablePlugins(JavaAppPackaging)
  .settings(CommonSettings.settings)
  .settings(
    name := "test-heroku",
    scalaVersion := "2.12.7",
    mainClass in Compile := Some("it.test.heroku.TestHeroku"),

    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "18.10.0",
      "org.apache.kafka" %% "kafka" % "2.1.0",
      "org.scalatest" %% "scalatest" % scalatestVersion % Test
    ),
    publish / skip := true
  )

lazy val `test-heroku` = (project in file("."))
  .aggregate(api, server)
  .settings(CommonSettings.settings)
  .settings(PublishSettings.settings)
  .settings(
    test / aggregate := false,
    publish / skip := true,
    run := {
      (run in server in Compile).evaluated
    }
  )