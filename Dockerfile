FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
MAINTAINER  Maxim Morev <maxmorev@gmail.com>
RUN mkdir /opt/app
WORKDIR /opt/app
COPY build/libs/aws-ses-rest-api-0.0.1.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/aws-ses-rest-api-0.0.1.jar"]