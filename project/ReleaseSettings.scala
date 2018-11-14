import sbt.Keys._
import sbt.ThisBuild
import sbt.librarymanagement.LibraryManagementSyntax
import sbtrelease.ReleasePlugin.autoImport.releaseCommitMessage

object ReleaseSettings extends LibraryManagementSyntax {
  lazy val settings = Seq(
    publishMavenStyle := false,
    pomIncludeRepository := { _ => false },
    publishArtifact := false,
    publishTo := Some("Bintray" at "https://bintray.com/lukeds-it/maven"),
    releaseCommitMessage := s"Setting version to ${(version in ThisBuild).value} [ci skip]"
  )
}
