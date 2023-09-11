package com.metrot.day6;

import java.util.*;

public class MyCollections {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
//        List<String> myList = new LinkedList<>();
//        List<String> myList = new Stack<>();

        myList.add("cat");
        myList.add("dog");
        myList.add(1, "rabbit");
        myList.addAll(Arrays.asList("Cat", "Rabbit", "Dog"));
        myList.addAll(3, Arrays.asList("CAT", "RABBIT", "DOG"));
        System.out.println(myList);

        Queue<Integer> queue1 = new PriorityQueue<>();

        Set<Double> set1 = new HashSet<>();
//        Set<Double> set1 = new LinkedHashSet<>();
//        Set<Double> set1 = new TreeSet<>();

        Map<String, Integer> map1 = new HashMap<>();
//        Map<String, Integer> map1 = new TreeMap<>();
//        Map<String, Integer> map1 = new Hashtable<>();

    }
}
