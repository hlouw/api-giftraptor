organization  := "hlouw"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  val kamonV = "0.4.0"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
    "io.kamon"            %%  "kamon-core"    % kamonV,
    "io.kamon"            %%  "kamon-spray"   % kamonV,
    "io.kamon"            %%  "kamon-log-reporter" % kamonV
  )
}

Revolver.settings

aspectjSettings

javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj

javaOptions in Revolver.reStart <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true