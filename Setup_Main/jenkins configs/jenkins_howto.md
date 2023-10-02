# Jenkins setup

<br/>

This howTo will cover Jenkins automation server setup for:

- Java Maven (testng)
- Python with pyTest runner

<br/>

## Jenkins Credentials NHD1965W

- Jenkins Access URL for the NHD1965W/uib54845 PC:
[http://NHD1965W:9000/](http://NHD1965W:9000/)


```
UserName: Admin
Password: Sindri007

UserName: NenadS
Password: nenad_secret


UserName: Adrian_Roman
Password: Adi_MySecret


UserName: generic_jenkins_user
Password: generic_password
```

<br/> <br/>

## Jenkins credencials NHD1906P

- Jenkins Access URL for the NHD1906/uib54845 PC:
[http://NHD1906:9000/](http://NHD1906:9000/)


```
UserName: Admin
Password: Sindri007


UserName: generic_user
Password: generic_password
```

<br/> <br/>


## Python solution

### Plugins installed on Jenkins

Apache HttpComponents Client 4.x API Plugin

1. Ant Plugin
2. Authentication Tokens API Plugin
3. Folders Plugin
4. Git client plugin
5. Git plugin
6. HTML Publisher plugin
7. JSch dependency plugin
8. LDAP Plugin
9. PAM Authentication plugin
10. Pipeline: SCM Step
11. Plain Credentials Plugin
12. SSH Credentials Plugin


<br/> <br/>


## HTML Publisher Hudson.CSP fix

Install HTML Report Publisher.

This fix is related to correcting missing basic formatting (no css, no scripts etc.) in HTML reports. <br/> <br/>




### Complete fix

<br/>

- [Hudson Fix source](https://kb.froglogic.com/squish/integrations/jenkins/content-security-policy-csp-web-report/)


First, we need to set Jenkins parameters in ```Windows system path variables```:

```
JENKINS_HOME
c:\Users\uia66114\.jenkins

JENKINS_JAVA_OPTIONS
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
```

<br/>

Also, we need to add additional parameters in Jenkins RUN command:

```
java -Dhudson.model.DirectoryBrowserSupport.CSP="" -jar jenkins.war --enable-future-java --httpPort=9000
```

<br/>

Here is an example of complete Jenkins run script:

```
@echo off

set JENKINS_PORT_ID=9000
set JENKINS_LOCATION=d:\opt\Jenkins
set JENKINS_PORT=--httpPort=9000
set JENKINS_OPTIONS=--enable-future-java
set HUDSON_CSP=-Dhudson.model.DirectoryBrowserSupport.CSP="sandbox allow-same-origin allow-scripts; default-src 'self'; script-src * 'unsafe-eval'; img-src *; style-src * 'unsafe-inline'; font-src * data:"
set HUDSON_CSP_SHORT=-Dhudson.model.DirectoryBrowserSupport.CSP=""



:: Starting JENKINS automation server
:: /************************************************************************************/
echo.
ECHO ===== Starting JENKINS automation server =====
echo.

echo.
ECHO ===== Navigate JENKINS localhost:%JENKINS_PORT_ID% =====
echo.



cd %JENKINS_LOCATION%

ECHO --- Jenkins server run ---
call java %HUDSON_CSP_SHORT% -jar %JENKINS_LOCATION%\jenkins.war %JENKINS_OPTIONS% %JENKINS_PORT%
:: call start cmd /k java -jar %JENKINS_LOCATION%\jenkins.war %JENKINS_OPTIONS% %JENKINS_PORT%
echo.
:: /************************************************************************************/
```
 






<br/>

### Temporary fix

Navigate to your Jenkins.war location and enter the following command: 


```
java -Dhudson.model.DirectoryBrowserSupport.CSP="" -jar jenkins.war
```

<br/>


Additionally, run the command in ```Jenkins Manage Jenkins > Script Console```:
```
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
```
<br/>









<br/> <br/>

## Java solution


### Plugins installed on Jenkins

1. TestNG Results Plugin
2. HTML Publisher plugin
3. Maven Info Plugin
4. Maven Integration
5. Maven Invoker Plugin
6. Maven Release Plug-in Plug-in
7. Maven Repository Sceduled Cleanup Plugin
8. Maven Repository Server Plugin
9. Repository Connector
10. Javadoc Plugin

<br/>

### Extent report setup

Install HTML Report Publisher. 
At first build, you will see that display of your extent report is missing basic formatting (no css, no scripts etc.). <br/> <br/>
We have to execute following command in Jenkins path ```example: C:/jenkins/```
```
java -Dhudson.model.DirectoryBrowserSupport.CSP="" -jar jenkins.war
```
<br/>

Additionally, run the command in ```Manage Jenkins > Script Console```:
```
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
```

<br/>

### Create Jenkins Job

**New Item** button generates New Item.

Choose **Maven Project**

Go to **Build** section:

1. Root POM: set path to your project's pom.xml
2. Goals and options: set command **clean install**
3. Click on **Advance** and check option **Use custom workspace**
4. Directory: set path to your project
5. Post-build Actions: Add **Publish HTML reports** and **Publish TestNG Results**

<br/>

### pom.xml confing


Add in a `pom.xml` file:
```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.18.1</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>mastertestng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

mastertestng.xml is our (all in one tests) test suite.
