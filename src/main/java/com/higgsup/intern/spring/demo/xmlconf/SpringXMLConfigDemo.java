package com.higgsup.intern.spring.demo.xmlconf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SpringXMLConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");





        Scanner sc = new Scanner(System.in);
        String input = new String();
        String[] lines;

        do {
            System.out.println("> ");
            String line = sc.nextLine();
            lines = line.split(" ", 3);
            switch (lines[0]) {
                case "save": {
                    break;
                }
                case "add": {
                    break;
                }
                case "lookup": {
                    break;
                }
                case "delete": {
                    break;
                }
                case "quit": {
                    break;
                }
                default:
                    System.out.println("Wrong input!");
            }

        } while (lines[0].equals("quit") == false);

    }
}
