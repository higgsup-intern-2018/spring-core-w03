package com.higgsup.intern.spring.demo.pojo;

import java.util.Scanner;

public class Dictionary {
   private ManagerDictionary dict ;

    public Dictionary(ManagerDictionary dict) {
        this.dict = dict;
    }

    public void start() {

        Scanner input = new Scanner(System.in);
        String command = new String();
        String[] commands = new String[3];

        dict.loadDictionary("C:\\intern-training\\spring-core-w03\\DICT.DAT");
        dict.showMenu();
        do {
            System.out.print("> ");
            command = input.nextLine();
            commands = command.split(" ", 3);
            switch (commands[0]) {
                case "add":
                    dict.add(commands[1].substring(0,commands[1].length()-1), commands[2]);
                    break;
                case "lookup":
                    dict.lookup(commands[1]);
                    break;
                case "delete":
                    dict.removeWord(commands[1]);
                    break;
                case "save":
                    dict.save("C:\\intern-training\\spring-core-w03\\DICT.DAT");
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Error!");
            }
        } while (commands[0].equals("quit") == false);

        input.close();
    }
}
