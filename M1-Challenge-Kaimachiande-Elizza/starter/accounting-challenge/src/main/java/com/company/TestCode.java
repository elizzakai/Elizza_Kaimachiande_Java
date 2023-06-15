package com.company;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class TestCode {
    Customer cus;
    AccountRecord acct;
    List<AccountRecord> acctlist;
    @BeforeEach
    public void setUp() {
        acctlist = new ArrayList<>();
        acct = new AccountRecord(100, "12-01-2021");
        acctlist.add(acct);
        cus = new Customer(1, "Bruce Wayne", acctlist);
        cus.getCharges().add(new AccountRecord(200,"12-01-2020" ));
    }

    @Test
    public void checkBalance() {
        int balance = cus.getBalance();
        Assertions.assertEquals(300, balance);
    }

    @Test
    public void checkString() {
        String str = cus.toString();
        int id = 1;
        String name = "Bruce Wayne";
        int balance = 300;
        Assertions.assertEquals("Id: " + id + ", " + "Name: " + name + ", " + "Balance: " + balance, str);
    }


}
