package com.higgsup.intern.spring.demo.javaconf;

import com.higgsup.intern.spring.demo.pojo.dao.DictionaryDAO;
import com.higgsup.intern.spring.demo.pojo.model.Dictionary;
import com.higgsup.intern.spring.demo.pojo.util.InputUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private Dictionary dict;
    private DictionaryDAO dao;
    private InputUtil inputUtil;

    @Bean
    public Dictionary dictionary() {
        return new Dictionary();
    }

    @Bean
    public DictionaryDAO dictionaryDAO() {
        return new DictionaryDAO();
    }

    @Bean
    public InputUtil inputUtil() {
        return new InputUtil();
    }
}
