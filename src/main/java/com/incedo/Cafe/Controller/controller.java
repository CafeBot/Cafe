package com.incedo.Cafe.Controller;

import com.incedo.Cafe.Greeting;
import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Services.Services;
import com.incedo.Cafe.Services.cartService;
import com.incedo.Cafe.Services.paytmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {


    @PostMapping("/user/order/save")
    public String saveOrder(@RequestBody Cart carts){
        cartService cartService = new cartService();
        cartService.saveOrder(carts);
        return "Success";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

/*
    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting g = new Greeting(1,"akash");
        return g;
    }
    @PostMapping("/abc")
    public void hello(@RequestBody Greeting g){
        System.out.println(g.getContent()+" "+g.getId());
        jdbcTemplate.execute("insert into user_details values(1,'alkash',98728327)");
    }
    */


    @GetMapping("/user/order/pay")
    public Object paytm(){
        paytmService paytmService = new paytmService();
        return paytmService.paytm();
    }

    @PostMapping("/paytmStatus")
    public Object Satus() {
        return "response";
    }

    @ExceptionHandler
    @PostMapping
    public Object error() {
        return "Fail";
    }

}

