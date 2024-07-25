
    def getCurrentTimeFormatted() {
        def currentTime = new Date()
        def formattedTime = currentTime.format('yyyyMMdd_HHmm_')
        echo "${formattedTime}"
        return formattedTime
    }
        
    def zipReportsFolder(String folderToZip){
        env.ZIP_NAME = "${getCurrentTimeFormatted()}Report.zip"
        zipReport = "${env.WORKSPACE}\\${env.ZIP_NAME}"
        powershell """
            Compress-Archive -Path '${folderToZip}/*' -DestinationPath '${zipReport}'
        """
        return zipReport
    }
        
    def clearFolder(String folderName){
        bat """
            del /Q ${folderName}\\*
        """
        echo "Cleared contents of ${folderName}"
    }
    
    def deleteOldReports(){
        bat """
            del /Q "${env.WORKSPACE}\\*.zip"
        """
    }
    
    def startSequencer(){
         bat """
            cd 00_Sequencer\\Application
            SequencerCMD testToRunID=${TEST_ID} enableLog=true logLocation="${LOGGING_PATH}" reportFile="${REPORTS}\\${REPORT_FILE}"
            exit 0
         """
    }
    
pipeline {
    agent {label 'NHD1962W'}
    
    environment {
        BINARIES = "${env.WORKSPACE}\\01_Binaries"
        REPORTS  = "${env.WORKSPACE}\\03_Reports"
    }

    stages {
        stage('Workspace cleaning') {
            steps {
                clearFolder(env.BINARIES)
                clearFolder(env.REPORTS)
                deleteOldReports()
                
                echo "Workspace cleared"
            }
        }
        stage('Automated flashing and tests'){
            steps{
                startSequencer()
                
                echo "Automated tests executed"
            }
        }
		stage('Publish HTML Report') {
            steps {
                script {
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        includes: "**/*.html",
                        reportDir: '03_Reports',
                        reportFiles: "${env.REPORT_FILE}",
                        reportName: "VV SysTest - ${env.REPORT_FILE} report"])
                }
            }
        }
        stage('Prepare reports for sharing'){
            steps{
                script{
                    env.ZIP_REPORT = zipReportsFolder(env.REPORTS)
                }
                
                echo "stage ZIP_REPORT path: ${env.ZIP_REPORT}"
                echo "Report files zipped"
            }
        }
    }
    post{
        success{
            emailext body: '''
Hello everyone,

Testing of the latest build has passed and you can check the logs at:
$BUILD_URL
 
Best Regards,
VV team''',
                presendScript: '''import javax.mail.Message.RecipientType
                import javax.mail.Address
                import javax.mail.internet.InternetAddress
                import javax.mail.internet.MimeMessage
                msg.setFrom("uic80119@contiwan.com")''', 
                subject: 'PASSED', 
        		attachmentsPattern: "*.zip",
                to: 'milos.neskovic@continental-corporation.com'
        }
        failure {
            emailext body: '''
Hello everyone,

Testing of the latest build has failed and you can check the logs at:
$BUILD_URL
 
Best Regards,
VV team''',
                presendScript: '''import javax.mail.Message.RecipientType
                import javax.mail.Address
                import javax.mail.internet.InternetAddress
                import javax.mail.internet.MimeMessage
                msg.setFrom("uic80119@contiwan.com")''',
                subject: 'FAILED', 
        		attachmentsPattern: "*.zip",
                to: 'milos.neskovic@continental-corporation.com'
        }
    }
}