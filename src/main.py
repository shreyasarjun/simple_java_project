package com.example;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class SimpleApp {
    public static void main(String[] args) {
        String text = "Hello, World!";
        System.out.println(StringUtils.reverse(text));
        List<String> words = new ArrayList<String>();
        words.add("Java");
        words.add("Programming");
        
        for (String word : words) {
            System.out.println(StringUtils.capitalize(word));
        }
    }
}