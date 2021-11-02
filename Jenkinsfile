pipeline {
  agent any
   tools {
    maven 'maven3'
  }
  stages {
    stage('Tests tools') {
      parallel {
        stage('Tests tools') {
          steps {
			
            sh '''java --version
			mvn --version
			git --version'''
          }
        }

        stage('check pom.xml') {
          steps {
            fileExists 'pom.xml'
          }
        }

      }
    }

    stage('compile') {
      steps {
        sh 'mvn clean compile test package'
      }
    }
   
    stage ('Dynamic Analysis - DAST with OWASP ZAP') {
      steps {
	    sh "docker run -t owasp/zap2docker-stable zap-baseline.py --networks devnet --link ecomapp -t http://172.18.0.2:8082 || true"
	  }
		
	}
    stage('Post Build steps') {
        steps {
          writeFile(file: 'status.txt', text: 'hey it worked')
        }
    }
	
  }
  
}