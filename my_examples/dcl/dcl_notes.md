## DCL project notes

### WebPortal repo token:

### DCL

```
git clone -b docker_dcl 
https://ghp_xx8bKOzrXfPc8FF5YFyoO7RTCRV1VK0kxxx:x-oauth-basic@github.com/samardzic/dcl_automation.git 
/dcl_automation/
```

<br/><br/>



### HTML publisher

<br/>

#### HTML Publisher inline configuration


```
HTML directory to archive:
c:\sindri_automation\sindri_webPortal\reports\html_reports\

Index page:
webPortal_report.html


Report title:
Sindri_WebPortal_VV_report

```

<br/>


#### HTML Publisher pipeline configuration

```
stage('Publish HTML report') {
    options {
        timeout(time: 120, unit: 'SECONDS')
    }
    steps {
        script {
            try {
                sleep(time:7, unit:'SECONDS')
                publishHTML([
                    allowMissing: false, 
                    alwaysLinkToLastBuild: false, 
                    keepAll: true, 
                    reportDir: 'c:\\sindri_automation\\sindri_webPortal\\reports\\html_reports\\', 
                    reportFiles: 'webPortal_report.html', 
                    reportName: 'Sindri_WebPortal_VV_report', 
                    reportTitles: ''
                ])
                echo 'HTML report Publish SUCCESS'
            } catch (err) {
                echo 'HTML report Publish FAILED'
                currentBuild.result = 'SUCCESS'
            }
        }
    }
}
```