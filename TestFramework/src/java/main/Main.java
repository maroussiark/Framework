/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import etu1833.framework.Mapping;
import helper.Treatement;

/**
 *
 * @author maroussia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mapping m = new Mapping("Emp", "findAll");
        try {
            Object obj = Treatement.getReturnValue(m.getClassName(), m.getMethod());
            System.out.println("obj"+obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
