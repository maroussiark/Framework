/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitaire;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author maroussia
 */
public class Utilitaire {
    public String[] lien(String url){
        String[] reg = url.split("/");
        Vector<String> v = new Vector();
        for (int i = 0; i < reg.length; i++) {
            v.add(reg[i]);     
        }
        Object[] obj = v.toArray();
        String[] fin = Arrays.copyOf(obj,obj.length,String[].class);
        return fin;
    }
    public static String[] getUrl(String Url){
        if (Url==null) {
            String[] url={"/"};
            return url;
        }
        return Url.split("/");
    }
}
