package analizadorlexico;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gerardo GarHer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ConexionTablaSimbolos {
    
    // Configuración para la conexión a SQL Server
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=ProyectoAutomatas;encrypt=true;trustServerCertificate=true;";
    private static final String USERNAME = "admin"; 
    private static final String PASSWORD = "admin";

    public Map<String, String> getTablaDeSimbolos() {
        Map<String, String> tabla = new HashMap<>();
        System.out.println("Conexion exitosa a la base de datos.");

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SIMBOLOS, TIPO FROM TablaSimbolos")) { // Corregido

            System.out.println("\n--- Contenido de la Tabla de Símbolos ---");
            while (rs.next()) {
                String simbolo = rs.getString("SIMBOLOS"); // Corregido
                String tipo = rs.getString("TIPO");
                tabla.put(simbolo, tipo);
                System.out.println("Simbolo cargado: " + simbolo + " -> " + tipo);
            }
            System.out.println("\nConexion cerrada.");
        } catch (SQLException e) {
            System.err.println("Error de conexion a la base de datos: " + e.getMessage());
        }
        return tabla;
    }
}

