package com.higgsup.intern.spring.demo.pojo;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Dictionary {

    private Map<String, String> dictionary = new TreeMap<>();

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    File file = new File("DICT.DAT");

    /**
     * Get the Dictionary from .dat file
     */
    public void getDictionaryFromFile() {
        try {
            File file = new File("DICT.DAT");
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file)));

            List<String> list = bufferedReader.lines().collect(Collectors.toList());

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("")) continue;
                String[] splits = list.get(i).split(":");
                String word = splits[0];
                String meanings = splits[1].replaceFirst(" ", "");
                dictionary.put(word, meanings);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save a word and its meanings
     */
    public void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (String key : dictionary.keySet()) {
                bufferedWriter.write(key + ": " + dictionary.get(key));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Add meanings of the existing word
     */
    public void add(String word, String meanings) {
        for (String key : dictionary.keySet()) {
            if (key.equals(word)&& !dictionary.get(key).equals(meanings)) {
                dictionary.replace(word, dictionary.get(key) + "; " + meanings);
            }
        }
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, meanings);
        }
    }

    /**
     * Look up a word in the dictionary
     */
    public void lookup(String word) {
        if (dictionary.containsKey(word)) {
            System.out.println(dictionary.get(word));
        } else {
            System.out.println("Not found.");
        }
    }

    /**
     * Delete a word in the dictionary
     */
    public void delete(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            System.out.println(word + " deleted.");
        } else {
            System.out.println("Not found.");
        }
    }

    /**
     * input instruction
     */
    public void instruct() {
        System.out.println("----------DICTIONARY---------");
        System.out.println("> add <word>: <meanings>    |");
        System.out.println("> lookup <word>             |");
        System.out.println("> delete <word>             |");
        System.out.println("> save                      |");
        System.out.println("> quit                      |");
        System.out.println("-----------------------------");

    }
}
