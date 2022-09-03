FROM java:8 
RUN mkdir -p uo1/application
WORKDIR uo1/application 
COPY target/ . 
CMD ["java", "-jar", "spring-boot-actuator-example-0.0.1-SNAPSHOT.jar"]