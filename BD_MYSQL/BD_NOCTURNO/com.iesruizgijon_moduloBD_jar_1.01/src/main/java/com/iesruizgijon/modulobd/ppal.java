package com.iesruizgijon.modulobd;

import java.util.List;


/**
 *
 * @author grafeno30
 */
public class ppal {

    public static void main(String[] args) {
        
       final String nombreBD = "HR";
       final String usuario = "root";
       final String clave = "123qweASD_";
       final String URL = "jdbc:mysql://localhost:3306/"; 
       //boolean correcto = false;
       //int opcion = -1;
        
       Bd bd = new Bd(URL, nombreBD, usuario, clave);
        
       bd.conecta();
    
       
       
      // List<String> nombresBD = bd.getDataBases();
       
       
       /*Se muestra el menú de base de datos*/       
       //while(opcion == -1)           
         ///  opcion = menuBD(nombresBD);
           
       
   //    String []nombreTablas = bd.getTables("classicmodels");
       
   //    for (String nombre:nombreTablas){
   //        System.out.println(nombre);
   //    }
       
   
   
        List <String> tabla =  bd.getSelect("classicmodels", "customers", 10);
   
   
        //Let's loop through a list
       
       for (String fila: tabla) {
            System.out.println(fila);
        }
       
       
       
       //System.out.println("Conexión establecida con éxito");
      
//       tring[] nombre_columnas = bd.describe("countries");
//       e
//        for (String nombre_columna : nombre_columnas) {
//            System.out.println(nombre_columna);
//        }
     
   
//        List<String> names= bd.getDataBases();
//   
//          for(String name:names)  
//            System.out.println(name);  
   
       bd.desconecta();
        
        
    }
}
