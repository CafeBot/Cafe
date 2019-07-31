package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Paytm {


    @JsonProperty("emp_id")
    private int Emp_id;

    @JsonProperty("cart_id")
    private int Cart_id;

    @JsonProperty("total")
    private int Total;

    @JsonProperty("ph_no.")
    private long Ph_no;

    public int getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(int emp_id) {
        Emp_id = emp_id;
    }

    public int getCart_id() {
        return Cart_id;
    }

    public void setCart_id(int cart_id) {
        Cart_id = cart_id;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public long getPh_no() {
        return Ph_no;
    }

    public void setPh_no(long ph_no) {
        Ph_no = ph_no;
    }

    public Paytm(int emp_id, int cart_id, int total, long ph_no) {
        Emp_id = emp_id;
        Cart_id = cart_id;
        Total = total;
        Ph_no = ph_no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paytm paytm = (Paytm) o;
        return Emp_id == paytm.Emp_id &&
                Cart_id == paytm.Cart_id &&
                Total == paytm.Total &&
                Ph_no == paytm.Ph_no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Emp_id, Cart_id, Total, Ph_no);
    }

    @Override
    public String toString() {
        return "Paytm{" +
                "Emp_id=" + Emp_id +
                ", Cart_id=" + Cart_id +
                ", Total=" + Total +
                ", Ph_no=" + Ph_no +
                '}';
    }
}
