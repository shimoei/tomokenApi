package com.apiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@PropertySource({
        "classpath:env.properties"
        ,"classpath:secret.properties"
})
public class TomokenApi
{
    public static void main( String[] args )
    {
        SpringApplication.run(TomokenApi.class, args);
    }
}
