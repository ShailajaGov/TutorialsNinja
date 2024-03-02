pipeline {
    agent any
  
    stages {
        stage('Test') {
            steps {
                bat "mvn clean test"
            }
        }
    }
  
    post {                
        failure {
            publishHTML([
                allowMissing: false, 
                alwaysLinkToLastBuild: false, 
                keepAll: false, 
                reportDir: 'test-output/ExtentReports', 
                reportFiles: 'MyReport.html', 
                reportName: 'Tutorialsninja test results', 
                reportTitles: '', 
                useWrapperFileDirectly: true
            ])
        }
                               
        success {
            publishHTML([
                allowMissing: false, 
                alwaysLinkToLastBuild: false, 
                keepAll: false, 
                reportDir: 'test-output/ExtentReports', 
                reportFiles: 'MyReport.html', 
                reportName: 'Tutorialsninja test results', 
                reportTitles: '', 
                useWrapperFileDirectly: true
            ])
        }
    }
}
