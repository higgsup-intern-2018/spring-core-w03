package com.higgsup.intern.spring.demo.javaconf;

import com.higgsup.intern.spring.demo.Pojo.DictionaryDAO;
import com.higgsup.intern.spring.demo.Pojo.Input;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public DictionaryDAO dictionaryDAO(){
        return new DictionaryDAO();
    }

    @Bean
    public Input simpleDict(){
    return new Input();
    }
}
