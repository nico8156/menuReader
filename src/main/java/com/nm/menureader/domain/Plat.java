package com.nm.menureader.domain;

import java.util.Objects;

public class Plat {
    private String nom;
    private int calories;
    private String impact;
    private String rentabilite;

    public Plat(String nom, int calories, String impact, String rentabilité) {
        this.nom = nom;
        this.calories = calories;
        this.impact = impact;
        this.rentabilite = rentabilite;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return  nom.equalsIgnoreCase(plat.nom);
    }
    @Override
    public int hashCode() {
        return nom.toLowerCase().hashCode();
    }
    public String getNom() {
        return nom;
    }
    public int getCalories() {
        return calories;
    }
}
