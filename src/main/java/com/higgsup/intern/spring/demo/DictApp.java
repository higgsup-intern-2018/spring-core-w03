package com.higgsup.intern.spring.demo;

import java.util.Scanner;

public class DictApp {
    public static void main(String[] args) {
        DictGUI dictGUI = new DictGUI();
        Scanner reader = new Scanner(System.in);
        dictGUI.startDict(reader);
    }
}
