package com.incedo.Cafe.Repository;

import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Pojo.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CartRepo {
    @Autowired
    CreateJdbcTemplate createJdbcTemplate = new CreateJdbcTemplate();
    JdbcTemplate jdbcTemplate;

    {
        try {
            jdbcTemplate = createJdbcTemplate.CreateTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;



    public void insert_details(Cart cart) {
    //  jdbcTemplate.execute("insert into cart values(3,8,9,45,'2016-01-01',456,true)");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate= formatter.format( cart.getDatetime());
        System.out.println("date="+cart.getDatetime()+"  str="+strDate);
        for (Snack snack: cart.getSnack()) {


            jdbcTemplate.update("insert into cart values(" + cart.getEmp_id() + "," + cart.getCart_id() + "," + snack.getSnack_id() + "," + snack.getQty() + ",'" + strDate + "'," + cart.getTotal() + "," + cart.isPayment_status() + ")");
        }
    }

}
