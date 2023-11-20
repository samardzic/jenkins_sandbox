

30 01 * * 1-5

https://github.com/Genymobile/scrcpy.git
*/master


https://github.geo.conti.de/uia66114/jenkins_workshop.git
*/master

GitHub_creds_ID

cd c:\tmp
dir


<br><br>

------------------------------------------------------



http://127.0.0.1:8082/html_content/nikola.html

Nenads_DockerHub_ID
docker pull nsamardzic/python_selenium_chrome:chrome-96



Github_creds_ID


git branch: 'main', 
changelog: false, 
credentialsId: 'Github_creds_ID', 
poll: false, 
url: 'https://github.geo.conti.de/uie21143/sindri_webPortal.git'


cd /home/voyo/Build/dcl_automation/venv/bin/ 
pytest -v -m login ../../tests --env "test"



<br><br>

-------------------------------------------------------------




### Git Clone with oauth token

```
https://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:x-oauth-basic@github.com/samardzic/dcl_automation.git /dcl_automation/

git clone -b dev_v22A_version2 https://e3f4235afcc86281f2a67bb9484dfde8ae1e8bae:x-oauth-basic@github.geo.conti.de/uie21143/sindri_webPortal.git

e3f4235afcc86281f2a67bb9484dfde8ae1e8bae
```

<br><br>


### Sindri docker config

```
docker pull nsamardzic/python_selenium_chrome:chrome-96
docker stop sindri_webPortal_chrome && docker rm sindri_webPortal_chrome


docker run --publish 9006:9006 -t --detach --name sindri_webPortal_chrome nsamardzic/python_selenium_chrome:chrome-96
docker exec -it sindri_webPortal_chrome bash

git clone -b dev_v22A_version2 https://e3f4235afcc86281f2a67bb9484dfde8ae1e8bae:x-oauth-basic@github.geo.conti.de/uie21143/sindri_webPortal.git

cd sindri_webPortal
pip install -r requirements.txt

pytest -m jnkTest


docker cp sindri_webPortal_chrome:/sindri_webPortal/reports/html_reports/webPortal_report.html C:\sindri_automation\sindri_webPortal\reports\docker_reports
```


--------------------------------------------------------------

<br><br>


cd /Applications/Squish/bin

./squishrunner squishrunner --debugLog alpw --testsuite ~/sindri_mobile/suite_checklists --testcase tst_sindri_1855_complete_checklist_validation_not_ok_with_pdf


\\NHL9296W\




------------------------------------------------------------


```
agent { dockerfile true }


pipeline {
    agent { dockerfile true }
    stages {     

    stage('Scan') {
        steps{
            aquaMicroscanner imageName: 'aboullaite', notCompliesCmd: 'exit 4', onDisallowed: 'fail', outputFormat: 'html'
         }
       }  
    }
}

```


----------------------------------------------------------------





```
pipeline {
    agent any
    
    environment {
        WORKSHOP = "Jenkins Workshop"
    }

    stages {
        
        
        // stage("List Env Variables") {
        //     steps {
        //         echo "printenv"
        //         bat "set"
        //     }
        // }
        
        stage("Useing system Env variables") {
            steps {
                echo "BUILD_NUMBER = ${env.BUILD_NUMBER}"
                echo "JOB_NAME = ${env.JOB_NAME}"
            }
        }
        
        
        stage("Pipeline level Env variables") {
            steps {
                echo "Continental Workshop name = ${env.WORKSHOP}"
            }
        }
        
        
        stage("Stage level Env variables") {
            environment {
                PROJECT_NAME = "Sindri"
            }
            steps {
                echo "VV Automation project name = ${env.PROJECT_NAME}"
            }
        }
        
        
        
        
    }
}

```