# Stage 1: Build da aplicação
FROM eclipse-temurin:25-jdk-alpine AS build

# Instalar Maven
RUN apk add --no-cache maven

# Definir diretório de trabalho
WORKDIR /app

# Copiar arquivos do projeto
COPY pom.xml .
COPY src ./src

# Compilar o projeto e gerar o JAR
RUN mvn clean package -DskipTests

# Stage 2: Imagem final de execução
FROM eclipse-temurin:25-jdk-alpine

# Definir diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado no stage de build
COPY --from=build /app/target/PlaceInTime-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Definir variáveis de ambiente
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando para executar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
