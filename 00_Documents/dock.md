
## Stop all running docker containers

- You may face a situation where you are required to stop all running containers. 
- For example if you want to remove all containers in Docker, you should stop them beforehand.

```
docker kill $(docker ps -q)
docker stop $(docker ps -q)
docker rm $(docker ps -q)
```

```
docker ps -q | xargs docker stop
```

<br/>



## Image related containers

- Just replace the IMAGE_NAME by your docker image name and you should be able to stop all running containers associated with that image.

```
docker ps -q --filter ancestor=IMAGE_NAME | xargs docker stop
docker stop $(docker ps -qa --filter ancestor=IMAGE_NAME)
```


```
stage('Clean docker containers'){
    steps{
        script{        
            def doc_containers = sh(returnStdout: true, script: 'docker container ps -aq').replaceAll("\n", " ") 
            if (doc_containers) {
                sh "docker stop ${doc_containers}"
            }
            
        }
    }
}
```

<br/><br/>



## Script Examples

```
script {
    def disk_size = sh(script: "ssh remote-server df / --output=avail | tail -1", returnStdout: true).trim() as Integer
    println("disk_size = ${disk_size}")
}
```

```
stage('build') {
    steps {
        script {
            def disk_size = sh(script: "df / --output=avail | tail -1", returnStdout: true).trim() as Integer
            println("disk_size = ${disk_size}")
        }
    }
}
```

```
def getCommandOutput(cmd) {
    if (isUnix()){
         return sh(returnStdout:true , script: '#!/bin/sh -e\n' + cmd).trim()
     } else{
       stdout = bat(returnStdout:true , script: cmd).trim()
       result = stdout.readLines().drop(1).join(" ")       
       return result
    } 
}
```



<br/>

### Working examples

```
stage('Stop All docker containers'){
    steps{
        script{
            dir("$env.CUSTOM_WS") {
                containers_all = powershell(returnStdout: true, script: 'docker container ps -aq').trim()
                containers = containers_all.readLines().join(" ")
                if (containers) {
                    bat "docker stop ${containers}"
                }
            }
        }
    }
}
```