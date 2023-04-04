/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import etu1833.framework.view.ModelView;
import helper.annotation.Url;

/**
 *
 * @author maroussia
 */
public class Test {
    String name;

    @Url(valeur = "get-name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Url(valeur="emp-all")
    public ModelView findAll(){
        ModelView mv = new ModelView();
            mv.setView("emp-list.jsp");
        return mv;
    }
}
