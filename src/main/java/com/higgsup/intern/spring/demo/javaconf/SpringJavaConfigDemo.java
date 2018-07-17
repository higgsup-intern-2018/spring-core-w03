package com.higgsup.intern.spring.demo.javaconf;

import com.higgsup.intern.spring.demo.pojo.Dictionary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Dictionary dictionary = appContext.getBean(Dictionary.class);
        dictionary.start();
    }
}
