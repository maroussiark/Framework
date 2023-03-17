/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import annotation.Url;

/**
 *
 * @author maroussia
 */
public class Personne {
    String name;
    int age;

    public Personne(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Url(valeur = "get-name-emp")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
