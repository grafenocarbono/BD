package com.iesruizgijon.diurno.bd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
        
        String[] listColumns = null;
        Conecta(nombreBaseDatos);
        int tam = 0;
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from " + nombreTabla );
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            
            tam =md.getColumnCount();
            
            listColumns = new String[tam];
            
            for (int i = 0; i < tam; i++ )
                listColumns[i] = md.getColumnName(i+1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        Desconecta();
       
        return listColumns;
    }

    @Override
    public String[] getSelect(String nombreBaseDatos, String nombreTabla) {
        
        String[] contenido = null;
        String fila;
        int counter = 0;
        int i = 0;

        Conecta(nombreBaseDatos);
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + nombreTabla);
            
            while(rs.next())
                counter++;
            
            rs = st.executeQuery("SELECT * FROM " + nombreTabla);
            
            while(rs.next()){
                fila = rs.getString(1);
                fila += rs.getString(2);
                fila += rs.getString(3);
                fila += rs.getString(4);
                
                contenido[i] = fila;
                i++;
            }
            
            Desconecta();
            

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }

}
