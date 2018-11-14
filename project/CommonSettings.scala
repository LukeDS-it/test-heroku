import sbt.Keys._
import sbt.ThisBuild
import sbt.librarymanagement.LibraryManagementSyntax

object CommonSettings extends LibraryManagementSyntax {

  lazy val settings = Seq(
    version := (version in ThisBuild).value
  )

}
