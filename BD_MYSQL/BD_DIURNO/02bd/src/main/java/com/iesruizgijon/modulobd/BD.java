/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.modulobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grafeno30
 */
public class BD {

    private String nombreBD;
    private String usuario;
    private String clave;
    private Connection conexion;
    private String URL;
    
    
    public BD(String URL, String nombreBD, String usuario, String clave) {
        this.nombreBD = nombreBD;
        this.usuario = usuario;
        this.clave = clave;
        this.URL = URL;
    }
    
      
    public void conecta(){
        
        
        try {
            conexion = DriverManager.getConnection(URL +
                    nombreBD, usuario, clave);
            
        } catch (SQLException ex) {
            Logger.getLogger(ppal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     */
    public void desconecta(){
        
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String [] describe(String nombre){
        
        String []columnas = null;
        int n_columnas = 0;
        int i = 0;
        
        try {
            Statement statement = conexion.createStatement();
            
            ResultSet resultset = statement.executeQuery("SELECT * FROM " + nombre );
            
            ResultSetMetaData metadatos = resultset.getMetaData();
            
            n_columnas = metadatos.getColumnCount();
            
            columnas = new String[n_columnas];
                    
            for (i=1; i <= n_columnas; i++){
                
                columnas[i-1] = metadatos.getColumnName(i);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return columnas;
    }
    
    
}
