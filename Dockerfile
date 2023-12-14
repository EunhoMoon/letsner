# Base image
FROM amazoncorretto:17

# Set the working directory
WORKDIR /app

# Copy Gradle build files
COPY build.gradle .
COPY settings.gradle .
COPY gradlew ./gradlew
COPY gradle ./gradle

# Copy source code
COPY src ./src

# Build the project
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

# Expose the application port
EXPOSE 5555

# Run the application
CMD ["java", "-jar", "build/libs/letsner.jar"]