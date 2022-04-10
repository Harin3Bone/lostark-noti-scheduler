package com.player.casual.lostark.notification.config;

import com.player.casual.lostark.notification.constant.ErrorMsg;
import com.player.casual.lostark.notification.exception.UnexpectException;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class BotConfig {

    @Autowired
    DiscordConfig discordConfig;

    @Bean
    @Primary
    @ConditionalOnClass(DiscordConfig.class)
    @Qualifier("jda")
    public JDA jdaBuilder() {
        try {
            JDABuilder builder = JDABuilder.createDefault(null);
            builder.setToken(discordConfig.getToken());
            builder.setStatus(OnlineStatus.ONLINE);
            builder.setActivity(Activity.playing("Lost Ark"));
            builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE, CacheFlag.ACTIVITY);
            builder.setCompression(Compression.NONE);
            builder.setChunkingFilter(ChunkingFilter.NONE);
            builder.setBulkDeleteSplittingEnabled(false);
            builder.setAutoReconnect(true);
            return builder.build();
        } catch (Exception e) {
            throw new UnexpectException(ErrorMsg.UNEXPECTED);
        }
    }
}
