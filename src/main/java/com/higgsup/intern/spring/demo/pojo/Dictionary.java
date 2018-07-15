package com.higgsup.intern.spring.demo.pojo;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Dictionary {
    File file = new File("DICT.DAT");

    private Map<String, String> dictionary = new TreeMap<>();

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }


    public void getDictionaryFromFile() {
        try {
            File file = new File("DICT.DAT");
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file)));

            List<String> list = bufferedReader.lines().collect(Collectors.toList());

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("")) {
                    continue;
                }
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

    public void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            if (dictionary.isEmpty() == true) {
                System.out.println("Nothing to save in Input!");
            } else {
                for (String key : dictionary.keySet()) {
                    bufferedWriter.write(key + ": " + dictionary.get(key));
                    bufferedWriter.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add(String word, String meanings) {
        for (String key : dictionary.keySet()) {
            if (key.equals(word)) {
                if (dictionary.get(key).equals(meanings))
                    System.out.println("Word and meanings already exists!");
            } else {
                dictionary.get(key).concat(": ").concat(meanings);
            }
            if (!key.equals(word)) {
                dictionary.put(word, meanings);
            }
        }
    }

    public void lookup(String word) {
        if (dictionary.isEmpty() == true) {
            System.out.println(" ");
        } else {
            System.out.println(dictionary.get(word));
        }
    }

    public void delete(String word) {
        if (!dictionary.containsKey(word)) {
            System.out.println("Not found.");
        } else {
            dictionary.remove(word);
            System.out.println(word + "deleted.");
        }
    }
}
