package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //add to this new thing
        List<Customer> customerList = new ArrayList<Customer>();
        List<String> customernames = new ArrayList<>();
        for (String[] customerDatum : customerData) {
            if (!customernames.contains(customerDatum[1])) {
                int id = Integer.parseInt(customerDatum[0]);
                String name = customerDatum[1];
                List<AccountRecord> account_info = new ArrayList<>();
                int idd = Integer.parseInt(customerDatum[2]);
                AccountRecord acct = new AccountRecord();
                acct.setCharge(idd);
                acct.setChargeDate(customerDatum[3]);
                account_info.add(acct);
//                account_info.add(new AccountRecord(idd, customerDatum[3]));
//                Customer cus = new Customer();
//                cus.setId(id);
//                cus.setName(name);
//                cus.
                customerList.add(new Customer(id, name, account_info));
                customernames.add(name);

            } else {
                for (Customer customer : customerList) {
                    if (customer.getName().equals(customerDatum[1])) {
                        int charge = Integer.parseInt(customerDatum[2]);
                        AccountRecord acct_recc = new AccountRecord();
                        acct_recc.setCharge(charge);
                        acct_recc.setChargeDate(customerDatum[3]);

                        customer.getCharges().add(acct_recc);
                        customer.getBalance();
                    }
                }
            }
        }

        List<Customer> customerpos = new ArrayList<Customer>();
        List<Customer> customerneg = new ArrayList<Customer>();
        for (Customer customer : customerList) {
            if (customer.getBalance() > 0) {
                customerpos.add(customer);
            } else if (customer.getBalance() < 0) {
                customerneg.add(customer);
            }
        }

        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.println(customerList);
        System.out.println(customernames);
        System.out.println(customerpos);
        System.out.println(customerneg);
    }
}
