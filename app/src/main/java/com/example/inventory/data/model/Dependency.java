package com.example.inventory.data.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Dependency implements Serializable, Comparable<Dependency> {
    public static final String TAG = "dependency";
    private int id;
    private String name;
    private String shortname;
    private String desciption;
    private String urlImage;

    public Dependency(int id, String name, String shortname, String desciption, String urlImage) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.desciption = desciption;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Dependency o) {
        return this.id -o.getId();
    }

    public static Comparator<Dependency> Nombre = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
}
