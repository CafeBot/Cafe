package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


public class Cart {

    @JsonProperty("emp_id")
   private int emp_id;

    @JsonProperty("emp_name")
    private String emp_name;

    @JsonProperty("ph_no")
    private long ph_no;

    @JsonProperty("cart_id")
    private int cart_id;

    @JsonProperty("datetime")
    private Date datetime;

    @JsonProperty("total")
    private float total;

    @JsonProperty("payment_status")
    private String payment_status;


    @JsonProperty("tnx_id")
    private String tnx_id;


    @JsonProperty("Snack")
    private Snack[] snack;


    public String getTnx_id() {
        return tnx_id;
    }

    public void setTnx_id(String tnx_id) {
        this.tnx_id = tnx_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
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

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public long getPh_no() {
        return ph_no;
    }

    public void setPh_no(long ph_no) {
        this.ph_no = ph_no;
    }

    public Snack[] getSnack() {
        return snack;
    }

    public void setSnack(Snack[] snack) {
        this.snack = snack;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return emp_id == cart.emp_id &&
                ph_no == cart.ph_no &&
                cart_id == cart.cart_id &&
                Float.compare(cart.total, total) == 0 &&
                Objects.equals(emp_name, cart.emp_name) &&
                Objects.equals(datetime, cart.datetime) &&
                Objects.equals(payment_status, cart.payment_status) &&
                Objects.equals(tnx_id, cart.tnx_id) &&
                Arrays.equals(snack, cart.snack);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", ph_no=" + ph_no +
                ", cart_id=" + cart_id +
                ", datetime=" + datetime +
                ", total=" + total +
                ", payment_status='" + payment_status + '\'' +
                ", tnx_id='" + tnx_id + '\'' +
                ", snack=" + Arrays.toString(snack) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(emp_id, emp_name, ph_no, cart_id, datetime, total, payment_status, tnx_id);
        result = 31 * result + Arrays.hashCode(snack);
        return result;
    }

    public Cart(int emp_id, String emp_name, long ph_no, int cart_id, Date datetime, float total, String payment_status, String tnx_id, Snack[] snack) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.ph_no = ph_no;
        this.cart_id = cart_id;
        this.datetime = datetime;
        this.total = total;
        this.payment_status = payment_status;
        this.tnx_id = tnx_id;
        this.snack = snack;
    }


}
