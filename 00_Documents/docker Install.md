## Install docker engine from binaries

<br/>

## Intro

- Docker project has upstream project, also downstream product. Anyone or company could develop his own product based on the core parts.
So microsoft together with docker company develop their downstream product on windows 10 called docker for windows, it will use docker ce as core part.

Then, in short:
- docker.exe: 
	- the docker client provided for user to communicate with docker engine. 
	- You can use it to do docker pull, docker run etc docker actions.
- dockercli.exe: 
	- the tool provided by docker for windows for user to communicate with docker for windows. 
	- You can use it to switch to linux-container-mode/windows-container-mode etc.

Additional:
- docker -v shows the core part that's Docker CE's version while dockercli.exe -Version shows the docker for windows's version.


### Download Docker Binaries

- Download from : https://download.docker.com/win/static/stable/x86_64/

<br/>


### Install server and client binaries on Windows

- [Howto link](https://docs.docker.com/engine/install/binaries/)


Run PowerShell commands:

1. Extract the archive to your program files:
```
C:\> Expand-Archive /path/to/<FILE>.zip -DestinationPath $Env:ProgramFiles
```

2. Register the service and start the Docker Engine:
```
C:\> &$Env:ProgramFiles\Docker\dockerd --register-service
C:\> Start-Service docker
```

3. Verify that Docker is installed correctly by running the ```hello-world``` image.
```
C:\> &$Env:ProgramFiles\Docker\docker run hello-world:nanoserver
```

- REMOVE DOCKER SERVICE
```
C:\> Get-Service -DisplayName "Docker Engine" | Remove-Service
```

<br/>



### Get Local Users

Execute in PS:
```
Get-LocalGroupMember -Group "Administrators"

OUTPUT IS:
	ObjectClass Name                            PrincipalSource
	----------- ----                            ---------------
	Group       CW01\nsa1_DSAdminUser           ActiveDirectory
	User        CW01\uia66114                   ActiveDirectory
	Group       CW01\WW_OR_ClientAdministration ActiveDirectory
	Group       NHL2283W\docker-users           Local
	User        NHL2283W\RenamedAccount         Local
	User        NHL2283W\RenamedAdmin           Local
```

<br/>



### Docker Access Helper

- [Git Source](https://github.com/tfenster/dockeraccesshelper)

1. PowerShell module that allows access to the Docker engine. Install it using
```
Install-Module -Name dockeraccesshelper
```


2. After that import it and use it to give access to any user
```
PS C:\Windows\system32> Import-Module dockeraccesshelper
PS C:\Windows\system32> Add-AccountToDockerAccess "CW01\uia66114"
```

- NOTE:
If running PowerShell 7 or newer

Newer versions of PowerShell do not support the classes/methods currently used by dockeraccesshelper. 
If you face errors like Method invocation failed because [System.IO.DirectoryInfo] does not contain a method named 'GetAccessControl'., you can work around this by:
temporarily switch to PowerShell 5.1 (or earlier) use PowerShell ISE to execute the manual commands












