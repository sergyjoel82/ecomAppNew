FROM  openjdk:11
MAINTAINER sergyjoel@yahoo.fr
COPY target/*.jar ecom-app-0.0.1.jar
ENTRYPOINT ["java","-jar","/ecom-app-0.0.1.jar"]