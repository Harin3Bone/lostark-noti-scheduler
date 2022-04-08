package com.player.casual.lostark.notification.service.impl;

import com.player.casual.lostark.notification.config.DiscordConfig;
import com.player.casual.lostark.notification.constant.ErrorMsg;
import com.player.casual.lostark.notification.exception.UnexpectException;
import com.player.casual.lostark.notification.service.DiscordService;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DiscordServiceImpl implements DiscordService {

    @Autowired
    JDA jda;

    private DiscordConfig discordConfig;

    public DiscordServiceImpl(DiscordConfig discordConfig) {
        this.discordConfig = discordConfig;
    }

    public void sendMessage(@NonNull String message) {
        try {
            TextChannel channel = jda.getTextChannelById(discordConfig.getChannelId());
            if (channel != null) {
                channel.sendMessage(message).queue();
            }
        } catch (Exception e) {
            throw new UnexpectException(ErrorMsg.UNEXPECTED_DISCORD);
        }
    }
}
