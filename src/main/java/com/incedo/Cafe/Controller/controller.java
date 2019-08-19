package com.incedo.Cafe.Controller;
import com.incedo.Cafe.Pojo.*;
import com.incedo.Cafe.Services.LoginService;
import com.incedo.Cafe.Services.cartService;
import com.incedo.Cafe.Services.paytmService;
import com.incedo.Cafe.configuration.SetEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestController
public class controller {

    LoginService loginService= new LoginService();

    SetEnvironment setEnvironment = new SetEnvironment();

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user/order/save")
    public int saveOrder(@RequestBody Cart carts){
        cartService cartService = new cartService();
        int Cart_id = cartService.saveOrder(carts);
        return Cart_id;
    }


   // @PostMapping("/user/order/status")
    public String StatusUpdate(int orderId,String txnID ,String paymentStatus){
        cartService cartService = new cartService();
        int Row_UPdated = cartService.UpdateStatus(orderId,txnID,paymentStatus);
        if(Row_UPdated==0)
            return "FAILED TO UPDATE PAYMENT STATUS";
        else
            return "PAYMENT STATUS UPDATED";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user/order/pay")
    public Object paytm(@RequestBody Paytm paytm){
        paytmService paytmService = new paytmService();
        //Paytm paytm = new Paytm(emp_id,cart_id,total,ph_no);
        return paytmService.paytm(paytm);
    }

    @CrossOrigin(origins ="http://localhost:3000")
 @GetMapping("/user/order/payDirectPaytm")
 public Object paytmdirect(@RequestParam int emp_id,@RequestParam int cart_id, @RequestParam float total,@RequestParam long ph_no){
        Paytm paytm = new Paytm(emp_id,cart_id,total,ph_no);
        return paytmService.paytm(paytm);
 }


    @RequestMapping(value = "/paytmStatus",method = RequestMethod.POST, consumes = "application/json",headers = "content-type=application/x-www-form-urlencoded")
    public Object saveProfileJson(HttpServletRequest request)  {
        System.out.println(request);
        paytmResponse p = paytmService.paytmresponse(request);
        StatusUpdate(Integer.parseInt(p.getORDERID()),p.getTXNID(),p.getSTATUS());
            return new ModelAndView("redirect:" + setEnvironment.paytm_redirect);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/order/fetchStatus")
    public String fetchStatus(@RequestParam int orderId){
       String status =  paytmService.fetchStatus(orderId);
       if(status.equals("TXN_SUCCESS"))
           return "Your order is placed successfully";
       else if(status.equals("TXN_FAILURE"))
           return "Order payment Failed";
       else
        return status;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public Registration Authenticate(@RequestBody Login loginCredentials){
        return loginService.Authenticate(loginCredentials);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public String Register(@RequestBody Registration register){
        return loginService.RegisterUser(register);

    }



}

