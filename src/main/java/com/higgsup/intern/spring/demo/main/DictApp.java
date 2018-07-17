package com.higgsup.intern.spring.demo.main;

import com.higgsup.intern.spring.demo.beans.DictGUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class DictApp {
    public static void main(String[] args) {
       Scanner reader = new Scanner(System.in);
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
       DictGUI dictGUI = applicationContext.getBean(DictGUI.class);
       dictGUI.startDict(reader);
    }
}
