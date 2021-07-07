package com.neutrix.tp4.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Film {


    public Film() {
    }

    private float rentalPrice ;
    private String title;

    @Id
    private String itemId ;

    private String acteur ;


    public Film(float rentalPrice, String title, String acteur) {
        this.rentalPrice = rentalPrice;
        this.title = title;
        this.acteur = acteur;
        this.itemId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Film{" +
                "acteur='" + acteur + '\'' +
                "rentalPrice=" + getRentalPrice() +
                ", title='" + getTitle() + '\'' +
                ", itemId='" + getItemId() + '\'' +
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

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
