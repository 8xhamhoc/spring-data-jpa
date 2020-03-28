package com.smd.learning.entity;

public class Country {

    private String isocode;
    private String description;
    private int population;

    public Country() {
    }

    public Country(String isocode, String description) {
        this.isocode = isocode;
        this.description = description;
    }

    public String getIsocode() {
        return isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Country) {
            Country other = (Country) o;
            return isocode.equals(other.getIsocode());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return isocode.hashCode();
    }
}
