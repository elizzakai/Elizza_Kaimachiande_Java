package com.company;

public class AccountRecord {
    private int charge;
    private String chargeDate;

    public AccountRecord() {
    }


    public int getCharge() {
        return charge;
    }

    public AccountRecord(int charg, String chDate) {
        charge = charg;
        chargeDate = chDate;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }
}
