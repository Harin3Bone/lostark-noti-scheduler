package com.player.casual.lostark.notification.service.impl;

import com.player.casual.lostark.notification.constant.ErrorMsg;
import com.player.casual.lostark.notification.enums.Town;
import com.player.casual.lostark.notification.exception.InvalidException;
import com.player.casual.lostark.notification.service.SecretMerchantService;
import com.player.casual.lostark.notification.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("SecretMerchantServiceImpl")
public class SecretMerchantServiceImpl implements SecretMerchantService {

    private static final String TRIGGER_NAME = "SecretMerchant";

    @Override
    public List<?> getTownByTime(ZonedDateTime zonedDateTime) {
        var time = TimeUtils.zonedDatetimeToTimeFormat(zonedDateTime);
        return switch (time) {
            case "01:30", "11:30", "13:30", "22:30" -> Arrays.asList(Town.YUDIA, Town.EAST_LUTERRA, Town.ANIKA, Town.SHUSHIRE, Town.FEITON);
            case "02:30", "09:30", "14:30", "20:30" -> Arrays.asList(Town.WEST_RUTTERRA, Town.EAST_LUTERRA, Town.TORTOYK, Town.ARTHETINE, Town.ROHENDEL, Town.PUNIKA);
            case "00:30", "03:30", "10:30", "12:30", "15:30", "21:30" -> Arrays.asList(Town.RETHAMIS, Town.NORTH_VERN, Town.YORN);
            case "04:30", "16:30" -> Arrays.asList(Town.RETHAMIS, Town.YUDIA, Town.EAST_LUTERRA, Town.ANIKA, Town.NORTH_VERN, Town.SHUSHIRE, Town.YORN, Town.FEITON);
            case "05:30", "08:30", "17:30", "19:30" -> Arrays.asList(Town.YUDIA, Town.WEST_RUTTERRA, Town.EAST_LUTERRA, Town.TORTOYK, Town.ANIKA, Town.ARTHETINE, Town.SHUSHIRE, Town.ROHENDEL, Town.FEITON, Town.PUNIKA);
            case "06:30", "18:30" -> Arrays.asList(Town.RETHAMIS, Town.WEST_RUTTERRA, Town.EAST_LUTERRA, Town.TORTOYK, Town.ARTHETINE, Town.NORTH_VERN, Town.ROHENDEL, Town.YORN, Town.PUNIKA);
            default -> throw new InvalidException(String.format(ErrorMsg.INVALID_TIME, TRIGGER_NAME));
        };
    }
}
