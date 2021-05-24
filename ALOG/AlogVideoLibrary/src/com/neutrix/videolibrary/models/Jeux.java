package com.neutrix.videolibrary.models;

import java.util.Objects;

public class Jeux  extends StockItem{
    private String platform ;

    public Jeux(float rentalPrice, String title, String itemId, String platform) {
        super(rentalPrice, title, itemId);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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
}
