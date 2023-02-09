/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iesruizgijon.diurno.bd;

/**
 *
 * @author grafeno30
 */
public interface InterfaceBd {
    
    /*usaremos la bd mysql*/
    public String [] getDataBases();
    public String [] getTables(String nombreBaseDatos);
    public String [] getDescribe(String nombreBaseDatos, String nombreTabla);
    public String [] getSelect(String nombreBaseDatos, String nombreTabla);
    
}
