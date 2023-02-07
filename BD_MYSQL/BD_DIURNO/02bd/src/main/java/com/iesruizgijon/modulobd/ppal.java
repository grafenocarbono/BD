/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iesruizgijon.modulobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grafeno30
 */
public class ppal {

    public static void main(String[] args) {
        
       final String nombreBD = "classicmodels";
       final String usuario = "root";
       final String clave = "123qweASD_";
       final String URL = "jdbc:mysql://localhost:3306/"; 
        
        
       BD bd = new BD(URL, nombreBD, usuario, clave);
        
       bd.conecta();
       System.out.println("Conexión establecida con éxito");
       
       String[] nombre_columnas = bd.describe("offices");
       
        for (String nombre_columna : nombre_columnas) {
            System.out.println(nombre_columna);
        }
       
       bd.desconecta();
        
        
    }
}
