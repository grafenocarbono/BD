/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.diurno.bd;

/**
 *
 * @author grafeno30
 */
public class Principal {
   public static void main(String[] args) {
            final String URL = "jdbc:mysql://localhost:3306/";
            final String user = "root";
            final String password = "123qweASD_";
            final String nameDB = "classicmodels";
        
            BaseDatos  basedatos = new BaseDatos(URL, user, password, nameDB);
            
            basedatos.conecta();
            
            
            
            
            
           basedatos.desconecta();
            
            
        
    }
}
