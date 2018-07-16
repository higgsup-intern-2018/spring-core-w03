package com.higgsup.intern.spring.demo.javaconf;

import com.higgsup.intern.spring.demo.pojo.util.InputUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaConfigDemo {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        InputUtil inputUtil = appContext.getBean(InputUtil.class);
        inputUtil.run();

    }
}
