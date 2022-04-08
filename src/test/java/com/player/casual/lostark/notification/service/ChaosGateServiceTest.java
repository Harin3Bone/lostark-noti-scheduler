package com.player.casual.lostark.notification.service;

import com.player.casual.lostark.notification.enums.Continent;
import com.player.casual.lostark.notification.service.impl.ChaosGateServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class ChaosGateServiceTest {

    @InjectMocks
    ChaosGateServiceImpl chaosGateService;

    @Test
    void continentListValueTest() {
        var expected = Arrays.asList(
                Continent.ROHENDEL,
                Continent.YORN,
                Continent.FEITON,
                Continent.PUNIKA,
                Continent.SOUTH_VERN
        );
        assertEquals(expected,chaosGateService.getChaosGateContinents());
    }

    @Test
    void continentListSizeTest() {
        assertEquals(5,chaosGateService.getChaosGateContinents().size());
    }
}
