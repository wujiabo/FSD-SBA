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
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package -P docker"

      } else {
         bat(/"${mvnHome}\bin\mvn" clean package docker:build/)
      }
   }
   stage('clean none') {
        bat 'docker rmi $(docker images --filter “dangling=true” -q --no-trunc)'
   }
   stage('registry') {
        bat 'docker run -p 9001:9001 -d sba/registry:latest'
   }
   stage('gateway') {
        bat 'docker run -p 9002:9002 -d sba/gateway:latest'
   }
}