package com.example.inventory.data.model;

import java.util.Objects;

public class Dependency {
    private String name;
    private String shortname;
    private String desciption;
    private String urlImage;

    public Dependency(String name, String shortname, String desciption, String urlImage) {
        this.name = name;
        this.shortname = shortname;
        this.desciption = desciption;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependency dependecy = (Dependency) o;
        return Objects.equals(shortname, dependecy.shortname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortname);
    }

    @Override
    public String toString() {
        return name;
    }
}
