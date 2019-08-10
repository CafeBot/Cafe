package com.incedo.Cafe.configuration;


public class SetEnvironment {


    //public static final String frontEnd_URL = "http://localhost:3000";
    public String paytm_redirect ="http://localhost:3000/status";

    /* for Staging */
    public  String Paytm_url = "https://securegw-stage.paytm.in/order/process";

    /* for Production */
// String Paytm_url = "https://securegw.paytm.in/order/process";

    public String Paytm_call_back_URL ="http://localhost:8080/paytmStatus";
    public String Patm_MID = "TQnSWF25066974419589";
    public String paytm_MEmailId = "demo@gmail.com";
    public String paytm_MKey = "L#V&%HJbOO03LS2S";

}
