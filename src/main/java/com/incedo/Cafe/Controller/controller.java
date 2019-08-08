package com.incedo.Cafe.Controller;
import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Pojo.Paytm;
import com.incedo.Cafe.Pojo.paytmResponse;
import com.incedo.Cafe.Services.cartService;
import com.incedo.Cafe.Services.paytmService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;


@RestController
public class controller {

    @PostMapping("/user/order/save")
    public int saveOrder(@RequestBody Cart carts){
        cartService cartService = new cartService();
        int Cart_id = cartService.saveOrder(carts);
        return Cart_id;
    }


    @PostMapping("/user/order/status")
    public String StatusUpdate(@RequestBody Cart carts){
        cartService cartService = new cartService();
        int Row_UPdated = cartService.UpdateStatus(carts);
        if(Row_UPdated==0)
            return "FAILED TO UPDATE PAYMENT STATUS";
        else
            return "PAYMENT STATUS UPDATED";
    }
  
  
    @PostMapping("/user/order/pay")
    public Object paytm(@RequestBody Paytm paytm){
        paytmService paytmService = new paytmService();
        //Paytm paytm = new Paytm(emp_id,cart_id,total,ph_no);
        return paytmService.paytm(paytm);
    }

    @CrossOrigin(origins = "http://localhost:3000")
 @GetMapping("/user/order/payDirectPaytm")
 public Object paytmdirect(@RequestParam int emp_id,@RequestParam int cart_id, @RequestParam float total,@RequestParam long ph_no){
        Paytm paytm = new Paytm(emp_id,cart_id,total,ph_no);
        return paytmService.paytm(paytm);
 }


    @RequestMapping(value = "/paytmStatus",method = RequestMethod.POST, consumes = "application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody Object paytmStatus(HttpServletRequest request)  {
        return paytmService.paytmresponse(request);
    }


    @PostMapping("/error")
    public Object errorr(Object o) {
        return o;
    }


}

