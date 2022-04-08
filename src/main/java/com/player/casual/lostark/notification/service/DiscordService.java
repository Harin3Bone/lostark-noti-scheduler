package com.player.casual.lostark.notification.service;

import lombok.NonNull;

public interface DiscordService {

    void sendMessage(@NonNull String message);
}
