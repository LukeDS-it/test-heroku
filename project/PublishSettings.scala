import bintray.BintrayKeys._
import sbt.librarymanagement.LibraryManagementSyntax
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._
import sbt.Keys._
import sbt.ThisBuild

object PublishSettings extends LibraryManagementSyntax {
  lazy val settings = Seq(
    bintrayOmitLicense := true,
    releaseProcess := Seq[ReleaseStep](
      inquireVersions,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepCommandAndRemaining("publish"),
      setNextVersion,
      commitNextVersion
    ),
    releaseCommitMessage := s"Setting version to ${(version in ThisBuild).value} [ci skip]"
  )
}
