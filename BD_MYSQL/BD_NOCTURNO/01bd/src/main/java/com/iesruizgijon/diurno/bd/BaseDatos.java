/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.diurno.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grafeno30
 */
public class BaseDatos {

    Connection conexion;
            
    String URL;
    String user;
    String password;
    String nameDB;
    
    public BaseDatos(String URL, String user, String password, 
            String nameDB ) {
            this.URL = URL;
            this.user = user;
            this.password = password;
            this.nameDB = nameDB;
    }
    
    
    public void conecta(){
        
        try {
            conexion = DriverManager.getConnection(
                    URL + nameDB, user, password);
            System.out.println("Conexión realizada con éxito");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconecta(){
        
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}
