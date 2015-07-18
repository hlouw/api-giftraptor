organization  := "hlouw"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  val kamonV = "0.4.0"
  val specs2V = "2.3.11"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "com.typesafe.akka"   %%  "akka-slf4j"    % akkaV,
    "ch.qos.logback"      %   "logback-classic" % "1.0.13",
    "org.specs2"          %%  "specs2-core"   % specs2V % "test",
    "org.specs2"          %%  "specs2-mock"   % specs2V % "test",
    "io.kamon"            %%  "kamon-core"    % kamonV,
    "io.kamon"            %%  "kamon-spray"   % kamonV,
    "io.kamon"            %%  "kamon-datadog"   % kamonV,
//    "org.logback-extensions" % "logback-ext-loggly" % "0.1.2",
    "org.aspectj"         %   "aspectjweaver" % "1.8.2",
    "org.reactivemongo"   %%  "reactivemongo" % "0.11.2"
  )
}

Revolver.settings

aspectjSettings

javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj

javaOptions in Revolver.reStart <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true

enablePlugins(JavaServerAppPackaging)

enablePlugins(DockerPlugin)

dockerRepository := Some("hlouw")

dockerExposedPorts := Seq(8080, 8081)

bashScriptExtraDefines += """addJava "-javaagent:${lib_dir}/org.aspectj.aspectjweaver-1.8.2.jar""""
