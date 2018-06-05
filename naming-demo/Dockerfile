FROM openjdk
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/naming-service.jar naming-service.jar
ENTRYPOINT ["java", "-jar", "/naming-service.jar"]
EXPOSE 8761