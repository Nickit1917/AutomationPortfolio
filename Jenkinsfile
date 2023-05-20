pipeline {
  agent any
  stages {
    stage('TestNG Execution') {
      steps {
        sh '''cd C:\\AutomationPortfolio

C:\\apache-maven-3.9.2\\bin\\mvn clean test -DsuiteXmlFile=C:\\AutomationPortfolio\\src\\test\\java\\com\\example\\demo\\resources\\TestNG.xml'''
      }
    }

  }
}