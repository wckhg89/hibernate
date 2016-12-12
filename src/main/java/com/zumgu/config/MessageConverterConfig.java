package com.zumgu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zumgu.config.module.DateTimeModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by kanghonggu on 2016-12-12.
 */
@Configuration
public class MessageConverterConfig {
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter () {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new DateTimeModule());
        jsonConverter.setObjectMapper(objectMapper);

        return jsonConverter;
    }

}
