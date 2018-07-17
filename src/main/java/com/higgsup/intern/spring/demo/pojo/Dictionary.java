package com.higgsup.intern.spring.demo.pojo;

import java.util.Scanner;

public class Dictionary {
    private Functionality functionality;

    public Dictionary(Functionality functionality) {
        this.functionality = functionality;
    }

    public void start(){
        Scanner input = new Scanner(System.in);
        String command = new String();
        String[] commands = new String[3];

        functionality.loadDataFromFile("DICT.DAT");
        functionality.useByCommand();
        do {
            System.out.print("> ");
            command = input.nextLine();
            commands = command.split(" ", 3);
            switch (commands[0]) {
                case "add":
                    functionality.add(commands[1].substring(0,commands[1].length()-1), commands[2]);
                    break;
                case "lookup":
                    functionality.lookup(commands[1]);
                    break;
                case "delete":
                    functionality.delete(commands[1]);
                    break;
                case "save":
                    functionality.save("DICT.DAT");
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
