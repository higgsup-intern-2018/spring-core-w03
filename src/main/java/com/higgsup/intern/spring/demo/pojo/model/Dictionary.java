package com.higgsup.intern.spring.demo.pojo.model;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class Dictionary {

    private Map<String, String> dictionary = new TreeMap<>();

    public Map<String, String> getDictionary() {
        return dictionary;
    }
    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }
}
