/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analizadorlexico;

/**
 *
 * @author Gerardo GarHer
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorLexico {

    private Map<String, String> tablaDeSimbolos;

    public static void main(String[] args) {
        ConexionTablaSimbolos dbManager = new ConexionTablaSimbolos();
        Map<String, String> tablaSimbolos = dbManager.getTablaDeSimbolos();
        
        AnalizadorLexico analizador = new AnalizadorLexico(tablaSimbolos);
        
        String rutaArchivo = "C:\\Users\\Gerardo GarHer\\Desktop\\codigo.txt"; 
        analizador.analizar(rutaArchivo);
    }

    public AnalizadorLexico(Map<String, String> tablaDeSimbolos) {
        this.tablaDeSimbolos = tablaDeSimbolos;
    }

    public void analizar(String archivoRuta) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoRuta))) {
            String linea;
            int numeroLinea = 0;
            System.out.println("\n--- INCIANDO ANALIZADOR LEXICO ---");
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                System.out.println("\nAnalizando Linea " + numeroLinea + ": " + linea);
                
                Pattern pattern = Pattern.compile("(\".*?\")|([a-zA-Z_][a-zA-Z0-9_]*)|([0-9]+)|(==|!=|>=|<=|<<|>>)|(\\S)");
                Matcher matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    String token = matcher.group();
                    
                    if (tablaDeSimbolos.containsKey(token)) {
                        String tipo = tablaDeSimbolos.get(token);
                        System.out.println("  TOKEN: '" + token + "' -> Tipo: " + tipo);
                    } else {
                        if (token.matches("(\".*\")")) {
                            System.out.println("  TOKEN: '" + token + "' -> Tipo: CADENA_LITERAL");
                        } else if (token.matches("[0-9]+")) {
                            System.out.println("  TOKEN: '" + token + "' -> Tipo: NUMERO");
                        } else if (token.matches("^[a-zA-Z_][a-zA-Z0-9_]*$")) {
                            System.out.println("  TOKEN: '" + token + "' -> Tipo: IDENTIFICADOR");
                        } else {
                            System.out.println("  TOKEN: '" + token + "' -> Tipo: DESCONOCIDO");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}