package com.incedo.Cafe.Repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class PaytmRepo {

    CreateJdbcTemplate createJdbcTemplate = new CreateJdbcTemplate();
    JdbcTemplate jdbcTemplate;
    {
        try {
            jdbcTemplate = createJdbcTemplate.CreateTemplate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String fetchOrderId(int orderId) {
        String status= "";
        try {
            status = jdbcTemplate.queryForObject("select distinct payment_status from cafe_cart where cart_id = " + orderId + "",String.class);
        }
        catch (Exception e){
            return "Order Does not exist";
        }
        System.out.println(status);
    return status;
    }
}
