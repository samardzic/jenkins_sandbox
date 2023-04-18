Jenkins + Java Maven (testng) - CI setup
============================

## Plugins installed on Jenkins

1. TestNG Results Plugin


2. HTML Publisher plugin


3. Maven Info Plugin


4. Maven Integration
5. Maven Invoker Plugin
6. Maven Release Plug-in Plug-in
7. Maven Repository Sceduled Cleanup Plugin
8. Maven Repository Server Plugin
9. Repository Connector


## Extent report setup

Install HTML Report Publisher. At first build, you will see that display of your extent report isn't good and beautiful. (no css, no scripts etc.). You have to write this command in your Jenkins path example: C:/jenkins/
```bash
java -Dhudson.model.DirectoryBrowserSupport.CSP="" -jar jenkins.war
```

Run the command in Manage Jenkins > Script Console:
```bash
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
```

## Create Jenkins Job
**New Item** button generates New Item.

Choose **Maven Project**

Go to **Build** section:

1. Root POM: set path to your project's pom.xml
2. Goals and options: set command **clean install**
3. Click on **Advance** and check option **Use custom workspace**
4. Directory: set path to your project
5. Post-build Actions: Add **Publish HTML reports** and **Publish TestNG Results**

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


