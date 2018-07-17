package com.higgsup.intern.spring.demo.xmlconf;

import com.higgsup.intern.spring.demo.pojo.Dictionary;
import com.higgsup.intern.spring.demo.pojo.ManagerDictionary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Dictionary dictionary = appContext.getBean(Dictionary.class);
        dictionary.start();

    }
}
