package com.higgsup.intern.spring.demo.javaconf;

import com.higgsup.intern.spring.demo.pojo.Dictionary;
import com.higgsup.intern.spring.demo.pojo.Functionality;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataInput;

@Configuration
public class AppConfig {
    @Bean
    public Functionality functionality(){ return new Functionality();}

    @Bean
    public Dictionary dictionary(){return new Dictionary(functionality());}
}
