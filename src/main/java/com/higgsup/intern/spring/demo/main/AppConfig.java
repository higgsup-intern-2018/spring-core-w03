package com.higgsup.intern.spring.demo.main;

import com.higgsup.intern.spring.demo.beans.Dict;
import com.higgsup.intern.spring.demo.beans.DictGUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dict dict(){
        return new Dict();
    }

    @Bean
    public DictGUI dictGUI(){
        return new DictGUI(dict());
    }
}
