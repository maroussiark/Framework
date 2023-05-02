/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import helper.annotation.Url;
import etu1833.framework.view.ModelView;
import java.util.Vector;

/**
 *
 * @author maroussia
 */
public class Emp {
    String name;
    String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    

    @Url(valeur = "get-name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp(String name) {
        this.name = name;
    }
    
    @Url(valeur="emp-all")
    public ModelView findAll(){
        ModelView mv = new ModelView();
        mv.setView("emp-list.jsp");
            
        Vector<Emp> emp = new Vector<>();
        emp.add(new Emp("Rakoto"));    
        emp.add(new Emp("Rabe"));
        emp.add(new Emp("Rasoa"));

        mv.addItem("list", emp);        
        mv.addItem("liste", new Emp("Rasoa"));
        
        
        return mv;
    }
    @Url(valeur="formulaire")
    public ModelView formulaire(){
        ModelView mv = new ModelView();
        mv.setView("formulaire.jsp");
        return mv;
    }
    @Url(valeur="save")
    public ModelView save(){
        ModelView mv = new ModelView();

        // System.out.println("nom 1:"+this.getNom());
        mv.addItem("nom",this.getName());

        mv.setView("save.jsp");

        return mv;
    }
    public Emp() {
    }
}
