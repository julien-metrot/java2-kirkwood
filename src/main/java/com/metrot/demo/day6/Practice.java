package com.metrot.demo.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<String>();
        groceryList.add("milk");
        groceryList.add("bread");
        groceryList.add("bread");
        groceryList.add("eggs");
        groceryList.add("bread");

        for (int i = 0; i < groceryList.size(); i++) {
            String str = groceryList.get(i);

            if (str.equals("bread")) {
                groceryList.remove(str);
            }
        }

        groceryList.forEach(System.out::println);
    }
}
