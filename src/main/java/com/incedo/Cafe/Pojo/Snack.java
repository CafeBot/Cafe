package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snack {
    @JsonProperty("snack_id")
    private int snack_id;

    @JsonProperty("qty")
    private int qty;

    @JsonProperty("cost")
    private int cost;


    public int getSnack_id() {
        return snack_id;
    }

    public void setSnack_id(int snack_id) {
        this.snack_id = snack_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return snack_id == snack.snack_id &&
                qty == snack.qty &&
                cost == snack.cost;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snack_id=" + snack_id +
                ", qty=" + qty +
                ", cost=" + cost +
                '}';
    }




}
