package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


public class Cart {

    @JsonProperty("emp_id")
   private int emp_id;


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }


    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isPayment_status() {
        return payment_status;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }

    public Cart(int emp_id, int cart_id, int snack_id, int qty, Date datetime, float total, boolean payment_status) {
        this.emp_id = emp_id;
        this.cart_id = cart_id;
        this.datetime = datetime;
        this.total = total;
        this.payment_status = payment_status;
    }

    @JsonProperty("cart_id")
    private int cart_id;



    @JsonProperty("datetime")
   private Date datetime;

    @JsonProperty("total")
   private float total;

    @JsonProperty("payment_status")
   private boolean payment_status;

    @JsonProperty("Snack")
    private Snack[] snack;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return emp_id == cart.emp_id &&
                cart_id == cart.cart_id &&
                Float.compare(cart.total, total) == 0 &&
                payment_status == cart.payment_status &&
                Objects.equals(datetime, cart.datetime) &&
                Arrays.equals(snack, cart.snack);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "emp_id=" + emp_id +
                ", cart_id=" + cart_id +
                ", datetime=" + datetime +
                ", total=" + total +
                ", payment_status=" + payment_status +
                ", snack=" + Arrays.toString(snack) +
                '}';
    }

    public Snack[] getSnack() {
        return snack;
    }

    public void setSnack(Snack[] snack) {
        this.snack = snack;
    }
}
