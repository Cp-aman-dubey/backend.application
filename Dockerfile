FROM openjdk:8
EXPOSE 8081
ADD target/backend-applicaton.jar backend-applicaton.jar
ENTRYPOINT ["java","-jar","/backend-applicaton.jar"]
