# Estágio 1: Build usando diretamente o JDK 25
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Instala o Maven manualmente
RUN apt-get update && apt-get install -y maven

# Copia apenas o pom.xml primeiro para aproveitar o cache das dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e compila de fato para a versão 25
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Runtime (Imagem final leve)
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copia o JAR do estágio de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 1001

# Configurações de performance para Java 25 (ZGC e Virtual Threads)
ENTRYPOINT ["java", "-XX:+UseZGC", "-Dspring.threads.virtual.enabled=true", "-Dspring.profiles.active=dev", "-jar", "app.jar"]