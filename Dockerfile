# create a dockerfile for a java spring boot application using alpine java 17 base image
# pull the base image
FROM adoptopenjdk/openjdk17:alpine-jre
# workdir /app
WORKDIR /app
# copy the jar file to the container
COPY target/*.jar ./app.jar
# expose port 8080
EXPOSE 8080
# run the jar file
ENTRYPOINT ["java","-jar","app.jar"]

