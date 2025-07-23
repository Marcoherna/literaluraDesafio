# Literalura 📚

Literalura es una aplicación de consola en Java desarrollada con el framework Spring Boot. Permite a los usuarios interactuar con la API de [Gutendex](https://gutendex.com/) para buscar libros y persistir la información de los libros y sus autores en una base de datos PostgreSQL.

Este proyecto fue desarrollado como parte del Challenge de Programación de **Alura Latam** en conjunto con **Oracle Next Education (ONE)**.

## ✨ Características Principales

- **Búsqueda de Libros por Título**: Consume la API de Gutendex para encontrar libros.
- **Persistencia de Datos**: Guarda la información de libros y autores en una base de datos, evitando registros duplicados.
- **Listado de Registros**:
  - Muestra todos los libros guardados.
  - Muestra todos los autores guardados.
- **Consultas Específicas**:
  - Lista autores que estaban vivos en un año determinado.
  - Lista libros según un idioma específico (ej. español, inglés).
- **Aplicación de Consola Interactiva**: Un menú simple guía al usuario a través de las diferentes funcionalidades.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
  - Spring Data JPA
  - Spring Web
- **PostgreSQL** como base de datos.
- **Maven** para la gestión de dependencias.
- **API de Gutendex** como fuente de datos de libros.
- **Jackson** para la deserialización de JSON.

## 📋 Prerrequisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:
- JDK 17 o superior.
- Maven 3.8 o superior.
- Una instancia de PostgreSQL en ejecución.

## 🚀 Instalación y Ejecución

1.  **Clona el repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/literalura.git
    cd literalura
    ```

2.  **Configura la base de datos:**
    Abre el archivo `src/main/resources/application.properties` y modifica las siguientes líneas con tus credenciales de PostgreSQL. Asegúrate de haber creado previamente una base de datos (ej. `literalura_db`).

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/literalura_db
    spring.datasource.username=tu_usuario_postgres
    spring.datasource.password=tu_contraseña

    # Hibernate creará o actualizará las tablas automáticamente
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Compila y ejecuta el proyecto con Maven:**
    ```bash
    mvn spring-boot:run
    ```

4.  Alternativamente, puedes empaquetar la aplicación en un archivo `.jar` y ejecutarlo:
    ```bash
    mvn clean package
    java -jar target/literalura-0.0.1-SNAPSHOT.jar
    ```

## 💻 Uso

Una vez que la aplicación esté en ejecución, verás el siguiente menú en la consola:

```
----- MENÚ LITERALURA -----
1- Buscar libro por título
2- Listar libros registrados
3- Listar autores registrados
4- Listar autores vivos en un determinado año
5- Listar libros por idioma
6- Salir
Elija la opción a través de su número:
```

Simplemente ingresa el número de la opción que deseas ejecutar y presiona `Enter`.

---

Desarrollado por Marco.