package com.player.casual.lostark.notification.service;

import com.player.casual.lostark.notification.constant.NotifyMsg;
import com.player.casual.lostark.notification.service.impl.BossFieldServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BossFieldServiceTest {

    @InjectMocks
    BossFieldServiceImpl bossFieldService;

    @Test
    void getMessageTest() {
        assertEquals(NotifyMsg.BOSS_FIELD,bossFieldService.getMessage());
    }
}
