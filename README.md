# 🎬 ScreenMatch API - Proyecto con Spring
Este proyecto es una API REST construida con Spring Boot que forma parte del proceso de aprendizaje del framework Spring. La aplicación se enfoca en la gestión de una base de datos de series, permitiendo operaciones básicas como guardar, listar y buscar episodios.

## 🚀 Características principales
- Uso de Spring Boot para estructuración y configuración del proyecto
- Uso de Spring Data JPA para persistencia con Hibernate
- Acceso a endpoints REST para interactuar con los datos de las series
- Uso de base de datos H2 en memoria para desarrollo y pruebas
- Mapeo de entidades Serie y Episodio
- Búsqueda personalizada de episodios por nombre

## 🧱 Estructura del proyecto
```
ScreenMatch-Spring/
├── src/
│   ├── main/
│   │   ├── java/com/alonso/screenmatch/
│   │   │   ├── controller/           # Controladores REST
│   │   │   ├── dto/                  # Clases DTO para responses/requests
│   │   │   ├── model/                # Entidades JPA: Serie y Episodio
│   │   │   ├── repository/           # Interfaces que extienden JpaRepository
│   │   │   └── ScreenMatchApplication.java  # Clase principal de Spring Boot
│   ├── resources/
│   │   ├── application.properties    # Configuración de la app (ej. conexión BD)
│   │   └── data.sql                  # Datos precargados para pruebas
├── pom.xml                          # Dependencias y configuración de Maven
```
## 🛠️ Tecnologías utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Base de datos
- Maven

## 🧰 Cómo ejecutar el proyecto
1. ### Clona el repositorio:
``` bash
git clone https://github.com/alonso1298/ScreenMatch-Spring.git
cd ScreenMatch-Spring
```
2. ### Abre el proyecto en tu IDE (IntelliJ, Spring Tool Suite, VS Code, etc.)

3. ### Ejecuta la clase principal:

``` bash
ScreenMatchApplication.java
```

## 📚 Aprendizajes en este proyecto
- Estructuración de un proyecto Spring Boot con MVC
- Inyección de dependencias con @Autowired
- Uso de anotaciones JPA como @Entity, @OneToMany, @ManyToOne
- Creación de consultas personalizadas con @Query
- Separación de responsabilidades con DTOs y capas

## ✅ Próximos pasos sugeridos
- Implementar capa de servicio (Service)
- Validaciones de entrada con @Valid
- Excepciones personalizadas (@ControllerAdvice)
- Integración con una base de datos externa (MySQL, PostgreSQL)

## 📜 Licencia
Proyecto libre para fines de aprendizaje - MIT License.
