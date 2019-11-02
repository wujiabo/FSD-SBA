pipeline {
    agent any
    environment {
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
        stage('Image Push'){
        	steps{
        	    bat 'docker push wujiabo1985/registry:latest'
        	    bat 'docker push wujiabo1985/gateway:latest'
        	    bat 'docker push wujiabo1985/payment:latest'
        	    bat 'docker push wujiabo1985/search:latest'
        	    bat 'docker push wujiabo1985/security:latest'
        	    bat 'docker push wujiabo1985/technology:latest'
        	    bat 'docker push wujiabo1985/training:latest'
        	    bat 'docker push wujiabo1985/user:latest'
        	}
        }
        stage('Remove Image'){
        	steps{
        	    bat 'docker rmi wujiabo1985/registry'
        	    bat 'docker rmi wujiabo1985/gateway'
        	    bat 'docker rmi wujiabo1985/payment'
        	    bat 'docker rmi wujiabo1985/search'
        	    bat 'docker rmi wujiabo1985/security'
        	    bat 'docker rmi wujiabo1985/technology'
        	    bat 'docker rmi wujiabo1985/training'
        	    bat 'docker rmi wujiabo1985/user'
        	    bat 'docker image prune -f'
        	}
        }
    }
}