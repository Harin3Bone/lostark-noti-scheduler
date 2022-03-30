package com.player.casual.lostark.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "lostark.trigger")
public class TriggerConfig {

    private String secretMerchant;
}
