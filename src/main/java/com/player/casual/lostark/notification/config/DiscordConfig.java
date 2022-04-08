package com.player.casual.lostark.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "service.discord")
public class DiscordConfig {

    private String token;
    private long serverId;
    private long channelId;

}
