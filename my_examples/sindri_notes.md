### WebPortal repo token:

```
e3f4235afcc86281f2a67bb9484dfde8ae1e8bae
```
<br/>



### DCL

```
git clone -b docker_dcl 
https://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:x-oauth-basic@github.com/samardzic/dcl_automation.git 
/dcl_automation/
```
<br/>



### Sindri clone

```
git clone -b dev_v22A_version2 
https://e3f4235afcc86281f2a67bb9484dfde8ae1e8bae:x-oauth-basic@github.geo.conti.de/uie21143/sindri_webPortal.git
```
<br/>


### Sindri pull

```
git pull 
https://e3f4235afcc86281f2a67bb9484dfde8ae1e8bae:x-oauth-basic@github.geo.conti.de/uie21143/sindri_webPortal.git
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