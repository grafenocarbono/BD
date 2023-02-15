/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iesruizgijon.nocturno.jtables01;

// Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class JTables01 {
    // frame
    JFrame f;
    // Table
    JTable j;
 
    // Constructor
    JTables01()
    {
        // Frame initialization
        f = new JFrame();
 
        // Frame Title
        f.setTitle("Título de ventana");
 
        // Data to be displayed in the JTable
        String[][] data = {
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Josema", "6014", "IT" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            { "Chiquito de la calzada", "4031", "CSE" },
            
        };
 
        // Column Names
        String[] columnNames = { "Nombre", "Número de inscripción", "Departmento" };
 
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }
 
    // Driver  method
    public static void main(String[] args)
    {
        new JTables01();
    }
}