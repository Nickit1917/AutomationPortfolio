pipeline {
  agent any
  stages {
    stage('TestNG Execution') {
      steps {
        bat 'set "maven_home=C:\\apache-maven-3.9.2"  set "PATH=%maven_home%\\bin;%PATH%"  cd C:/AutomationPortfolio/  mvn test -DsuiteXmlFile=C:\\AutomationPortfolio\\TestNG.xml'
      }
    }

  }
}