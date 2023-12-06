@Library(['Common']) _

DEFAULT_SINDRI_NAMESPACE = 'sindri-v2-2'
DEFAULT_SINDRI_WORKSPACE = 'v2-2'

pipeline {
  agent { label 'default' }
  triggers {
    cron('TZ=Asia/Calcutta\n40 5 * * 1-5')
  }

  options {
    ansiColor('xterm')
    timeout(time: 60, unit: 'MINUTES')
  }

  parameters {
     choice(name: 'ENVIRONMENT', choices: ['Integration Dev-2.2A', 'CICD CICD-2.2A'], description: 'Target environment')
  }

  environment {
    COMMIT_HASH = sh (
      script: 'git rev-parse --short HEAD',
      returnStdout: true
    ).trim()
    VERSION = sh (
      script: 'cat VERSION',
      returnStdout: true
    ).trim()
    IMAGE_NAME = 'sindri-ui-test-automation'
    AWS_CREDENTIALS_ID = 'aws-SA_sindri_deployment'
    PROJECT_NAME = 'sindri'
    IMAGE_TAG = "${VERSION}-${COMMIT_HASH}"
    IMAGE = "${REPO_CD_HOSTNAME}/${PROJECT_NAME}/${IMAGE_NAME}:${IMAGE_TAG}"
    ROOT = "${PWD}/overlays/${ENVIRONMENT}"
    DEPLOY_TOOLS_IMAGE = 'harbor.registry.prod.cdsf.io/sindri/cloud/continental/sindri/sindri-kubectl:latest'
    K8S_TOOLSET_IMAGE = 'cloud/continental/builds/k8s-toolset:1.17'
    REPO_CD_PUSH_CREDENTIALS_ID = 'harbor-robot-sindri'
    DEFAULT_SINDRI_CONFIG_BUCKET = 'sindri-config-bucket'
    AWS_REGION = 'eu-central-1'
    DOCKER_COMPOSE_PROJECT_NAME = 'sindri-ui-test-automation'

    STABLE_BRANCH = 'SINDRI-11018'



    ROLE = 'Integration'
    LOWER_ROLE = 'integration'
    ACCOUNT_ID = '082461646758'
  }

  stages {
 

    stage('Test run down') {
      steps {
         sshagent (credentials: ['gitlab-jenkins-ssh']) {
                   // sh "make IMAGE_NAME=${IMAGE_NAME} IMAGE_TAG=${IMAGE_TAG} build "
                   sh """
                    cd local/
                    docker-compose ps
                    docker-compose -f docker-compose.yaml -p ${DOCKER_COMPOSE_PROJECT_NAME} down
                    docker ps -a
                    docker ps
                    """
           }
      }
    }
 } 

 
 post {
    success {
      script {
        if (env.BRANCH_NAME == "${STABLE_BRANCH}" || env.BRANCH_NAME == "v*" || env.BRANCH_NAME.startsWith('MR') || env.IMAGE_TAG != null) {
          slackSend color: 'danger', channel: '#sindri-cicd', message: ":jenkins-devil: Jenkins ${env.JOB_NAME} Job : success ! (<${env.BUILD_URL}|#${env.BUILD_NUMBER}>) :jenkins-devil:"
        }
      }
    }
 } 
}