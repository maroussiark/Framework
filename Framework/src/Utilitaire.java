/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

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
            throw new Exception("ENTRER L'URL");
        }     
    }
    public static Object cast(String toCast,Class typeOfCast) throws Exception{
        if (typeOfCast == int.class || typeOfCast == Integer.class) {
            return Integer.parseInt(toCast);
        } else if (typeOfCast == double.class || typeOfCast == Double.class) {
            return Double.parseDouble(toCast);
        } else if(typeOfCast == Date.class){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(toCast);
        }
            return toCast;
    }
     
}
