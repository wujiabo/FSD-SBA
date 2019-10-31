pipeline {
    stages {
        stage('Build') { 
            steps {
                bat 'mvn clean package -B -DskipTests'
            }
        }
    }
}