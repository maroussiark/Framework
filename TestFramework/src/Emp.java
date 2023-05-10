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
    int id;
    String name;
    String firstname;
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Emp(int id, String name, String firstname) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
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
    @Url(valeur = "getEmp")
    public ModelView getEmp(String nom){
        ModelView mv = new ModelView();
        Vector<Emp> emp = new Vector<>();
        emp.add(new Emp(1,"Rakoto","malala"));    
        emp.add(new Emp(2,"Rabe","Haja"));
        emp.add(new Emp(3,"Rasoa","Ngita"));

        mv.setView("fiche.jsp");
        for (Emp emp2 : emp) {
            // if(emp2.id == id){
            //     mv.addItem("emp", emp2);
            // }
            if(nom.equalsIgnoreCase(emp2.getName())){
                mv.addItem("emp", emp2);
            }
        }
        
        
        return mv;
    }
    public Emp() {
    }
}
