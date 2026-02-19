# inDriverApp - Full Stack Project

Aplicación inDriver para gestión usuarios y conductores, desarrollada con **Spring Boot**, **React Native (Expo)**, **MySQL** y **Docker**.

## 📦 Estructura del Proyecto

```
fullstack-InDriverApp/
├── indriver-backend-sb/         # API backend (Spring Boot)
├── indriver-frontend-rn/        # App móvil (React Native)
├── docker-compose.yml           # Orquestación de servicios
```

## 🚀 Tecnologías Usadas

- Spring Boot 4 (Java 17)
- React Native (Expo, TypeScript)
- MySQL 8
- Docker + Docker Compose

## 🐳 Cómo levantar el proyecto

1. Clona el repositorio:

```bash
git clone
cd fullstack-InDriverApp
```

2. Levanta los servicios con Docker Compose:

```bash
docker compose up --build
```

Esto levantará:

- La base de datos MySQL
- El backend Spring Boot

3. Para el frontend móvil:

```bash
cd indriver-frontend-rn
npm install
npm start
# o usa 'expo start' para abrir en emulador o dispositivo
```

## 📖 Documentación de la API

Si tienes Swagger/OpenAPI habilitado:
http://localhost:8080/swagger-ui/index.html

## 📬 Contacto

Proyecto desarrollado por Jonathan Borbor.
