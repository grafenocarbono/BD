/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.nocturno.jtable_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grafeno30
 */
public class Conexion {

    final String URL = "jdbc:mysql://localhost:3306/";
    final String USER = "root";
    final String PASSWORD = "123qweASD_";
    final String DATABASE_NAME = "TEST4";
    final String TABLE_NAME = "producto";

    Connection conexion = null;
   
    public Connection getConexion() {

        try {
            conexion = DriverManager.getConnection(
                    URL + DATABASE_NAME, USER, PASSWORD);
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
        
    }

}
