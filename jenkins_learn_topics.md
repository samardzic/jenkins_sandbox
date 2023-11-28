
## how to get all the jenkins users through api




<br/><br/>


## Calling te _class - $class syntax in jenkins scripted dsl

[All classes list](https://javadoc.jenkins.io/allclasses.html)

As an example, you can write a Pipeline script:

```
node {
    sh 'make something'
    step([$class: 'ArtifactArchiver', artifacts: 'something'])
}
```

- Here we are running the standard Archive the artifacts post-build action (hudson.tasks.ArtifactArchiver), 
and configuring the Files to archive property (artifacts) to archive our file something produced in an earlier step. 
- The easiest way to see what class and field names to use is to use the Snippet Generator feature in the Pipeline configuration page.

See the [compatibility list](https://github.com/jenkinsci/pipeline-plugin/blob/master/COMPATIBILITY.md#build-steps-and-post-build-actions) for the list of currently supported steps.


Often when looking at scripted jenkins pipeline code, I see this pattern...
```
step([$class: 'GitHubSetCommitStatusBuilder',
        statusMessage: [content: 'Pipeline Started']])
```

<br/><br/>


## Importing

Get all the Jenkins user using the below code in jenkinsfile:-

```
import hudson.model.User

User.getAll().each { user ->
   println user
}
```


<br/><br/>


## ansiColor('xterm')

```
stage('Unit Test') {
    steps {
        ansiColor('xterm'){
          sh '''
          npm test
          # this is a comment in sh
          '''
        }
    }
}
```


## Email

```
post {
    success {
      mail to: "XXXXX@gmail.com", 
      subject:"SUCCESS: ${currentBuild.fullDisplayName}", 
      body: "Yay, we passed."
    }
    failure {
      mail to: "XXXXX@gmail.com", 
      subject:"FAILURE: ${currentBuild.fullDisplayName}", 
      body: "Boo, we failed."
    }
  }
```


## Comments

```
pipeline { ...     
	stage('Set Tagging') 
		{steps 
			{sh '''
				echo "env.m_time='$m_time'" > ${params_file}
				echo "env.m_comp_tag='${BRANCH_NAME}_${m_time}_${BUILD_NUMBER}'" >> ${params_file}                               
				/* echo "env.docker_ws='/usr/local/lib/node_modules/${repo}'" >> ${params_file} */         
				'''
				<
```


- Block comment
```
/*  
post {
    success {
      mail to: "XXXXX@gmail.com", 
      subject:"SUCCESS: ${currentBuild.fullDisplayName}", 
      body: "Yay, we passed."
    }
    failure {
      mail to: "XXXXX@gmail.com", 
      subject:"FAILURE: ${currentBuild.fullDisplayName}", 
      body: "Boo, we failed."
    }
  }
*/
```



- Single Line comments
```
// post {
//     success {
//       mail to: "XXXXX@gmail.com", 
//       subject:"SUCCESS: ${currentBuild.fullDisplayName}", 
//       body: "Yay, we passed."
//     }
//     failure {
//       mail to: "XXXXX@gmail.com", 
//       subject:"FAILURE: ${currentBuild.fullDisplayName}", 
//       body: "Boo, we failed."
//     }
// }
```



- Comment in 'sh' command
```
stage('Unit Test') {
    steps {
        ansiColor('xterm'){
          sh '''
          npm test
          # this is a comment in sh
          '''
        }
    }
}
```