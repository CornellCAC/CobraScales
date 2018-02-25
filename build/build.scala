package cobrascales_build
import cbt._
class Build(val context: Context) extends BaseBuild{
  val optimusVersion = "2.1.0"
  override def dependencies = (
    super.dependencies ++ // don't forget super.dependencies here for scala-library, etc.
    Seq(
      // source dependency
      // DirectoryDependency( projectDirectory ++ "/subProject" )
    ) ++
    // pick resolvers explicitly for individual dependencies (and their transitive dependencies)
    Resolver( mavenCentral, sonatypeReleases ).bind(

      MavenDependency( "com.joptimizer", "joptimizer", "4.0.0" )
      ,MavenDependency( "org.sbml.jsbml", "jsbml", "1.3.1" )
      ,ScalaDependency( "com.github.vagmcs", "optimus", optimusVersion )
      ,ScalaDependency( "com.github.vagmcs", "optimus-solver-oj", optimusVersion )
      ,ScalaDependency( "com.github.vagmcs", "optimus-solver-gurobi", optimusVersion )

      // CBT-style Scala dependencies
      // ScalaDependency( "com.lihaoyi", "ammonite-ops", "0.5.5" )
      // MavenDependency( "com.lihaoyi", "ammonite-ops_2.11", "0.5.5" )

      // SBT-style dependencies
      // "com.lihaoyi" %% "ammonite-ops" % "0.5.5"
      // "com.lihaoyi" % "ammonite-ops_2.11" % "0.5.5"
    )
  )
}
