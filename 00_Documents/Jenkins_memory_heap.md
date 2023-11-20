# Jenkins Heap

## Heap Info

- There are two types of ```OutOfMemoryError``` messages that you might encounter while a Jenkins job runs:
    - ```java.lang.OutOfMemoryError: Heap space``` – this means that you need to increase the amount of heap space allocated to Jenkins when the daemon starts.
    - ```java.lang.OutOfMemoryError: PermGen space``` – this means you need to increase the amount of generation space allocated to store Java object metadata. 
      Increasing the value of the ```-Xmx``` parameter will have no affect on this error.

- On Ubuntu 12.04 LTS, uncomment the ```JAVA_ARGS``` setting on line ten of ```/etc/default/jenkins```:
	- To add more Java heap space, increase the value of the ```-Xmx``` Java parameter. That sets the maximum size of the memory allocation pool (the garbage collected heap).
    - To add more PermGen space, add the parameter ```XX:MaxPermSize=512m``` (replace 512 with something else if you want more. The permanent generation heap holds meta information about user classes.

- For example, this extract is from the default /etc/default/jenkins after a fresh install of Jenkins:
```
# arguments to pass to java
#JAVA_ARGS="-Xmx256m"
```
This is how it would look if you set the heap space to be 1 GB:
```
# arguments to pass to java
JAVA_ARGS="-Xmx1048m"
```
Be careful not to set the heap size too large, as whatever you allocate reduces the amount of memory available to the operating system and other programs, which could cause excessive paging (memory swapped back and forth between RAM and the swap disc, which will slow your system down).

If you also set ```MaxPermSpace```, you need to add a space between the parameters):

```
# arguments to pass to java
JAVA_ARGS="-Xmx1048m -XX:MaxPermSize=512m"
```

After making a change, ```restart Jenkins gracefully``` from the Jenkins web interface, or force an immediate restart from the command-line with ```sudo /etc/init.d/jenkins restart```.

I found the following site useful for understanding Java maximum and permanent generation heap sizes: 
- http://www.freshblurbs.com/blog/2005/05/19/explaining-java-lang-outofmemoryerror-permgen-space.html.

<br/>



## First Heap settings error

My Jenkins does not want to start with parameters
```
-Xrs -Xmx2048m -XX:MaxPermSize=512m -Dhudson.lifecycle=hudson.lifecycle.WindowsServiceLifecycle -jar "%BASE%\jenkins.war"
 --httpPort=8080
``` 
in jenkins.xml file. 

<br/>


I also added JENKINS_HOME variable to windows variables and set path to my jenkins folder c:\Program Files (x86)\Jenkins. But it does not help. I see in the log file error.


Response:
Most likely you are using 32-bit JVM on Windows. 
This has a heap limit of about 1.2 - 1.5 GB depending on what you have run before.
I suggest either limiting yourself to ```-Xmx1200m``` or use a 64-bit JVM.

If you increase the PermGen, you need to decrease the heap size as the amount of virtual memory you can have in 32-bit windows is limited.

<br/>


## Second Heap settings error

```
"D:\java\bin\java"
-Xrs -Xms2048m -Xmx2048m -XX:MaxPermSize=512m -Dhudson.lifecycle=hudson.lifecycle.WindowsServiceLifecycle -jar "%BASE%\jenkins.war"
 --httpListenAddress=127.0.0.1 --httpPort=8080 --webroot="%BASE%\war"
```