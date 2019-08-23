package com.incedo.Cafe.configuration;


public class SetEnvironment {

    public String HOST_IP="10.151.240.123";
    //public static final String frontEnd_URL = "http://10.151.240.123:3000";
    public String paytm_redirect ="http://"+HOST_IP+":3000/status";

    /* for Staging */
    public  String Paytm_url = "https://securegw-stage.paytm.in/order/process";

    /* for Production */
// String Paytm_url = "https://securegw.paytm.in/order/process";

    public String Paytm_call_back_URL ="http://"+HOST_IP+":8080/paytmStatus";
    public String Patm_MID = "TQnSWF25066974419589";
    public String paytm_MEmailId = "demo@gmail.com";
    public String paytm_MKey = "L#V&%HJbOO03LS2S";

}
