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
        //Update this


//        System.out.println("Positive accounts:");
//        System.out.println("Negative accounts:");
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




















//package main.java.com.company;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Main {
//
//    private static List<String[]> customerData = Arrays.asList(
//            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
//            new String[] {"2","Daily Planet","-7500","01-10-2022"},
//            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
//            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
//            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
//            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
//            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
//            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
//            new String[] {"3","Ace Chemical","70000","12-29-2022"},
//            new String[] {"2","Daily Planet","56000","12-13-2022"},
//            new String[] {"2","Daily Planet","-33000","01-07-2022"},
//            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
//            new String[] {"2","Daily Planet","33000","01-17-2022"},
//            new String[] {"3","Ace Chemical","140000","01-25-2022"},
//            new String[] {"2","Daily Planet","5000","12-12-2022"},
//            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
//            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
//    );
//
//    public static void main(String[] args) {
//        //add to this new thing
//        List<com.company.Customer> customerList = new ArrayList<com.company.Customer>();
//        List<String> customernames = new ArrayList<>();
//        for (int i = 0; i < customerData.size(); i++) {
//            if (!customernames.contains(customerData.get(i)[1])) {
//                int id =  Integer.parseInt(customerData.get(i)[0]);
//                String name = customerData.get(i)[1];
//                List<AccountRecord> account_info = new ArrayList<>();
//
//                account_info.add(new AccountRecord(customerData.get(i)[2], customerData.get(i)[3]));
//                customerList.add(new com.company.Customer(id,name,account_info));
//                /*
//                Not entirely sure about the new List<AccountRecord>(customerData[i][2])
//                 */
//            }
//            else {
//                for (int k = 0; k < customerList.length; k++) {
//                    if (customerList[k][1] == customerData.get(i)[1]) {
//                        List<com.company.AccountRecord> account_info = customerList.get(k).getCharges();
//                        account_info.add(new com.company.AccountRecord(customerData.get(i)[2], customerData.get(i)[3]));
//                        /*
//                        not sure if this is legal but oh well
//                         */
//                        customerList.set(k, new com.company.Customer(customerData.get(i)[0], customerData.get(i)[1], account_info));
////                        customerList.get(k).;
//
//                        /*
//                        or just get balance of both and combine em for the actual total?
//                        I really just wanna make a setter for the getcharges and equate account info to charges
//                        OR do customerList.set(k, new customer (,,,)) with the updated information for accountinfo
//                         */
//
//                        /*
//                        combine their costs info and then set the list to the new cost info
//                        how to update the charges (add the new charge and update the list of charges, or replace it??)
//                         */
//                    }
//                }
//                /*
//                append somehow to this list of account records..
//                 */
//
//            }
//        }
//        //Update this
//        System.out.println("Positive accounts:");
//        System.out.println("Negative accounts:");
//    }
//}
