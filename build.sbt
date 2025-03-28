val scala3Version = "3.6.3"

lazy val sharedSettings = Seq(
  organization := "com.dixa",
  version      := "0.1.0-SNAPSHOT",
  scalaVersion := scala3Version,
  libraryDependencies ++= Seq(
    // Logging
    "org.typelevel" %% "log4cats-slf4j"  % "2.7.0",
    "ch.qos.logback" % "logback-classic" % "1.5.18",

    // Streaming
    "co.fs2" %% "fs2-core" % "3.12.0",
    "co.fs2" %% "fs2-io"   % "3.12.0",
    // Database
    "org.tpolecat" %% "doobie-core"   % "1.0.0-RC8",
    "org.tpolecat" %% "doobie-hikari" % "1.0.0-RC8",
    "org.xerial"    % "sqlite-jdbc"   % "3.49.1.0",

    // Testing
    "com.disneystreaming" %% "weaver-cats" % "0.8.4" % Test
  ),
  scalacOptions ++= Seq(
    "-explain",        // Explain errors in more detail
    "-explain-types",  // Explain type errors in more detail
    "-deprecation",    // Emit warning for usages of deprecated APIs
    "-feature",        // Emit warning for usages of features that should be imported explicitly
    "-source:future",  // Use future language features
    "-Xfatal-warnings" // Fail the compilation if there are any warnings
  ),
  Compile / run / fork := true
)

lazy val analytics = project
  .in(file("analytics"))
  .settings(sharedSettings)
  .settings(name := "analytics")

lazy val root = project
  .in(file("."))
  .settings(sharedSettings)
  .dependsOn(analytics)
  .aggregate(analytics)
