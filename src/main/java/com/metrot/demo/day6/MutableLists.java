package com.metrot.demo.day6;

import com.metrot.demo.day2.BankAccount;

import java.util.*;

public class MutableLists {
    private static List<BankAccount> myList3;

    public static void main(String[] args) {
//        myList3 = Arrays.asList(new BankAccount(100)); // .asList() returns a List which is an interface, The add method is unsupported because it is abstract and has no implementation

        myList3 = Arrays.asList(new BankAccount(100));
        myList3.add(new BankAccount(200)); // add method is supported because ArrayList is a class
        MyCollections.printCollection(myList3, "vertical");
    }
}
