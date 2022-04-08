package com.player.casual.lostark.notification.service;

import com.player.casual.lostark.notification.enums.Continent;

import java.time.ZonedDateTime;
import java.util.List;

public interface SecretMerchantService {

    List<Continent> getMerchantTown(ZonedDateTime zonedDateTime);
}
