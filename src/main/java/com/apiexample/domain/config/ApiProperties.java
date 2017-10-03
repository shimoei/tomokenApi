package com.apiexample.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * GoogleAPIで使用するプロパティを保持する。
 */

@Configuration
@ConfigurationProperties(prefix="api")
@Data
public class ApiProperties {

    //GoogleAPIを叩く時に使用する。
    String googleKey;
}
