package com.incedo.Cafe.Controller;
import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Pojo.Paytm;
import com.incedo.Cafe.Services.cartService;
import com.incedo.Cafe.Services.paytmService;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {


    @PostMapping("/user/order/save")
    public int saveOrder(@RequestBody Cart carts){
        //Cart carts = (Cart) object_cart;
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

    //localhost:8080/user/order/pay?Emp_id=11111&Cart_id=11111&Total=100&Ph_no=8237668870
    //@GetMapping(value = "/user/order/pay", params = {"emp_id","cart_id","total","ph_no"})
    //public Object paytm(@RequestParam int emp_id,@RequestParam int cart_id,@RequestParam int total,@RequestParam long ph_no){

    @PostMapping("/user/order/pay")
    public Object paytm(@RequestBody Paytm paytm){
        paytmService paytmService = new paytmService();
        //Paytm paytm = new Paytm(emp_id,cart_id,total,ph_no);
        return paytmService.paytm(paytm);
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

