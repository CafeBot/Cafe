package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class paytmResponse {

    @JsonProperty("MID")
    private String MID;

    @JsonProperty("TXNID")
    private String TXNID;

    @JsonProperty("BANKTXNID")
    private String BANKTXNID;

    @JsonProperty("TXNAMOUNT")
    private String TXNAMOUNT;


    @JsonProperty("CURRENCY")
    private String CURRENCY;

    @JsonProperty("STATUS")
    private String STATUS;

    @JsonProperty("RESPCODE")
    private String RESPCODE;

    @JsonProperty("RESPMSG")
    private String RESPMSG;

    @JsonProperty("TXNDATE")
    private String TXNDATE;

    @JsonProperty("GATEWAYNAME")
    private String GATEWAYNAME;

    @JsonProperty("BANKNAME")
    private String BANKNAME;

    @JsonProperty("PAYMENTMODE")
    private String PAYMENTMODE;

    @JsonProperty("CHECKSUMHASH")
    private String CHECKSUMHASH;

    @JsonProperty("ORDERID")
    private String ORDERID;



    public String getORDERID() {
        return ORDERID;
    }

    public void setORDERID(String ORDERID) {
        this.ORDERID = ORDERID;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getTXNID() {
        return TXNID;
    }

    public void setTXNID(String TXNID) {
        this.TXNID = TXNID;
    }


    public String getBANKTXNID() {
        return BANKTXNID;
    }

    public void setBANKTXNID(String BANKTXNID) {
        this.BANKTXNID = BANKTXNID;
    }

    public String getTXNAMOUNT() {
        return TXNAMOUNT;
    }

    public void setTXNAMOUNT(String TXNAMOUNT) {
        this.TXNAMOUNT = TXNAMOUNT;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getRESPCODE() {
        return RESPCODE;
    }

    public void setRESPCODE(String RESPCODE) {
        this.RESPCODE = RESPCODE;
    }

    public String getRESPMSG() {
        return RESPMSG;
    }

    public void setRESPMSG(String RESPMSG) {
        this.RESPMSG = RESPMSG;
    }

    public String getTXNDATE() {
        return TXNDATE;
    }

    public void setTXNDATE(String TXNDATE) {
        this.TXNDATE = TXNDATE;
    }

    public String getGATEWAYNAME() {
        return GATEWAYNAME;
    }

    public void setGATEWAYNAME(String GATEWAYNAME) {
        this.GATEWAYNAME = GATEWAYNAME;
    }

    public String getBANKNAME() {
        return BANKNAME;
    }

    public void setBANKNAME(String BANKNAME) {
        this.BANKNAME = BANKNAME;
    }

    public String getPAYMENTMODE() {
        return PAYMENTMODE;
    }

    public void setPAYMENTMODE(String PAYMENTMODE) {
        this.PAYMENTMODE = PAYMENTMODE;
    }

    public String getCHECKSUMHASH() {
        return CHECKSUMHASH;
    }

    public void setCHECKSUMHASH(String CHECKSUMHASH) {
        this.CHECKSUMHASH = CHECKSUMHASH;
    }



    @Override
    public String toString() {
        return "paytmResponse{" +
                "MID='" + MID + '\'' +
                ", TXNID='" + TXNID + '\'' +
                ", BANKTXNID='" + BANKTXNID + '\'' +
                ", TXNAMOUNT='" + TXNAMOUNT + '\'' +
                ", CURRENCY='" + CURRENCY + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", RESPCODE='" + RESPCODE + '\'' +
                ", RESPMSG='" + RESPMSG + '\'' +
                ", TXNDATE='" + TXNDATE + '\'' +
                ", GATEWAYNAME='" + GATEWAYNAME + '\'' +
                ", BANKNAME='" + BANKNAME + '\'' +
                ", PAYMENTMODE='" + PAYMENTMODE + '\'' +
                ", CHECKSUMHASH='" + CHECKSUMHASH + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        paytmResponse that = (paytmResponse) o;
        return Objects.equals(MID, that.MID) &&
                Objects.equals(TXNID, that.TXNID) &&
                Objects.equals(BANKTXNID, that.BANKTXNID) &&
                Objects.equals(TXNAMOUNT, that.TXNAMOUNT) &&
                Objects.equals(CURRENCY, that.CURRENCY) &&
                Objects.equals(STATUS, that.STATUS) &&
                Objects.equals(RESPCODE, that.RESPCODE) &&
                Objects.equals(RESPMSG, that.RESPMSG) &&
                Objects.equals(TXNDATE, that.TXNDATE) &&
                Objects.equals(GATEWAYNAME, that.GATEWAYNAME) &&
                Objects.equals(BANKNAME, that.BANKNAME) &&
                Objects.equals(PAYMENTMODE, that.PAYMENTMODE) &&
                Objects.equals(CHECKSUMHASH, that.CHECKSUMHASH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MID, TXNID, BANKTXNID, TXNAMOUNT, CURRENCY, STATUS, RESPCODE, RESPMSG, TXNDATE, GATEWAYNAME, BANKNAME, PAYMENTMODE, CHECKSUMHASH);
    }
}
