package com.higgsup.intern.spring.demo.pojo;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDAO {

    Dictionary dict = new Dictionary();
    File file = new File("DICT.DAT");

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
                dict.getDictionary().put(word, meanings);
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
            if (dict.getDictionary().isEmpty() == true) {
                System.out.println("Nothing to save in Dictionary!");
            } else {
                for (String key : dict.getDictionary().keySet()) {
                    bufferedWriter.write(key + ": " + dict.getDictionary().get(key));
                    bufferedWriter.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add(String word, String meanings) {
        for (String key : dict.getDictionary().keySet()) {
            if (key.equals(word)) {
                if (dict.getDictionary().get(key).equals(meanings))
                    System.out.println("Word and meanings already exists!");
            } else {
                dict.getDictionary().get(key).concat(": ").concat(meanings);
            }
            if (!key.equals(word)) {
                dict.getDictionary().put(word, meanings);
            }
        }
    }

    public void lookup(String word) {
        if (dict.getDictionary().isEmpty() == true) {
            System.out.println(" ");
        } else {
            System.out.println(dict.getDictionary().get(word));
        }
    }

    public void delete(String word) {
        if (!dict.getDictionary().containsKey(word)) {
            System.out.println("Not found.");
        } else {
            dict.getDictionary().remove(word);
            System.out.println(word + "deleted.");
        }
    }
}
