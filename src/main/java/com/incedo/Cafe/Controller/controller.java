package com.incedo.Cafe.Controller;

import com.incedo.Cafe.Greeting;
import com.incedo.Cafe.Services.Services;
import com.paytm.merchant.CheckSumServiceHelper;
import org.json.JSONObject;
import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Services.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;


@RestController
public class controller {


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
    @PostMapping("/www.cafe.com/user/order/pay")
    public String saveOrder(@RequestBody Cart carts){
        cartService cartService = new cartService();
        cartService.saveOrder(carts);
        return "Success";
    }
    */


    @GetMapping("/user/order/pay")
    public Object paytm(){
        return Services.paytm();
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



