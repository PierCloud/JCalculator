FROM java:8
ADD /target/JCalculator-1.0-SNAPSHOT.jar JCalculator.jar
ENTRYPOINT ["java","-jar","JCalculator.jar"]