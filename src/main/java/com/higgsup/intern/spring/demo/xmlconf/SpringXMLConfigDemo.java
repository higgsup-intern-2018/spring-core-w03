package com.higgsup.intern.spring.demo.xmlconf;

import com.higgsup.intern.spring.demo.Pojo.Input;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Input input = appContext.getBean(Input.class);
        input.menu();

    }
}
