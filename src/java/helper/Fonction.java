/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

/**
 *
 * @author maroussia
 */
public class Fonction {
    public Class[] getAllClass(String packageName) throws Exception{
        String path = Fonction.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        File dir = new File(path+packageName);
        
        Class[] result = null;
        
        if(dir.exists()==true){
            String[] classes = dir.list();
            result = new Class[classes.length];
            for (int i = 0; i < classes.length; i++) {
              result[i] = Class.forName(packageName+"."+classes[i].substring(0, classes[i].lastIndexOf(".class")));
            }
        }else{
            throw new Exception("No such File or Directory");
        }
        return result;
    }
    public Class[] getAllClassWithAnnotation(String packageName,Class annotation) throws Exception{
       Class[] classes = getAllClass(packageName);
    
       Class[] result = new Class[1];
    
     
        Vector<Class> v;
        v = new Vector<>();
        for (Class classe : classes) {
            if (classe.isAnnotationPresent(annotation) == true) {
                v.add(classe);
            }
            
        }
        if(!v.isEmpty()){
                result = new Class[v.size()];
                for (int i = 0; i < v.size(); i++) {
                    result[i] = v.get(i);

                }
        }else{
            result= null;
        }
       
       return result;
    }
    public Field[] getAllFieldWithAnnotation(Class object,Class annotation)throws Exception{
        Field[] champs = object.getDeclaredFields();
        Field[] result = new Field[1];
        
        Vector<Field> v = new Vector<>();
        
        for (Field champ : champs) {
            if (champ.isAnnotationPresent(annotation) == true) {
                v.add(champ);
            }
        }
         if(!v.isEmpty()){
                result = new Field[v.size()];
                for (int i = 0; i < v.size(); i++) {
                    result[i] = v.get(i);

                }
        }else{
            result= null;
        }
        return result;
    }
    public Method[] getAllMethodWithAnnotation(Class object,Class annotation)throws Exception{
        Method[] meth = object.getMethods();
        Method[] result = new Method[1];
        
        Vector<Method> v = new Vector<>();
        
        for (Method meths : meth) {
            if (meths.isAnnotationPresent(annotation) == true) {
                v.add(meths);
            }
        }
        if(!v.isEmpty()){
                result = new Method[v.size()];
                for (int i = 0; i < v.size(); i++) {
                    result[i] = v.get(i);

                }
        }else{
            result= null;
        }
        return result;
    }
    
}
