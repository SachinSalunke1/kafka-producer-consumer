FROM openjdk:11
EXPOSE 8080
ADD target/kafka-producer-consumer-workflow.jar kafka-producer-consumer-workflow.jar
ENTRYPOINT ["java",".jar","/kafka-producer-consumer-workflow.jar"]