package com.higgsup.intern.spring.demo.javaconf;

import com.higgsup.intern.spring.demo.pojo.Dictionary;
import com.higgsup.intern.spring.demo.pojo.ManagerDictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ManagerDictionary managerDictionary(){
        return new ManagerDictionary();
    }
    @Bean
    public Dictionary dictionary(){
        return new Dictionary(managerDictionary());
    }
}
