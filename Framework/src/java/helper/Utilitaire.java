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
            result = val[1];
        }
        return result;
    }
     
}
