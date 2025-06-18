# MonsterShop 🛒👹

Backend para una tienda de monstruos desarrollado con **Java 21**, **Spring Boot** y **MySQL**. Gestiona productos y reseñas mediante una API RESTful.

## 📁 Requisitos previos

- Java 21
- Maven
- MySQL (con una base de datos llamada `monstershop`)
- IntelliJ IDEA (compatible con Spring Boot)
- Postman para probar la API

## ⚙️ Configuración del entorno

Clona el repositorio:
```bash
git clone https://github.com/debsrdev/monstershop.git
cd monstershop
```

Crea la base de datos en MySQL (importante para que se creen las tablas):
```sql
CREATE DATABASE monstershop;
```

Configura las credenciales en `application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/monstershop
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Instala las dependencias y compila el proyecto:
```bash
./mvnw clean install
```

Ejecuta el proyecto
```bash
./mvnw spring-boot:run
```

(para entornos en Mac)

## ▶️ Ejecución del proyecto

Desde IntelliJ, ejecuta la clase principal:
```
com.example.monstershop.MonsterShopApplication
```

O desde terminal:
```bash
./mvnw spring-boot:run
```

El backend estará disponible en:
```
http://localhost:8080
```

## Endpoints principales

- GET `/api/products` → Lista todos los productos
- GET `/api/products/{productId}` → Muestra un producto por ID
- POST `/api/products` → Crea un producto
```json
{
  "name": "Monstruo Amarillo",
  "price": 49.99,
  "imageUrl": "https://img.freepik.com/psd-gratis/ilustracion-lindo-monstruo_23-2150382868.jpg",
  "rating": 2.5,
  "reviewCount": 0,
  "featured": true
}
```
- PUT `/api/products/{productId}` → Actualiza un producto
```json
{
  "name": "Monstruo Azul",
  "price": 59.99,
  "imageUrl": "https://img.freepik.com/psd-gratis/monstruo-azul-divertido_23-2150497615.jpg",
  "rating": 4.3,
  "reviewCount": 3,
  "featured": false
}
```
- DELETE `/api/products/{productId}` → Elimina un producto

- GET `/api/reviews/{productId}` → Muestra las reviews de un producto
- POST `/api/reviews` → Añade una review
```json
{
  "username": "Carmen",
  "rating": 4,
  "body": "Muy simpático, aunque un poco caro.",
  "productId": 1
}

```

## Testing

Los tests están ubicados en `src/test/java/com/example/monstershop`.

Puedes ejecutarlos con:
```bash
./mvnw test
```
