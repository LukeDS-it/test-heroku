import bintray.BintrayKeys._
import sbt.librarymanagement.LibraryManagementSyntax
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._

object PublishSettings extends LibraryManagementSyntax {
  lazy val settings = Seq(
    bintrayOmitLicense := true,
    releaseProcess := Seq[ReleaseStep](
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepCommandAndRemaining("publish"),
      setNextVersion,
      commitNextVersion,
      pushChanges
    )
  )


}
