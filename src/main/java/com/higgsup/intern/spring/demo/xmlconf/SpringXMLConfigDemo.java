package com.higgsup.intern.spring.demo.xmlconf;

import com.higgsup.intern.spring.demo.pojo.Dictionary;

import java.util.Scanner;

public class SpringXMLConfigDemo {
    public static void main(String[] args) {
       /* ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Dictionary dict = appContext.getBean("dictionary", Dictionary.class);*/

        Dictionary dict = new Dictionary();
        Scanner sc = new Scanner(System.in);
        String line;
        String[] lines;

        dict.getDictionaryFromFile();
        dict.instruct();
        do {
            System.out.print("> ");
            line = sc.nextLine();
            lines = line.split(" ", 3);

            switch (lines[0]) {
                case "save": {
                    dict.save();
                    break;
                }
                case "add": {
                    String lines1 = lines[1].substring(0, lines[1].length() - 1);
                    dict.add(lines1, lines[2]);
                    break;
                }
                case "lookup": {
                    dict.lookup(lines[1]);
                    break;
                }
                case "delete": {
                    dict.delete(lines[1]);
                    break;
                }
                case "quit": {
                    break;
                }
                default:
                    System.out.println("Wrong input!");
            }

        } while (lines[0].equals("quit") == false);
        sc.close();
    }
}
