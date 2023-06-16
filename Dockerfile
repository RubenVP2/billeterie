# Récupération de l'image Java
FROM eclipse-temurin:17.0.6_10-jdk

# Création du dossier de travail
WORKDIR /app

# Copie du jar dans le dossier de travail
COPY ./target/billeterie-0.0.1-SNAPSHOT.jar /app

# Exposition du port 8080
EXPOSE 8080

# Lancement de l'application
CMD ["java", "-jar", "billeterie-0.0.1-SNAPSHOT.jar"]