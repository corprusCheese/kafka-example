name := "kafka-application"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.5.0"
libraryDependencies += "org.apache.kafka" %% "kafka-streams-scala" % "2.5.0"
libraryDependencies += "com.github.fd4s" %% "fs2-kafka" % "1.7.0"
