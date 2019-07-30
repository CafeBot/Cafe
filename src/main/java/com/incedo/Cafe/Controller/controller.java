package com.incedo.Cafe.Controller;

import com.incedo.Cafe.Greeting;
import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Services.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {


    @PostMapping("/www.cafe.com/user/order/pay")
    public String saveOrder(@RequestBody Cart carts){
        cartService cartService = new cartService();
        cartService.saveOrder(carts);
        return "Success";
    }


}

