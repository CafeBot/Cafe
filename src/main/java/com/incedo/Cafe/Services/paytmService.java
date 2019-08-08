package com.incedo.Cafe.Services;

import com.incedo.Cafe.Pojo.Paytm;
import com.incedo.Cafe.Pojo.paytmResponse;
import com.paytm.pg.merchant.CheckSumServiceHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

public class paytmService {
    public static Object paytm(Paytm paytm) {
    TreeMap<String, String> paytmParams = new TreeMap<String, String>();


    /* Find your MID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
    paytmParams.put("MID", "TQnSWF25066974419589");

    /* Find your WEBSITE in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
    paytmParams.put("WEBSITE", "WEBSTAGING");

    /* Find your INDUSTRY_TYPE_ID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
    paytmParams.put("INDUSTRY_TYPE_ID", "Retail");

    /* WEB for website and WAP for Mobile-websites or App */
    paytmParams.put("CHANNEL_ID", "WEB");

    /* Enter your unique order id */
    paytmParams.put("ORDER_ID", ""+paytm.getCart_id()+"");

    /* unique id that belongs to your customer */
    paytmParams.put("CUST_ID", ""+paytm.getEmp_id()+"");

    /* customer's mobile number */
    paytmParams.put("MOBILE_NO", ""+paytm.getPh_no()+"");

    /* customer's email */
    paytmParams.put("EMAIL", "demo@gmail.com");

/**
 * Amount in INR that is payble by customer
 * this should be numeric with optionally having two decimal points
 */
    paytmParams.put("TXN_AMOUNT", ""+paytm.getTotal()+"");


    /* on completion of transaction, we will send you the response on this URL */
    paytmParams.put("CALLBACK_URL", "http://localhost:8080/paytmStatus");

/**
 * Generate checksum for parameters we have
 * You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
 * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
 */
    String checksum = null;
    try {
        checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum("L#V&%HJbOO03LS2S", paytmParams);
    } catch (Exception e) {
        e.printStackTrace();
    }

    /* for Staging */
    String url = "https://securegw-stage.paytm.in/order/process";

    /* for Production */
// String url = "https://securegw.paytm.in/order/process";

    /* Prepare HTML Form and Submit to Paytm */
    StringBuilder outputHtml = new StringBuilder();
    outputHtml.append("<html>");
    outputHtml.append("<head>");
    outputHtml.append("<title>Merchant Checkout Page</title>");
    outputHtml.append("</head>");
    outputHtml.append("<body>");
    outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>");
    outputHtml.append("<form method='post' action='" + url + "' name='paytm_form'>");

    for(Map.Entry<String,String> entry : paytmParams.entrySet()) {
        outputHtml.append("<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'>");
    }

    outputHtml.append("<input type='hidden' name='CHECKSUMHASH' value='" + checksum + "'>");
    outputHtml.append("</form>");
    outputHtml.append("<script type='text/javascript'>");
    outputHtml.append("document.paytm_form.submit();");
    outputHtml.append("</script>");
    outputHtml.append("</body>");
    outputHtml.append("</html>");

    return  outputHtml;
}

    public static Object paytmresponse(HttpServletRequest request) {
        paytmResponse p = new paytmResponse();
        p.setORDERID(request.getParameter("ORDERID"));
        p.setMID(request.getParameter("MID"));
        p.setTXNAMOUNT(request.getParameter("TXNAMOUNT"));
        p.setCURRENCY(request.getParameter("CURRENCY"));
        p.setSTATUS(request.getParameter("STATUS"));
        p.setRESPCODE(request.getParameter("RESPCODE"));
        p.setRESPMSG(request.getParameter("RESPMSG"));
        p.setBANKTXNID(request.getParameter("BANKTXNID"));
        p.setCHECKSUMHASH(request.getParameter("CHECKSUMHASH"));
        System.out.println(request.getParameter("ORDERID"));

        System.out.println(p.getRESPMSG());

        StringBuilder outputHtml = new StringBuilder();
        outputHtml.append("<style>.button1 {\n" +
                "  -webkit-transition-duration: 0.4s; /* Safari */\n" +
                "  transition-duration: 0.4s;\n" +
                "}\n" +
                "\n" +
                ".button1:hover {\n" +
                "  background-color: #EF4815; /*Orange */\n" +
                "  color: white;\n" +
                "}.button1 {\n" +
                "  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);\n" +
                "}\n</style><html>");
        outputHtml.append("<head>");
        outputHtml.append("<title>Payment status</title>");
        outputHtml.append("</head>");
        outputHtml.append("<body ><center><img src='https://www.incedoinc.com/templates/common/images/logo.svg'  width = 50%>");
        if(p.getRESPMSG().equals("Txn Success"))
        {
            outputHtml.append("<br><br><br><br><H1>PAYMENT SUCCESSFUL</H1><br><h2>Thank you for your order</h2></centre>");
        }
        else{

            outputHtml.append("<br><br><br><br><H1>PAYMENT Failed</H1><br><H2>"+p.getRESPMSG()+"</H2><br><h2>please Retry   </h2>");

        }
        outputHtml.append("<form  action=\"http://localhost:3000/\">\n" +
                "    <input class = 'button1' type=\"submit\" value=\"Go to Home\" />\n" +
                "</form></centre>");
        outputHtml.append("</body>");
        outputHtml.append("</html>");
        return outputHtml;

    }
}
