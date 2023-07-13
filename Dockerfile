FROM openjdk:17
ADD target/backend.app-0.0.1-SNAPSHOT.jar backend-applicaton.jar
ENTRYPOINT ["java","-jar","backend-applicaton.jar"]
