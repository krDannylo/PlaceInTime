# Use a imagem oficial do OpenJDK 25
FROM openjdk:25-jdk-slim

# Definir diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR do projeto
COPY target/PlaceInTime-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Definir variáveis de ambiente
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando para executar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
