pipeline {
    agent any
  
    stages {
        stage('Test') {
            steps {
                bat "mvn -D clean test"
            }
  
            post {                
                 
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                failure {
                echo "Build failed. Publishing Extent Reports..."
                  publishExtentReports()
                }
                               
                success {
                 publishExtentReports()
                }
            }
        }
    }
}

def publishExtentReports() {
   				 // Publish Extent Reports using HTML Publisher plugin
    
    			
   			 	publishHTML([
                              allowMissing: false, 
                              alwaysLinkToLastBuild: false, 
                              keepAll: false, 
                              reportDir: 'test-output/ExtentReports', 
                              reportFiles: 'MyReport.html', 
                              reportName: 'Tutorialsninja test results', 
                              reportTitles: '', 
                              useWrapperFileDirectly: true])
 }