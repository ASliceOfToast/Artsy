name := "cs1302-artsy"

version := "1.1"

autoScalaLibrary := false

fork := true

unmanagedSourceDirectories in Compile <<= Seq(javaSource in Compile).join

unmanagedSourceDirectories in Test <<= Seq(javaSource in Test).join

libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test->default"

