package com.neutrix.tp4.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Jeux  {
    private String platform ;
    private float rentalPrice ;
    private String title;

    @Id
    private String itemId ;

    public Jeux() {
    }

    public Jeux(String platform, float rentalPrice, String title) {
        this.platform = platform;
        this.rentalPrice = rentalPrice;
        this.title = title;
        this.itemId = UUID.randomUUID().toString();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Jeux{" +
                "platform='" + platform + '\'' +
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
        Jeux jeux = (Jeux) o;
        return Objects.equals(platform, jeux.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), platform);
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
