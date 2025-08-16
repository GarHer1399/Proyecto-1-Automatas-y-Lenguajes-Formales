# Manual Técnico - Proyecto 1 Autómatas
## Analizador Léxico con conexión a SQL Server

### 👨‍💻 Introducción
Este documento describe el funcionamiento técnico del proyecto **Analizador Léxico**, desarrollado en **Java** con conexión a **SQL Server**.  
Está orientado a desarrolladores y técnicos que necesiten comprender o modificar el sistema.

---

## 📂 Arquitectura del Proyecto

El proyecto se organiza bajo un enfoque **MVC simplificado**:

- **Modelo (Base de datos SQL Server)**  
  Contiene la tabla `TablaSimbolos`, donde se almacenan los tokens predefinidos y sus tipos.

- **Controlador (ConexionTablaSimbolos.java)**  
  Gestiona la conexión con SQL Server mediante **JDBC** y obtiene la tabla de símbolos.

- **Vista/Lógica (AnalizadorLexico.java)**  
  Procesa el archivo de entrada y clasifica los tokens utilizando los datos cargados.

---

## 🗄️ Base de Datos

### Tabla: `TablaSimbolos`
| Campo      | Tipo         | Descripción                        |
|------------|--------------|------------------------------------|
| `SIMBOLOS` | VARCHAR(50)  | Representación del símbolo/token   |
| `TIPO`     | VARCHAR(50)  | Clasificación del símbolo          |

Ejemplo de datos precargados:
```sql
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('if', 'PALABRA_RESERVADA');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('+', 'OPERADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('{', 'DELIMITADOR');
