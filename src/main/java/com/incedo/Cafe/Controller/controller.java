package com.incedo.Cafe.Controller;
import com.incedo.Cafe.Pojo.Cart;
import com.incedo.Cafe.Services.cartService;
import com.incedo.Cafe.Services.paytmService;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {


    @PostMapping("/user/order/save")
    public Object saveOrder(@RequestBody Cart carts){
        //Cart carts = (Cart) object_cart;
        cartService cartService = new cartService();
        int Cart_id = cartService.saveOrder(carts);
        return paytm(carts.getEmp_id(),Cart_id,carts.getTotal(),carts.getPh_no());
    }


    @PostMapping("/user/order/status")
    public String StatusUpdate(@RequestBody Cart carts){
        cartService cartService = new cartService();
        cartService.UpdateStatus(carts);
        return "Success";
    }

//    localhost:8080/user/order/pay?Emp_id=11111&Cart_id=11111&Total=100&Ph_no=8237668870
//    @GetMapping(value ="/user/order/pay" ,params = {"Emp_id","Cart_id","Total","Ph_no"})
//    public Object paytmdirect(@RequestParam Integer Emp_id,@RequestParam Integer Cart_id,@RequestParam Float Total,@RequestParam Long Ph_no ){
//        paytmService paytmService = new paytmService();
//        return paytmService.paytm(Emp_id,Cart_id,Total,Ph_no);
//    }






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

