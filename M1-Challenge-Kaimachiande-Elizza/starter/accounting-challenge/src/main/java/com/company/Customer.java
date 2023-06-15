package com.company;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int total = 0;
        for (int i = 0; i < charges.size(); i++) {
            total += charges.get(i).getCharge();
        }
        //update this
        return total;
    }

    public Customer(int i, String n, List<AccountRecord> account_info) {
        id = i;
        name = n;
        charges = account_info;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        String s = "Id: " + id + ", " + "Name: " + name + ", " + "Balance: " + String.valueOf(getBalance());
        return s;
    }
}
