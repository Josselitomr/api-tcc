# API TCC - Inventario

## Descripción
API REST para gestión de inventario de productos, desarrollada con Spring Boot siguiendo arquitectura hexagonal.

## Estructura del Proyecto

```
src/main/java/com/inventario/
├── application/
│   ├── service/      (Servicios de negocio)
│   └── port/         (Interfaces/Puertos)
├── domain/
│   ├── model/        (Entidades de dominio)
│   └── usecase/      (Casos de uso)
└── infrastructure/
    ├── controller/   (Controladores REST)
    ├── repository/   (Adaptadores de persistencia)
    └── persistence/  (Entidades JPA)
```

## Requisitos Previos
- Java 17+
- Maven 3.8+

## Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/Josselitomr/api-tcc.git
cd api-tcc
```

2. Compilar el proyecto:
```bash
mvn clean install
```

3. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## Endpoints

### Crear Producto
**POST** `/api/productos`

```json
{
  "nombre": "Laptop",
  "descripcion": "Laptop HP",
  "precio": 2500000,
  "stock": 10
}
```

**Respuesta (201 Created):**
```json
{
  "mensaje": "Producto registrado exitosamente"
}
```

### Obtener Todos los Productos
**GET** `/api/productos`

**Respuesta (200 OK):**
```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "descripcion": "Laptop HP",
    "precio": 2500000,
    "stock": 10
  }
]
```

### Obtener Producto por ID
**GET** `/api/productos/{id}`

**Respuesta (200 OK):**
```json
{
  "id": 1,
  "nombre": "Laptop",
  "descripcion": "Laptop HP",
  "precio": 2500000,
  "stock": 10
}
```

### Actualizar Producto
**PUT** `/api/productos/{id}`

```json
{
  "nombre": "Laptop",
  "descripcion": "Laptop HP Actualizada",
  "precio": 2300000,
  "stock": 5
}
```

**Respuesta (200 OK):**
```json
{
  "id": 1,
  "nombre": "Laptop",
  "descripcion": "Laptop HP Actualizada",
  "precio": 2300000,
  "stock": 5
}
```

### Eliminar Producto
**DELETE** `/api/productos/{id}`

**Respuesta (200 OK):**
```json
{
  "mensaje": "Producto eliminado exitosamente"
}
```

## H2 Console
Durante el desarrollo, puedes acceder a la consola H2 en:
`http://localhost:8080/h2-console`

- **URL JDBC:** `jdbc:h2:mem:testdb`
- **Usuario:** `sa`
- **Contraseña:** (vacía)

## Testing con Postman/Insomnia

1. Importar colección de Postman (si disponible)
2. Configurar requests según los endpoints documentados arriba
3. Ejecutar y validar respuestas

## Arquitectura Hexagonal

El proyecto implementa arquitectura hexagonal para:
- ✅ Desacoplamiento de capas
- ✅ Facilidad de testing
- ✅ Flexibilidad para cambiar detalles de implementación

## Tecnologías Utilizadas
- **Spring Boot 3.1.5**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **Maven**
- **JUnit 5 & Mockito**

## Autor
Josselitomr
