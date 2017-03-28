package com.splendor.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.ws.rs.ApplicationPath;

/**
 * Created by pvyletelek on 1/7/2017.
 */
@Configuration
@ApplicationPath("/splendor")
public class JerseyConfig extends ResourceConfig {
    
    public JerseyConfig() {
        register(GameEndpoint.class);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return new MappingJackson2HttpMessageConverter(mapper);
    }
}
