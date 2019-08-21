package com.incedo.Cafe.Repository;

import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Pojo.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.persistence.Id;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class CartRepo  {

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





    public int insert_details(Cart cart) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate= formatter.format( cart.getDatetime());

        int Id_test =(int) jdbcTemplate.queryForObject("select cart_id from cafe_cart where id = (select max(id) from cafe_cart)",Integer.class);
        cart.setCart_id(Id_test+1);
        for (Snack snack: cart.getSnack()) {
            jdbcTemplate.update("insert into cafe_cart (emp_id,emp_name,cart_id,snack_id,qty,date_time,total,txn_id,payment_status,snack_name,ind_total)values(" + cart.getEmp_id() + ",'"+cart.getEmp_name()+"'," + cart.getCart_id() + "," + snack.getSnack_id() + "," + snack.getQty() + ",'" + strDate + "'," + cart.getTotal() + ",'"+cart.getTnx_id()+"','" + cart.getPayment_status() + "','"+snack.getSnack_name()+"',"+snack.getInd_total()+")");
        }


        return cart.getCart_id();




    }

    private boolean isExist(Cart cart) {


        int Id_test =(int) jdbcTemplate.queryForObject("select Count(emp_id) from User_details where emp_id = "+cart.getEmp_id()+" ",Integer.class);
        System.out.println(Id_test);
        if(Id_test==0){
            return true;
        }
        else {
            return false;
        }
    }

    public int updateStatus(int orderId,String txnID ,String paymentStatus) {
        return jdbcTemplate.update("update cafe_cart set payment_status='"+paymentStatus+"',txn_id = '"+txnID+"' where cart_id="+orderId+";");
    }

}
