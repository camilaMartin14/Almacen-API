FROM openjdk:17

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR construido de tu aplicación Spring Boot al contenedor
COPY target/almacen-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que tu aplicación Spring Boot se ejecuta dentro del contenedor
EXPOSE 7979

# Comando para ejecutar tu aplicación Spring Boot cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]
