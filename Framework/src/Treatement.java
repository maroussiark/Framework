/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author maroussia
 */
public class Treatement {
    
    public static Object cast(String toCast,Class typeOfCast) throws Exception{
        
        if (typeOfCast == int.class || typeOfCast == Integer.class) {
            return Integer.parseInt(toCast);
        } else if (typeOfCast == double.class || typeOfCast == Double.class) {
            return Double.parseDouble(toCast);
        } else if(typeOfCast == Date.class){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(toCast);
        }else if(typeOfCast == Boolean.class){
            return Boolean.parseBoolean(toCast);
        }
        
            return toCast;
    }
    public static Class[] getAllClasses() throws Exception{
        String dir = Treatement.class.getClassLoader().getResource("").getPath();
        dir = dir.replaceAll("%20", " ");
        System.out.println(dir);
        
        Vector<String> str = getAllClassesName(new File(dir));
        Class[] result = new Class[str.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Class.forName(str.get(i));
        }
        return result;
    }   
    
    public Class[] getAllClass(String packageName) throws Exception{
        String path = Treatement.class.getClassLoader().getResource("").getPath();
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
    
    public static Vector<String> getAllClassesName(File dir) throws Exception{
        Vector<String> all = new Vector<>();
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                    if (file.isDirectory() == true) {
                        Vector<String> rec = Treatement.getAllClassesName(file);
                        for(int i = 0;i < rec.size();i++){
                            all.add(file.getName()+"."+rec.get(i));
                        }
                    } else {
                        if(file.getName().endsWith(".class")){
                            all.add((file.getName()).substring(0,file.getName().length()-6));
                        }
                    }
            }
        } catch (Exception e) {
            throw e;
        }
        return all;
    }
    


    public static Class[] getClassesWithAnnotation(Class[] all,Class annotation) throws Exception{

        Vector<Class> v = new Vector<>();
        for (int i = 0; i < all.length; i++) {
            if(all[i].isAnnotationPresent(annotation) == true){
                v.add(all[i]);
            }
        }

        Object[] rep = v.toArray();

        Class[] fin = Arrays.copyOf(rep, rep.length,Class[].class);

        return fin;
    }

    public static Field[] getFieldsWithAnnotation(Class object,Class annotation) throws Exception{
        Field[] allFields = object.getDeclaredFields();
        Vector<Field> valiny = new Vector<>();
        for (int i = 0; i < allFields.length; i++) {
            if(allFields[i].isAnnotationPresent(annotation) == true){
                valiny.add(allFields[i]);
            }
        }

        Object[] rep = valiny.toArray();

        Field[] fin = Arrays.copyOf(rep, rep.length,Field[].class);

        return fin;
    }

    public static Method[] getAllMethodWithAnnotation(Class object,Class annotation) throws Exception{
        Method[] allMethods = object.getDeclaredMethods();

        Vector<Method> valiny = new Vector<>();
        for (int i = 0; i < allMethods.length; i++) {
            if(allMethods[i].isAnnotationPresent(annotation) == true){
                valiny.add(allMethods[i]);
            }
        }

        Object[] rep = valiny.toArray();

        Method[] fin = Arrays.copyOf(rep, rep.length,Method[].class);

        return fin;
    }
    public static Object getReturnValue(String className,String methodName) throws IllegalArgumentException, InvocationTargetException{
            Object result = null;
            try {
                Class clazz = Class.forName(className);                
                Object instance = clazz.newInstance();

                Method method = clazz.getDeclaredMethod(methodName);
                
                result = method.invoke(instance);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
            return result;

    }
}
