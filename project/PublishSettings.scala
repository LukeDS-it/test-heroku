import bintray.BintrayKeys._
import sbt.librarymanagement.LibraryManagementSyntax

object PublishSettings extends LibraryManagementSyntax {

  lazy val settings = Seq(
    bintrayOmitLicense := true
  )


}
