package com.player.casual.lostark.notification.service.impl;

import com.player.casual.lostark.notification.enums.Continent;
import com.player.casual.lostark.notification.service.ChaosGateService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChaosGateServiceImpl implements ChaosGateService {

    @Override
    public List<Continent> getChaosGateContinents() {
        return Arrays.asList(Continent.ROHENDEL, Continent.YORN, Continent.FEITON, Continent.PUNIKA, Continent.SOUTH_VERN);
    }

    @Override
    public String getMessage(List<Continent> continents) {
        StringBuilder sb = new StringBuilder();
        for (Continent continent : continents) {
            sb.append(continent.getName());
            sb.append(", ");
        }

        return sb.toString().substring(0, sb.length() - 2);
    }
}
