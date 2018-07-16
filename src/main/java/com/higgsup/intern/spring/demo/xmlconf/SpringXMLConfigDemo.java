package com.higgsup.intern.spring.demo.xmlconf;

import com.higgsup.intern.spring.demo.pojo.util.InputUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SpringXMLConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring-beans.xml");
        InputUtil inputUtil = appContext.getBean(InputUtil.class);

    }
}
