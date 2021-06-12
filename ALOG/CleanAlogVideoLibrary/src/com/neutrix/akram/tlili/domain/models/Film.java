package com.neutrix.akram.tlili.domain.models;

import java.util.Objects;

public class Film extends StockItem{

    private String acteur ;

    public Film(float rentalPrice, String title, String itemId, String acteur) {
        super(rentalPrice, title, itemId);
        this.acteur = acteur;
    }

    public Film(float rentalPrice, String title, String acteur) {
        super(rentalPrice, title);
        this.acteur = acteur;
    }

    @Override
    public String toString() {
        return "Film{" +
                "acteur='" + acteur + '\'' +
                "rentalPrice=" + super.getRentalPrice() +
                ", title='" + super.getTitle() + '\'' +
                ", itemId='" + super.getItemId() + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Film film = (Film) o;
        return Objects.equals(acteur, film.acteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), acteur);
    }

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }
}
