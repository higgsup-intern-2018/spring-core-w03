package com.higgsup.intern.spring.demo.pojo.dao;

import com.higgsup.intern.spring.demo.pojo.model.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DictionaryDAO {

    @Autowired
    private Dictionary dict;

    public DictionaryDAO() {

    }

    public Dictionary getDict() {
        return dict;
    }

    public void setDict(Dictionary dict) {
        this.dict = dict;
    }

    public DictionaryDAO(Dictionary dict) {
        this.dict = dict;
    }

    File file = new File("DICT.DAT");

    /**
     * Get the Dictionary from .dat file
     */
    public void getDictionaryFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file)));

            List<String> lines = bufferedReader.lines().collect(Collectors.toList());

            for (String line : lines) {
                if ("".equals(line)) continue;
                String[] splits = line.split(":");
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

    /**
     * Save a word and its meanings
     */
    public void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (String key : dict.getDictionary().keySet()) {
                bufferedWriter.write(key + ": " + dict.getDictionary().get(key));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Add meanings of the existing word or a new word and its meanings.
     */
    public void add(String word, String meanings) {
        for (String key : dict.getDictionary().keySet()) {
            if (key.equals(word)) {
                String meaning = dict.getDictionary().get(key);

                List<String> meaningList = Arrays.asList(meaning.split("; "));

                if (meaningList.stream().anyMatch(str -> str.trim().equals(meanings))) {
                    System.out.println("Error occurred");

                } else {
                    dict.getDictionary().replace(word, dict.getDictionary().get(key) + "; " + meanings);
                }
            }
        }
        if (!dict.getDictionary().containsKey(word)) {
            dict.getDictionary().put(word, meanings);
        }
    }

    /**
     * Look up a word in the dictionary
     */
    public void lookup(String word) {
        if (dict.getDictionary().containsKey(word)) {
            System.out.println(dict.getDictionary().get(word));
        } else {
            System.out.println("Not found.");
        }
    }

    /**
     * Delete a word in the dictionary
     */
    public void delete(String word) {
        if (dict.getDictionary().containsKey(word)) {
            dict.getDictionary().remove(word);
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
