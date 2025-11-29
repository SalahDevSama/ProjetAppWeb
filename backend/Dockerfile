FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests
RUN mv target/contact_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]