# datum-solutions

An exercise of  RESTful app using SpringBoot.

This simple server acts a student-Service - it will return details of a student details.

Requirements
The fully fledged server uses the following:

SpringBoot
Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

Building the project
You will need:

Java JDK 8 or higher
Maven 3.1.1 or higher
Git
Clone the project and use Maven to build the server

$ mvn clean install
Deploying to the cloud
You can deploy the server to CloudFoundry using:

$ cf push UUIDLocator -p <jar>
Browser URL
Open your browser at the following URL for Swagger UI (giving REST interface details):