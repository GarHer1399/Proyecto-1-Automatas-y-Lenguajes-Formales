# Proyecto 1 - Autómatas: Analizador Léxico con Conexión a SQL Server

Este proyecto corresponde al **Proyecto 1 de la clase de Autómatas**, en el cual se desarrolla un **analizador léxico en Java** que se conecta a una **base de datos SQL Server** para gestionar la tabla de símbolos.

## Descripción
El analizador léxico lee un archivo de texto con código fuente, identifica tokens y consulta una **Tabla de Símbolos** almacenada en SQL Server para determinar su tipo (palabras reservadas, operadores, etc.).  
En caso de no encontrar el token en la base de datos, el programa lo clasifica como número, identificador, cadena literal o desconocido.

## Estructura del Proyecto
- `AnalizadorLexico.java` → Lógica del analizador léxico.
- `ConexionTablaSimbolos.java` → Conexión a SQL Server y carga de símbolos.
- `README.md` → Presentación del proyecto.
- `ManualTecnico.md` → Detalle técnico para programadores.
- `ManualUsuario.md` → Guía de instalación y uso.

## Tecnologías utilizadas
- **Java 8+**
- **SQL Server**
- **JDBC**

## Autor
- Ruben Gerardo García Hernández 
