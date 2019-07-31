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


    @GetMapping("/user/order/save")
    public Object saveOrder(@RequestBody Object object_cart){
        Cart carts = (Cart) object_cart;
        cartService cartService = new cartService();
        int Cart_id = cartService.saveOrder(carts);
        return paytm(carts.getEmp_id(),Cart_id,carts.getTotal(),carts.getPh_no());
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


    //@GetMapping("/user/order/pay")
    public Object paytm(int Emp_id,int Cart_id,float Total,long Ph_no ){
        paytmService paytmService = new paytmService();
        return paytmService.paytm(Emp_id,Cart_id,Total,Ph_no);
    }

    @PostMapping("/paytmStatus")
    public Object Satus() {
        return "response";
    }


    @PostMapping
    public Object errorr() {
        return "Fail";
    }


}

