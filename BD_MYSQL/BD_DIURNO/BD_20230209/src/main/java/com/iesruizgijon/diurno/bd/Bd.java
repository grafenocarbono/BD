/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.diurno.bd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grafeno30
 */
public class Bd implements InterfaceBd {

    private String URL;
    private String user;
    private String password;

    private Connection conexion = null;

    public Bd(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        this.password = password;
    }

    private void Conecta(String nombreBaseDatos) {
        try {
            conexion = DriverManager.getConnection(URL + nombreBaseDatos, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Desconecta() {
        if (conexion != null)
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String[] getDataBases() {
    
        String[] arrayBaseDatos =null;
        int counter = 0;
        int i = 0;
        
        Conecta("mysql");
        
        try {
           
            ResultSet resultset = conexion.getMetaData().getCatalogs();
            
            while (resultset.next()) {
                counter++;
            }
            
            arrayBaseDatos = new String[counter];
            
            resultset = conexion.getMetaData().getCatalogs();
            
            while (resultset.next()) {
            
                arrayBaseDatos[i] = resultset.getString(1);
                i++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Desconecta();
        return arrayBaseDatos;
        
    }

    @Override
    public String[] getTables(String nombreBaseDatos) {
        String[] arrayBaseDatos =null;
        int counter = 0;
        int i = 0;
        String[] type = {"TABLE"};
        
        Conecta("mysql");
        
        try {
            DatabaseMetaData md = conexion.getMetaData();
            ResultSet rs = md.getTables(nombreBaseDatos, null, "%", type);
            
            while(rs.next()){
                counter++;
            }
            
            arrayBaseDatos = new String[counter];
            
            rs = md.getTables(nombreBaseDatos, null, "%", type);
            
            while(rs.next()){
                arrayBaseDatos[i] = rs.getString("TABLE_NAME");
                i++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Desconecta();
        
        return arrayBaseDatos;
  
    }

    @Override
    public String[] getDescribe(String nombreBaseDatos, String nombreTabla) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getSelect(String nombreBaseDatos, String nombreTabla) {
  
        
        
        
    }

}
