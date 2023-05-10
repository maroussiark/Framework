/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1833.framework.view;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author maroussia
 */
public class ModelView {
    private String view;
    private HashMap<String, Object> data;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ModelView() {
        this.data = new HashMap<>();
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    public void addItem(String key,Object obj){
        this.data.put(key, obj);
    }
}
