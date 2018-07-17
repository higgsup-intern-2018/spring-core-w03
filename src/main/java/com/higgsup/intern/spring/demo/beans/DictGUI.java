package com.higgsup.intern.spring.demo.beans;

import java.util.Scanner;

public class DictGUI {
    private Dict dict;

    public DictGUI(Dict dict){
        this.dict = dict;
    }

    public void startDict(Scanner reader){
        dict.load("DICT.DAT");
        System.out.println("Dictionary");
        System.out.println("----------");
        System.out.println();

        while (true) {
            System.out.println("> add <word>: <meanings>");
            System.out.println("> lookup <word>");
            System.out.println("> delete <word>");
            System.out.println("> save");
            System.out.println("> quit");
            System.out.print("> ");

            String input = reader.nextLine();
            String[] arrOfInput = input.split(" ", 3);
            switch (arrOfInput[0]) {
                case "add":
                    dict.add(arrOfInput[1].substring(0, arrOfInput[1].length() - 1), arrOfInput[2]);
                    break;
                case "lookup":
                    dict.lookup(arrOfInput[1]);
                    break;
                case "delete":
                    dict.remove(arrOfInput[1]);
                    break;
                case "save":
                    dict.save("DICT.DAT");
                    break;
                case "quit":
                    System.exit(0);
            }
        }
    }
}