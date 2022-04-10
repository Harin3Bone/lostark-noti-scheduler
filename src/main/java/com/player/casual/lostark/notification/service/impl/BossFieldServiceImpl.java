package com.player.casual.lostark.notification.service.impl;

import com.player.casual.lostark.notification.constant.NotifyMsg;
import com.player.casual.lostark.notification.service.BossFieldService;
import org.springframework.stereotype.Service;

@Service
public class BossFieldServiceImpl implements BossFieldService {

    @Override
    public String getMessage() {
        return NotifyMsg.BOSS_FIELD;
    }

}
