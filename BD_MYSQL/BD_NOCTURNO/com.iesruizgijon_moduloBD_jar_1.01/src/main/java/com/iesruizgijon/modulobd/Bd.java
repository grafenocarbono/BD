package com.iesruizgijon.modulobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grafeno30
 */
public class Bd {

@SuppressWarnings("FieldMayBeFinal")
private String nombreBD;
@SuppressWarnings("FieldMayBeFinal")
private String usuario;
@SuppressWarnings("FieldMayBeFinal")
private String clave;
private Connection conexion = null;
@SuppressWarnings("FieldMayBeFinal")
private String URL;
    
    
    public Bd(String URL, String nombreBD, String usuario, String clave) {
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
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String [] describe(String nombre){
        
        String []columnas = null;
        
        
        try {
              
            int n_columnas;
            
            Statement statement = conexion.createStatement();
            
            ResultSet resultset = statement.executeQuery("SELECT * FROM " + nombre );
            
            ResultSetMetaData metadatos = resultset.getMetaData();
            
            
            
            n_columnas = metadatos.getColumnCount();
            
            columnas = new String[n_columnas];
                    
            for (int i=1; i <= n_columnas; i++){
                
                columnas[i-1] = metadatos.getColumnName(i);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return columnas;
    }
    
    
    public List<String> getDataBases(){
        
     Connection conexion2 = null;


        List<String> names;  
        names = new ArrayList<>();

        
        try {

           conexion2 = DriverManager.getConnection(

                    "jdbc:mysql://localhost/mysql", "root", "123qweASD_");

           Statement stmt = conexion.createStatement();

           ResultSet rs = stmt.executeQuery("Show Databases");

           while(rs.next()) {

               names.add(rs.getString(1));

            }

        } catch (SQLException ex) {

            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }

        if (conexion2 != null)
            try {
                conexion2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (names);
        
        
        
    }
    
    
    
    public String[] getDataBases2() {
   
    String[] nombres = null;
    int cont=0;

    try {
      //He puesto una bd que debe existir siempre
      // que es la bd "mysql"
      conexion = DriverManager.getConnection(
              this.URL + "mysql",
              this.usuario, this.clave);
     
      Statement stmt = conexion.createStatement();

      //Retrieving the data
      ResultSet rs = stmt.executeQuery("Show Databases;");      

      while (rs.next()) {
        cont++;
      }
     
      nombres = new String[cont];
     
      rs = stmt.executeQuery("Show Databases;");
     
      for (int i = 0; i < nombres.length; i++) {
        rs.next();
        nombres[i] = rs.getString(1);
      }
     

    } catch (SQLException ex) {

      Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
     
    }
   
    return nombres;
   
  }

    
    public String[] getTables(String nombreBD) {
   
    Connection conexion2 = null;    
    String[] nombres = null;
    int cont=0;

    try {
      conexion2 = DriverManager.getConnection(URL + 
              nombreBD, this.usuario, this.clave);
     
      Statement stmt = conexion2.createStatement();
      //Retrieving the data
      ResultSet rs = stmt.executeQuery("Show Tables;");      

      //contabilizar el número de tablas
      //para poder inicializar mi array
      while (rs.next()) {
        cont++;
      }
     
      //ya conozco el número de tablas por tanto
      //ya puedo inicializar el array
      nombres = new String[cont];
     
      rs = stmt.executeQuery("Show Tables;");
     
      for (int i = 0; i < nombres.length; i++) {
        rs.next();
        nombres[i] = rs.getString(1);
      }
     

    } catch (SQLException ex) {

      Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
     
    }
    
        try {
            if (conexion2 == null) {
               
            } else {
                    conexion2.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    return nombres;
   
  }
    
    public List<String> getSelect(String dbName, String table, int limit){
        
        @SuppressWarnings("UnusedAssignment")
        Connection conexion2 = null;
        
        List<String> tabla = new ArrayList<>();
        
                
         try {
            conexion2 = DriverManager.getConnection(URL + 
                    dbName, this.usuario, this.clave);

            Statement stmt = conexion2.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " LIMIT " + limit + ";");   


            //Retrieving the ResultSetMetaData object
              ResultSetMetaData rsmd = rs.getMetaData();
              //getting the number of columns
              int column_count = rsmd.getColumnCount();           


            while (rs.next()){

                String fields = "";

                for (int i=1; i < column_count; i++){
                    fields = fields + String.valueOf(rs.getObject(i)) + " , ";
                }

                //A row is retrieved, let's insert them into the list of list

                tabla.add(fields);
            }
         } catch(SQLException e){
             System.err.println(e);
         }
 
        return tabla;
                
    }
    
}
