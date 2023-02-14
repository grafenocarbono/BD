/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iesruizgijon.diurno.bd;

/**
 *
 * @author grafeno30
 */
public class Principal {

    public static void main(String[] args) {
        
        final String URL = "jdbc:mysql://localhost/";
        final String user = "root";
        final String password = "123qweASD_";
        String[] arrayCadenas;
        
        
        InterfaceBd bd = new Bd(URL, user, password);
        
        arrayCadenas = bd.getDataBases();
        
        System.out.println("**** BASES DE DATOS ***");
        
        for(String nombre: arrayCadenas){
            System.out.println(nombre);
        }
        
        arrayCadenas = bd.getTables("classicmodels");
        
        System.out.println("**** TABLAS DE UNA BASE DE DATOS ***");
        
        for(String nombre: arrayCadenas){
            System.out.println(nombre);
        }
        
        
        arrayCadenas = bd.getDescribe("classicmodels", "employees");
        
        System.out.println("**** COLUMNAS ***");
        
        for(String nombre: arrayCadenas){
            System.out.println(nombre);
        }
        
        arrayCadenas = bd.getDescribe("classicmodels", "employees");
        
        System.out.println("**** CONTENIDO ***");
        
        for(String nombre: arrayCadenas){
            System.out.println(nombre);
        }
        
        
    }
}
