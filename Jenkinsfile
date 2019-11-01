node {
   def mvnHome
   def workspace = pwd()
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/wujiabo/FSD-SBA.git'
      // Get the Maven tool.
      // ** NOTE: This 'maven' Maven tool must be configured
      // ** in the global configuration.
      mvnHome = tool 'maven'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"

      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Deploy') {
      steps {
         bat "java -jar ./registry/target/registry-1.0-SNAPSHOT.jar"
      }
   }
}