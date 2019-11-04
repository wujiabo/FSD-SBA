# FSD-SBA
Mentor On Demand (FSD SBA) v3.0


1. FrontEnd Source code

    FSD-SBA/frontend

2. Mid Tier Source code of all Microservices

    9001    registry

    9002    gateway

    8001    payment

    8002    search

    8003    security

    8004    technology

    8005    training

    8006    user

3. Screen shots of Usage of Post Man tool to test each End Point of all Microservices

    Use Talend API TESTER.
    
    TalendAPITESTER1.jpg
    
    TalendAPITESTER2.jpg
    
4. Few Steps on how to run the solution.

    mvn clean package

    mvn dockerfile:build
    
    docker run -d --name=sba-registry -p 9001:9001 wujiabo1985/registry:latest
    
    docker run -d --name=sba-gateway --link sba-registry -p 9002:9002 wujiabo1985/gateway:latest
    
    docker run -d --name=sba-payment --link sba-registry -p 8001:8001 wujiabo1985/payment:latest
    
    docker run -d --name=sba-search --link sba-registry -p 8002:8002 wujiabo1985/search:latest
    
    docker run -d --name=sba-security --link sba-registry -p 8003:8003 wujiabo1985/security:latest
    
    docker run -d --name=sba-technology --link sba-registry -p 8004:8004 wujiabo1985/technology:latest
    
    docker run -d --name=sba-training --link sba-registry -p 8005:8005 wujiabo1985/training:latest
    
    docker run -d --name=sba-user --link sba-registry -p 8006:8006 wujiabo1985/user:latest

5. Test code of Angular and Mid Tier need to be included

    Run ng test to execute the frontend test
    
    Run mvn clean test to execute the backend test

6. Jmeter’s JMX file to test atleast one REST End point, and Screenshot of report
    
    sba-jmeter.jmx
    
    sba-jmeter.jpg
    
7. Dockerfile

    FSD-SBA/registry/Dockerfile

    FSD-SBA/gateway/Dockerfile

    FSD-SBA/payment/Dockerfile

    FSD-SBA/search/Dockerfile

    FSD-SBA/security/Dockerfile

    FSD-SBA/technology/Dockerfile

    FSD-SBA/training/Dockerfile

    FSD-SBA/user/Dockerfile

8. Jenkinsfile or Jenkins UI ScreenShot

    FSD-SBA/Jenkinsfile

9. URL where the Project is deployed

    http://localhost:4200/

