# API REST de Comandos Git

## Descripción del Proyecto 🚀
Una API REST construida con Spring que lista comandos principales de Git.

## Endpoints de la API 🌐

### Recurso de Comandos
```
GET    /api/commands      # Obtener todos los comandos
GET    /api/commands/{id} # Obtener comando específico
POST   /api/commands      # Crear nuevo comando
PUT    /api/commands/{id} # Actualizar comando
PATCH  /api/commands/{id} # Actualización parcial
DELETE /api/commands/{id} # Eliminar comando
```

### Ejemplo de Petición/Respuesta

#### Petición para Crear Comando

```markdown
![Ejemplo de Petición](/assets/postmanExample.png)
```

## Inicio Rápido 🚀

### Pasos de Instalación
1. Clonar el repositorio
```bash
git clone git@github.com:HardCoder05/APIREST-CRUD.git
```

2. Configurar base de datos
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clicommands
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

3. Construir el proyecto con Docker
```bash
docker-compose up -d
```

4. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

5. Probar con Postman

6. Usar Swagger UI: http://localhost:8080/swagger-ui/index.html

## Mejoras Futuras 🔮
- [ ] Autenticación/Autorización
- [ ] Categorías de comandos
- [ ] Funcionalidad de búsqueda
