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
        always {
            script {
                // Publish Extent Reports using HTML Publisher plugin
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true, // Link to the latest build
                    keepAll: false, // Do not keep HTML reports from previous builds
                    reportDir: 'test-output/ExtentReports', // Directory where Extent Reports are generated
                    reportFiles:'Extent Report', // Extent Report file name
                    reportName: 'Extent Report', // Name displayed in Jenkins
                    useWrapperFileDirectly: false
                ])
            }
        }
    }
  
    
}
