pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'mvn clean package'
            }
        }
        stage('deploy') {
            steps {
                echo 'mvn -version'
            }
        }
    }
}