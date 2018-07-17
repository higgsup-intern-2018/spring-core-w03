package com.higgsup.intern.spring.demo.pojo;

import java.io.*;
import java.util.*;

public class Functionality {
    private Map<String, List<String>> dictMap = new TreeMap<String, List<String>>();

    public Functionality(){

    }
        //Load data from dictionary
    public void loadDataFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String word;
            String meanings;
            String currentLine = null;
            while ((currentLine = bufferedReader.readLine()) != null){
                //Lay ra word va meanings dua vao vi tri cua dau ":"
                int index = currentLine.indexOf(":");
                word = currentLine.substring(0, index);
                meanings = currentLine.substring(index + 2, currentLine.length());
                add(word,meanings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Them tu vao dictionnary
    public void add(String word, String meanings){
        List<String> listValue = dictMap.get(word); //list chua toan bo nghia cua tu.
        if (listValue == null){
            listValue = new ArrayList<>();
            dictMap.put(word,listValue);
        }if (listValue.contains(meanings)){
            return;
        }else{
            listValue.add(meanings);
        }
    }

    // Tim 1 tu trong tu dien
    public void lookup(String word){

        //Neu tu co trong tu dien => in ra toan bo nghia cua tu
        if (dictMap.containsKey(word)){
            List<String> listValue = dictMap.get(word);
            Functionality.printMeanings(listValue);
        } else {     //Neu tu khong co trong tu dien thi chi in ra thong bao.
            System.out.println("Not found!");
        }
    }

    // Xoa 1 tu trong tu dien
    public void delete(String word){

        //Neu tu co trong tu dien => xoa tu
        if (dictMap.containsKey(word)){
            dictMap.remove(word);
            System.out.println(word+" deleted!");
        } else {
            System.out.println("Not found!");
        }
    }

    // Luu thong tin vao tu dien
    public void save(String fileName){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            for (String str : dictMap.keySet()){
                String item = str+": ";
                for (String value : dictMap.get(str)){
                    item += value+"; ";
                }
                bufferedWriter.write(item.substring(0,item.length()-2) + "\n");
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    // In ra toan bo nghia theo dung dinh dang cho 1 tu
    public static void printMeanings(List<String> list){
        Collections.sort(list);
        for(int i = 0; i< list.size(); i++){
            if (i == list.size()-1){
                System.out.print(list.get(i)+" ");
            } else{
                System.out.print(list.get(i)+"; ");
            }
        }
        System.out.println();
    }

    public void useByCommand() {
        System.out.println("> add <word>: <meanings>");
        System.out.println("> lookup <word>");
        System.out.println("> delete <word>");
        System.out.println("> save");
        System.out.println("> quit");
    }
}
