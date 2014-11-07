name := "hello-server-play"

organization := "co.fizzed"

organizationName := "Fizzed, Inc."

organizationHomepage := Some(url("http://fizzed.co"))

version := "1.2.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
  //"co.fizzed" % "fizzed-stork-bootstrap" % "1.2.0"
)

resolvers += Resolver.mavenLocal

run in Compile <<= (run in Compile).dependsOn(storkRun)

// bind stork to generate launchers during compile
//compile in Compile <<= (compile in Compile).dependsOn(storkLauncherGenerate)

//mainClass in (Compile, run) := Some("play.core.server.NettyServer")
//mainClass in (Compile, run) := Some("co.fizzed.stork.bootstrap.PlayBootstrap")