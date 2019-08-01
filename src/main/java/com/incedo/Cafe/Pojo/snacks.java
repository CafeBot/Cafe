package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class snacks {

    @JsonProperty("snack_id")
   private int snack_id;

    @JsonProperty("name")
   private String  name;

    @JsonProperty("price")
    private float price;

    @JsonProperty("isactive")
    private boolean isactive;

    public snacks(int snack_id, String name, float price, boolean isactive) {
        this.snack_id = snack_id;
        this.name = name;
        this.price = price;
        this.isactive = isactive;
    }

    public int getSnack_id() {
        return snack_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setSnack_id(int snack_id) {
        this.snack_id = snack_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        snacks snacks = (snacks) o;
        return snack_id == snacks.snack_id &&
                Float.compare(snacks.price, price) == 0 &&
                isactive == snacks.isactive &&
                Objects.equals(name, snacks.name);
    }

    @Override
    public String toString() {
        return "snacks{" +
                "snack_id=" + snack_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isactive=" + isactive +
                '}';
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isIsactive() {
        return isactive;
    }
}
