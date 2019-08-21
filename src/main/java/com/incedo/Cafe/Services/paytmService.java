package com.incedo.Cafe.Services;

import com.incedo.Cafe.Pojo.Paytm;
import com.incedo.Cafe.Pojo.paytmResponse;
import com.incedo.Cafe.Repository.PaytmRepo;
import com.incedo.Cafe.configuration.SetEnvironment;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

public class paytmService {
    static SetEnvironment setEnvironment = new SetEnvironment();
    public static Object paytm(Paytm paytm) {
    TreeMap<String, String> paytmParams = new TreeMap<String, String>();
    /* Find your MID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
    paytmParams.put("MID", setEnvironment.Patm_MID);

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
    paytmParams.put("EMAIL", setEnvironment.paytm_MEmailId);

/**
 * Amount in INR that is payble by customer
 * this should be numeric with optionally having two decimal points
 */
    paytmParams.put("TXN_AMOUNT", ""+paytm.getTotal()+"");


    /* on completion of transaction, we will send you the response on this URL */
        paytmParams.put("CALLBACK_URL", setEnvironment.Paytm_call_back_URL);

/**
 * Generate checksum for parameters we have
 * You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
 * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
 */
    String checksum = null;
    try {
        checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(setEnvironment.paytm_MKey, paytmParams);
    } catch (Exception e) {
        e.printStackTrace();
    }


    /* Prepare HTML Form and Submit to Paytm */
    StringBuilder outputHtml = new StringBuilder();
    outputHtml.append("<html>");
    outputHtml.append("<head>");
    outputHtml.append("<title>Merchant Checkout Page</title>");
    outputHtml.append("</head>");
    outputHtml.append("<body>");
    outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>");
    outputHtml.append("<form method='post' action='" + setEnvironment.Paytm_url + "' name='paytm_form'>");

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

    public static paytmResponse  paytmresponse(HttpServletRequest request) {
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
        p.setTXNID(request.getParameter("TXNID"));

        System.out.println(p.getRESPMSG());

        return p;

    }

    public static String fetchStatus(int orderId) {
        PaytmRepo paytmFetchOrderId = new PaytmRepo();
        return paytmFetchOrderId.fetchOrderId(orderId);
    }
}
