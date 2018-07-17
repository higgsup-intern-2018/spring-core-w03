package com.higgsup.intern.spring.demo.Pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Input {// bên trong class Input có chứa đối tượng thuộc lớp DictionaryDAO
    @Autowired
    private DictionaryDAO dictionaryDAO;

    public Input() {
    }

    public void menu() {

        Scanner sc = new Scanner(System.in);
        String line = new String();
        String[] lines ;

        dictionaryDAO.loadDictionary();
        dictionaryDAO.use();
        do {
            System.out.println(">");
            line = sc.nextLine();
            lines = line.split(" ", 3);
            switch (lines[0]) {
                case "save":{
                    dictionaryDAO.save();
                    break;
                }

                case "add":{
                    String lines1 = lines[1].substring(0, lines[1].length() - 1);
                    dictionaryDAO.add(lines1, lines[2]);
                    break;
                }

                case "lookup":{
                    dictionaryDAO.lookup̣(lines[1]);
                    break;
                }

                case "delete":{
                    dictionaryDAO.delete(lines[1]);
                    break;
                }

                case "quit":{
                    break;
                }

                default:
                    System.out.println("False!");
            }

        } while (lines[0].equals("quit")==false);
        sc.close();
    }
}
