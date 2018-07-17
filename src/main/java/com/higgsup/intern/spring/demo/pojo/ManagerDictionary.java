package com.higgsup.intern.spring.demo.pojo;

import java.io.*;
import java.util.*;

public class ManagerDictionary {
    TreeMap<String, List<String>> treeMapDictionary = new TreeMap<String, List<String>>();

    public void loadDictionary(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            String word;
            String meanings;
            while ((line = bufferedReader.readLine()) != null) {
                int index = line.indexOf(":");
                word = line.substring(0, index);
                meanings = line.substring(index + 2, line.length());
                add(word, meanings);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add(String word, String meanings) {
        List<String> listMean = treeMapDictionary.get(word);
        if (listMean == null) {
            listMean = new ArrayList<>();
            treeMapDictionary.put(word, listMean);
            listMean.add(meanings);
        }else {
            if (listMean.contains(meanings)) {
                System.out.println("existed");
            } else {
                listMean.add(meanings);
            }
        }
    }

     public void removeWord(String word) {
         if (treeMapDictionary.containsKey(word)) {
             treeMapDictionary.remove(word);
             System.out.println(word+" deleted !");
         }else {
             System.out.println("Not found");
         }

     }

     public void lookup(String word) {

         if (treeMapDictionary.containsKey(word)){
             List<String> listMeaning =treeMapDictionary.get(word);
             for (String str : listMeaning){
                 System.out.println(str);
             }
         }else {
             System.out.println("Not found");
         }

     }
    public void save(String file){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (String key : treeMapDictionary.keySet()){
                String str = key+": ";
                for (String value : treeMapDictionary.get(key)){
                    str += value+"; ";
                }
                bufferedWriter.write(str.substring(0,str.length()-2)+"\n");
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void showMenu() {
        System.out.println("> add <word>: <meanings>");
        System.out.println("> lookup <word>");
        System.out.println("> delete <word>");
        System.out.println("> save");
        System.out.println("> quit");
    }

}
