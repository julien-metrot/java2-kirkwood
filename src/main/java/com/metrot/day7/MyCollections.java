package com.metrot.day7;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCollections {
    public static void main(String[] args) {
        List<String> programmingLanguages = new ArrayList<>(Arrays.asList("Python", "C#", "Java", "PHP", "Cobol"));
        List<String> copy = new ArrayList<>(programmingLanguages);
        // filter anything that doesn't start with the letter P
        copy.removeIf((language) -> language.toLowerCase().charAt(0) != 'P');
        copy.forEach(System.out::println);
        System.out.println();
        programmingLanguages.forEach(System.out::println);
    }
}
