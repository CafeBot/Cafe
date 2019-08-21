package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User_details {

    @JsonProperty("emp_id")
    private int emp_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone_no")
    private long phone_no;

    public User_details() {
    }

    public User_details(int emp_id, String name, long phone_no) {

        this.emp_id = emp_id;
        this.name = name;
        this.phone_no = phone_no;
    }

    @Override
    public String toString() {
        return "User_details{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", phone_no=" + phone_no +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_details that = (User_details) o;
        return emp_id == that.emp_id &&
                phone_no == that.phone_no &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

}
