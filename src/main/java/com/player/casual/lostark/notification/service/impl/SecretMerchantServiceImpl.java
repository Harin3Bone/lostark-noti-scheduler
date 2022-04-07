package com.player.casual.lostark.notification.service.impl;

import com.player.casual.lostark.notification.constant.ErrorMsg;
import com.player.casual.lostark.notification.enums.Continent;
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
    public List<?> getMerchantTown(ZonedDateTime zonedDateTime) {
        var time = TimeUtils.zonedDatetimeToTimeFormat(zonedDateTime);
        return switch (time) {
            case "01:30", "11:30", "13:30", "22:30" -> Arrays.asList(Continent.YUDIA, Continent.EAST_LUTERRA, Continent.ANIKA, Continent.SHUSHIRE, Continent.FEITON);
            case "02:30", "09:30", "14:30", "20:30" -> Arrays.asList(Continent.WEST_RUTTERRA, Continent.EAST_LUTERRA, Continent.TORTOYK, Continent.ARTHETINE, Continent.ROHENDEL, Continent.PUNIKA);
            case "00:30", "03:30", "10:30", "12:30", "15:30", "21:30" -> Arrays.asList(Continent.RETHAMIS, Continent.NORTH_VERN, Continent.YORN);
            case "04:30", "16:30" -> Arrays.asList(Continent.RETHAMIS, Continent.YUDIA, Continent.EAST_LUTERRA, Continent.ANIKA, Continent.NORTH_VERN, Continent.SHUSHIRE, Continent.YORN, Continent.FEITON);
            case "05:30", "08:30", "17:30", "19:30" -> Arrays.asList(Continent.YUDIA, Continent.WEST_RUTTERRA, Continent.EAST_LUTERRA, Continent.TORTOYK, Continent.ANIKA, Continent.ARTHETINE, Continent.SHUSHIRE, Continent.ROHENDEL, Continent.FEITON, Continent.PUNIKA);
            case "06:30", "18:30" -> Arrays.asList(Continent.RETHAMIS, Continent.WEST_RUTTERRA, Continent.EAST_LUTERRA, Continent.TORTOYK, Continent.ARTHETINE, Continent.NORTH_VERN, Continent.ROHENDEL, Continent.YORN, Continent.PUNIKA);
            default -> throw new InvalidException(String.format(ErrorMsg.INVALID_TIME, TRIGGER_NAME));
        };
    }
}
