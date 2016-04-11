package com.cosorio.prueba.rest;

import javax.ejb.Singleton;

@Singleton
public class NameStorageBean {

    // name field
    private String name = "World1111";
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
}
