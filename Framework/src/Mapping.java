/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1833.framework;

/**
 *
 * @author maroussia
 */
public class Mapping {
    String className;
    String method;
    Class[] classArgument;

    public Mapping(String className, String method) {
        this.className = className;
        this.method = method;
    }

    public Mapping(String className, String method, Class[] classArgument) {
        this.className = className;
        this.method = method;
        this.classArgument = classArgument;
    }

    public Mapping() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    

    public Class[] getClassArgument() {
        return this.classArgument;
    }

    public void setClassArgument(Class[] classArgument) {
        this.classArgument = classArgument;
    }
       
}
