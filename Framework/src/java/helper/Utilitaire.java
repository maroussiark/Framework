/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

/**
 *
 * @author maroussia
 */
public class Utilitaire {
     public static String getUrl(String url,String contextPath){
        String result;
        String[] val = url.split(contextPath);
        if(val.length==1){
            result = "/";
        }else{
            result = val[1].split("/")[1];
        }
        return result;
    }
    public static String[] lien(String url) throws Exception{
        String[] reg = url.split("/");
        System.out.println(reg.length);
        if(reg.length >= 5){
           return reg;
        } else {
            throw new Exception("tsy misy lien");
        }     
    }
     
}
