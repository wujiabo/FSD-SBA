node {
    def maven_home
    stage 'Init'
        maven_home=tool 'maven'

    stage 'Build'
        echo 'start build project'
        sh "'${maven_home}/bin/mvn' clean package test"

    stage 'Deploy'
        echo 'start deploy project'
        sh "'${maven_home}/bin/mvn' tomcat7:redeploy-only"
}