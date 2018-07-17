package com.higgsup.intern.spring.demo.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Dict {
    private Map<String, List<String>> dict = new TreeMap<>();

    public void add(String word, String translate) {
        List<String> translations = dict.get(word);
        if (translations == null) {
            translations = new ArrayList<>();
            dict.put(word, translations);
            translations.add(translate);
        }else {
            if(translations.contains(translate)){
                System.out.println("Meaning already exists");
            }else{
                translations.add(translate);
                Collections.sort(translations);
            }
        }
    }

    public void lookup(String word) {
        if(dict.containsKey(word)){
            List<String> translations = dict.get(word);
            StringBuilder trans = new StringBuilder();
            for(String s: translations)
                trans.append(s).append("; ");
            System.out.println(trans.substring(0, trans.length() - 2));
        }else {
            System.out.println("Not found.");
        }
    }

    public void remove(String word) {
        if(dict.containsKey(word)){
            dict.remove(word);
            System.out.println(word + " deleted");
        }else{
            System.out.println("Not found.");
        }
    }

    public void load(String file){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
        {
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null){
                int index = currentLine.indexOf(":");
                String word = currentLine.substring(0, index);
                String meanings = currentLine.substring(index + 2, currentLine.length());
                add(word, meanings);
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void save(String file){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for(String word: this.dict.keySet()){
                StringBuilder translation = new StringBuilder(word + ": ");
                for(String s: this.dict.get(word))
                    translation.append(s).append("; ");
                bufferedWriter.write(translation.substring(0, translation.length()-2)  + "\n");
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
