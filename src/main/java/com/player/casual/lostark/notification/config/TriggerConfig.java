package com.player.casual.lostark.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "service.trigger")
public class TriggerConfig {

    private String secretMerchant;
    private String chaosGate;
    private String bossField;

}
