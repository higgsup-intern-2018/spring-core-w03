package com.higgsup.intern.spring.demo.xmlconf;

import com.higgsup.intern.spring.demo.pojo.Dictionary;
import com.higgsup.intern.spring.demo.pojo.ManagerDictionary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJavaConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Dictionary dictionary = appContext.getBean(Dictionary.class);
        dictionary.start();

    }
}
