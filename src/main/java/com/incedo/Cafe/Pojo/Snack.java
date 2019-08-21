package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Snack {

  
  @JsonProperty("snack_id")
    private int snack_id;

    @JsonProperty("qty")
    private int qty;

    @JsonProperty("cost")
    private int cost;

    @JsonProperty("total")
    private int ind_total;

    @JsonProperty("name")
    private String snack_name;

    public Snack(int snack_id, int qty, int cost, int ind_total, String snack_name) {
        this.snack_id = snack_id;
        this.qty = qty;
        this.cost = cost;
        this.ind_total = ind_total;
        this.snack_name = snack_name;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snack_id=" + snack_id +
                ", qty=" + qty +
                ", cost=" + cost +
                ", ind_total=" + ind_total +
                ", snack_name='" + snack_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return snack_id == snack.snack_id &&
                qty == snack.qty &&
                cost == snack.cost &&
                ind_total == snack.ind_total &&
                Objects.equals(snack_name, snack.snack_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snack_id, qty, cost, ind_total, snack_name);
    }

    public int getInd_total() {
        return ind_total;
    }

    public void setInd_total(int ind_total) {
        this.ind_total = ind_total;
    }

    public String getSnack_name() {
        return snack_name;
    }

    public void setSnack_name(String snack_name) {
        this.snack_name = snack_name;
    }


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


}
