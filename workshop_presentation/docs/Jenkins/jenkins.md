## Jenkins Presentation

## Introduction 

- Jenkins is automation server
- Jenkins is Java based Continuous Build System. 
- Jenkins is open source tool under MIT licence
- It is used to automate various tasks related to building, testing, delivering or deploying software.
- Main implementation is in area od Continuous Integration and Continuous Delivery of projects
- 2005 Hudson as a precursor of Jenkins was created by Kohsuke Kawaguchi
- 2010 Jenkins was forked from Hudson Project after a dispute with Oracle. 
- Supported by over 400 plugins
- Under development since 2005
- There is a large support community and thorough documentation

<br/>



## Main usage scenarios

You can orchestrate application deployments using Jenkins with a wide range of freely available community plugins and native Jenkins workflows.
There are a vast array of plugins available to Jenkins
You can integrate Jenkins with a number of testing and deployment technologies
software testers who would like to learn how to build and test their projects continuously 

Jenkins Use Cases
The following are the main Jenkins use cases from my experience extensively working on Jenkins.
    Continuous Integration: With Jenkins pipelines, we can achieve CI for both applications and infrastructure as code.
    Continuous Delivery: You can set up well-defined and automated application delivery workflows with Jenkins pipelines.
    Automation & Ad-Hoc Tasks: With Jenkins jobs and pipelines, you can automate infrastructure components and perform ad-hoc infrastructure tasks (Backups, remote executions, etc.). 
    
  
Options 	Description
Freestyle Project 	Freestyle Project in Jenkins is an improvised or unrestricted build job or task with multiple operations. Operations can be a build, pipeline run, or any script run.
Pipeline 	Pipeline demonstrates long-running activities that contain multiple build agents. It is suitable for running pipelines that cannot run through normal freestyle type jobs.

<br/>


## Continuous Integration

Continuous Integration: is a software development practice where developers 
regularly merge their code changes into a central repository, after which 
automated builds and tests are run.

Continuous Integration (CI) is a software development practice where developers 
regularly merge their code changes into a central code repository, after which 
automated builds and tests are run. CI helps find and address bugs quicker, improve 
software quality, and reduce the time it takes to validate and release new software 
updates. 

 “Continuous Integration is a software development practice 
where members of a team integrate their work frequently, 
usually each person integrates at least daily - leading to 
multiple integrations per day. Each integration is verified by 
an automated build (including test) to detect integration 
errors as quickly as possible” – Martin Fowler

<br/>


## Continuous Delivery

Continuous Delivery: is a software development practice where code changes 
are automatically built, tested, and prepared for a release to production.

Continuous Delivery
Continuous delivery is a software development practice where code changes are 
automatically prepared for a release to production. A pillar of modern application 
development, continuous delivery expands upon continuous integration by deploying all 
code changes to a testing environment and/or a production environment after the build 
stage. When properly implemented, developers will always have a deployment-ready 
build artifact that has passed through a standardized test process. 
Continuous delivery lets developers automate testing beyond just unit tests so they can 
verify application updates across multiple dimensions before deploying to customers. 
These tests may include UI testing, load testing, integration testing, API reliability 
testing, etc. This helps developers more thoroughly validate updates and pre-emptively 
discover issues. With the cloud, it is easy and cost-effective to automate the creation 
and replication of multiple environments for testing, which was previously difficult to do 
on-premises. 

<br/>


## Other

Infrastructure as Code: is a practice in which infrastructure is provisioned and 
managed using code and software development techniques, such as version 
control, and continuous integration.

Monitoring and Logging: enables organizations to see how application and 
infrastructure performance impacts the experience of their product’s end user.
