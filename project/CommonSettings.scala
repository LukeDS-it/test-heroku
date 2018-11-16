import sbt.Keys.version
import sbt.{ThisBuild, _}
import sbt.librarymanagement.LibraryManagementSyntax

object CommonSettings extends LibraryManagementSyntax {
  lazy val settings = Seq(
    version := (version in ThisBuild).value
  )
}

