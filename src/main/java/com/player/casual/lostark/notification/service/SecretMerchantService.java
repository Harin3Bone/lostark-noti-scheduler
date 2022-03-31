package com.player.casual.lostark.notification.service;

import java.time.ZonedDateTime;
import java.util.List;

public interface SecretMerchantService {

    List<?> getTownByTime(ZonedDateTime zonedDateTime);
}
