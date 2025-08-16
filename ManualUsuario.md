
---

### 📄 `ManualUsuario.md

```markdown
# Manual de Usuario - Proyecto 1 Autómatas
## Analizador Léxico con conexión a SQL Server

### Público objetivo
Este manual está dirigido a estudiantes y usuarios que deseen **ejecutar y probar** el analizador léxico.

---

## Requisitos previos
1. Tener instalado **Java JDK 8+**.  
2. Instalar **SQL Server** (2019 o superior).  
3. Asegurarse de tener habilitado el **usuario `admin` con contraseña `admin`** en SQL Server.  
4. Crear la base de datos `ProyectoAutomatas`.  

---

## Configuración de la Base de Datos
Ejecutar en SQL Server Management Studio:

```sql
CREATE DATABASE ProyectoAutomatas;
GO

USE ProyectoAutomatas;

CREATE TABLE TablaSimbolos (
    SIMBOLOS VARCHAR(50) PRIMARY KEY,
    TIPO VARCHAR(50)
);

INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('if', 'PALABRA_RESERVADA');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('else', 'PALABRA_RESERVADA');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('while', 'PALABRA_RESERVADA');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('+', 'OPERADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('-', 'OPERADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('*', 'OPERADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('/', 'OPERADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('{', 'DELIMITADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('}', 'DELIMITADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES ('(', 'DELIMITADOR');
INSERT INTO TablaSimbolos (SIMBOLOS, TIPO) VALUES (')', 'DELIMITADOR');


