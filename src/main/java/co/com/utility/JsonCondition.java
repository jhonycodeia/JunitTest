/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.tigo.modelo;

/**
 *
 * @author jsarria
 */
public class JsonCondition {
    
    private String key;
    private String value;
    private String[] values;
    
    public JsonCondition(String key, String[] values) {
        this.key = key;
        this.values = values;
    }

    public JsonCondition(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    public JsonCondition() {
        super();
    }
    

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    
}
