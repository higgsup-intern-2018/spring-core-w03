package com.higgsup.intern.spring.demo.Pojo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DictionaryDAO {

    private Map<String, String> dict = new TreeMap<>();

    public DictionaryDAO(){

    }

    File file = new File("DICT.DAT");

    public void loadDictionary(){
        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file)));
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            // sau khi doc cac file xong roi se chuyen thanh mot cai List

            for (String line: lines) {
                if ("".equals(line)) continue; // nếu gặp dòng nào rỗng thì sẽ chuyển tiếp sang
                //dòng tiếp theo
                String[] splits = line.split(":");
                String word = splits[0];
                String meanings = splits[1].replaceFirst(" ", "");
                dict.put(word, meanings);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // key là String, còn value là một cái list, vì một từ có thể có nhiều nghĩa */
    // phuong thức thêm từ
    public void add(String word, String meanings) {
        for (String key: dict.keySet()) { // duyệt key trong map
            if (key.equals(word)) {
                String meaning = dict.get(key); // get giá trị value có key là word
                List<String> meaningList = Arrays.asList(meaning.split("; "));
                // chuyển mảng thành một list, tức là nó sẽ tách mảng ra và phân cách nhau bới
                // dấu ; và khoảng space
                if (meaningList.stream().anyMatch(str -> str.trim().equals(meanings))) {
                    // nếu dùng str.trim tức là bỏ dấu cách, sau khi bỏ dấu cách thì
                    // nó so sánh các meaning, nếu có rồi thì không thêm được vào
                    System.out.println("Error occurred!"); // nếu trùng thì  in ra Error
                } else {
                    dict.replace(word, dict.get(key)+ "; " + meanings);
                }
            }
        }

        if (dict.containsKey(word)==false) { // nó kiểm tra xem cái map này có chứa cái word trong
            // từ điển hay ko?
            dict.put(word, meanings);
        }
    }

    // phương thức tìm từ trong từ điển
    public void lookup̣(String word){
        if(dict.containsKey(word)){
            System.out.println(dict.get(word));//trả về cái value tương ứng với cái key "word"
        }else{
            System.out.println("Not found");
        }
    }

    // xóa mục từ word trong từ điển
    public void delete(String word){
        if(dict.containsKey(word)){
            dict.remove(word);
            System.out.println(word +"deleted");
        }else{
            System.out.println("Not found");
        }
    }

    public void save(){ // ghi phần tử trong map vào File
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            //dinh dang : word: meaning1; meaning2; meaning3
            for(String key : dict.keySet()){//duyet key set trong do word la word trong tu dien
                bufferedWriter.write(key + ": " + dict.get(key)); // sau khi ghi mot tu moi
                // vào trong file thì nó sẽ có định dạng key : dấu cách:
                // ví dụ red :space do
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void use() {
        System.out.println("> add    <word>: <meanings>");
        System.out.println("> lookup <word>");
        System.out.println("> delete <word>");
        System.out.println("> save");
        System.out.println("> quit");
    }

}
