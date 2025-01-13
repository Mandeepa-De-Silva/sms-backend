package com.mandeepa.sms_backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {  // This is a bean that is used to map objects to other objects
        return new ModelMapper();
    }
}
