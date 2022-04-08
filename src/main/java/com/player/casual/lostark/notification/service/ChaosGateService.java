package com.player.casual.lostark.notification.service;

import com.player.casual.lostark.notification.enums.Continent;

import java.util.List;

public interface ChaosGateService {

    List<Continent> getChaosGateContinents();
    String getMessage(List<Continent> continents);
}
