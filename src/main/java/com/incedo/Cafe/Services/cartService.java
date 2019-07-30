package com.incedo.Cafe.Services;

import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Pojo.Snack;
import com.incedo.Cafe.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class cartService {


    public void saveOrder(Cart cart) {

        CartRepo crp=new CartRepo();
        crp.insert_details(cart);

         //   String query1 = "insert into cart values("+cart.getEmp_id()+","+cart.getCart_id()+","+cart.getSnack_id()+","+cart.getQty()+",'"+cart.getDatetime()+"',"+cart.getTotal()+","+cart.isPayment_status()+")";

          //  for (Snack snack: cart.getSnack()
             //    )
            //    {
         //       System.out.println("cart_id"+cart.getCart_id()+"  Payment Status="+cart.isPayment_status()+" datetime="+cart.getDatetime()+" snack:"+snack.getSnack_id());
              // jdbcTemplate.update( "insert into cart values("+cart.getEmp_id()+","+cart.getCart_id()+","+snack.getSnack_id()+","+snack.getQty()+",'"+cart.getDatetime()+"',"+cart.getTotal()+","+cart.isPayment_status()+")");
                //jdbcTemplate.update("insert into cart (emp_id,cart_id)values(??)",cart.getEmp_id(),cart.getCart_id());

            }



    }

