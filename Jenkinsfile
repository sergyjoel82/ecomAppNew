pipeline {
  agent any
  stages {
    stage('Tests tools') {
      parallel {
        stage('Tests tools') {
          steps {
            sh '''mvn --version
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

    stage('Post Build steps') {
      steps {
        writeFile(file: 'status.txt', text: 'hey it worked')
      }
    }

  }
}