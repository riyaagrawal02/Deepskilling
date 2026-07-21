package com.cognizant.rest.model;

import java.io.Serializable;
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String name;
    private String capital;
    private String continent;
    
    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public Country(String code, String name, String capital, String continent) {
        this.code = code;
        this.name = name;
        this.capital = capital;
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCapital() {
        return capital;
    }
    
    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public String getContinent() {
        return continent;
    }
    
    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + ", capital=" + capital + 
               ", continent=" + continent + "]";
    }
}
