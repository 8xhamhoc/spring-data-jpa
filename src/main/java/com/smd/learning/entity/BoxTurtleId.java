package com.smd.learning.entity;

import java.io.Serializable;

public class BoxTurtleId implements Serializable {

    private static final long serialVersionUID = 3514072140796180372L;

    private String location;
    private String favoriteSalad;

    public BoxTurtleId() {
    }

    public BoxTurtleId(String location, String favoriteSalad) {
        this.location = location;
        this.favoriteSalad = favoriteSalad;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFavoriteSalad() {
        return favoriteSalad;
    }

    public void setFavoriteSalad(String favoriteSalad) {
        this.favoriteSalad = favoriteSalad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoxTurtleId that = (BoxTurtleId) o;

        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return favoriteSalad != null ? favoriteSalad.equals(that.favoriteSalad) : that.favoriteSalad == null;
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (favoriteSalad != null ? favoriteSalad.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BoxTurtleId{" +
                "location='" + location + '\'' +
                ", favoriteSalad='" + favoriteSalad + '\'' +
                '}';
    }
}
