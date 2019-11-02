pipeline {
    agent any
    environment {
		DOCKER_REPO="sba-docker"
		dockerImage = ''
    }
    stages {
    	stage('CheckOut Code'){
         	steps{
            	checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/wujiabo/FSD-SBA.git']]])
            }
        }
        stage('Maven Build'){
        	steps{
        	    bat 'mvn clean package -DskipTests'
        	}
        }
        stage('Image Build'){
        	steps{
        	    bat 'mvn dockerfile:build'
        	}
        }
        stage('Remove Unused Image'){
        	steps{
        	    bat 'docker image prune -f'
        	}
        }
    }
}