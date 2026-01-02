# NEWS PORTAL - Full Stack Project

Aplicacion portal de noticias permite la gestion de noticias y administracion de favoritos, desarrollado con una arquitectura hexagonal utilizando **Spring Boot**, **Angular**, **MySQL** y **Docker**.

## 📦 Estructura del Proyecto

```
fullstack-MediCenter/
├── newsportal-app-backend/      # Api para la gestion del sistema
├── newsportal-app-database/
│   └── sql/                     # Scripts y stored procedures
├── newsportal-app-frontend/     # Interfaz de usuario (Angular)
├── docker-compose.yml
```

## 🚀 Tecnologías Usadas

- Spring Boot 3 (Java 21)
- Angular
- MySQL 8
- Docker + Docker Compose

## 🐳 Cómo levantar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/jborbor/fullstack-NewsPortalApp.git
cd fullstack-newsportalapp
```

2. Levanta los contenedores:

```bash
docker compose up --build
```

Esto levantará:

- La base de datos MySQL
- Ejecutara automaticamente los scripts de creacion de BD, stored procedures, etc:
- Los microservicios backend
- El frontend Angular (vía NGINX)

## 📦 Documentacion de laS api con OpenApi

http://localhost:8080/api/v1/swagger-ui/index.html

## 📬 Contacto

Proyecto desarrollado por [].
