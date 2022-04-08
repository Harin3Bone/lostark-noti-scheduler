package com.player.casual.lostark.notification.service;

import com.player.casual.lostark.notification.enums.Continent;
import com.player.casual.lostark.notification.mock.SecretMerchantMock;
import com.player.casual.lostark.notification.service.impl.SecretMerchantServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class SecretMerchantServiceTest {

    @InjectMocks
    SecretMerchantServiceImpl secretMerchantService;

    @Test
    void getMerchantTimeTestCaseList3() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock3();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getMerchantTown(mock);
            assertEquals(Arrays.asList(Continent.RETHAMIS, Continent.NORTH_VERN, Continent.YORN), actual);
            assertEquals(3, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList5() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock5();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getMerchantTown(mock);
            assertEquals(Arrays.asList(Continent.YUDIA, Continent.EAST_LUTERRA, Continent.ANIKA, Continent.SHUSHIRE, Continent.FEITON), actual);
            assertEquals(5, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList6() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock6();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getMerchantTown(mock);
            assertEquals(Arrays.asList(Continent.WEST_RUTTERRA, Continent.EAST_LUTERRA, Continent.TORTOYK, Continent.ARTHETINE, Continent.ROHENDEL, Continent.PUNIKA), actual);
            assertEquals(6, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList8() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock8();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getMerchantTown(mock);
            assertEquals(Arrays.asList(Continent.RETHAMIS, Continent.YUDIA, Continent.EAST_LUTERRA, Continent.ANIKA, Continent.NORTH_VERN, Continent.SHUSHIRE, Continent.YORN, Continent.FEITON), actual);
            assertEquals(8,actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList9Value() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock9();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getMerchantTown(mock);
            assertEquals(Arrays.asList(Continent.RETHAMIS, Continent.WEST_RUTTERRA, Continent.EAST_LUTERRA, Continent.TORTOYK, Continent.ARTHETINE, Continent.NORTH_VERN, Continent.ROHENDEL, Continent.YORN, Continent.PUNIKA), actual);
            assertEquals(9,actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList10Value() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock10();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getMerchantTown(mock);
            assertEquals(Arrays.asList(Continent.YUDIA, Continent.WEST_RUTTERRA, Continent.EAST_LUTERRA, Continent.TORTOYK, Continent.ANIKA, Continent.ARTHETINE, Continent.SHUSHIRE, Continent.ROHENDEL, Continent.FEITON, Continent.PUNIKA), actual);
            assertEquals(10, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseNotFound() {
        var actualLst = SecretMerchantMock.getZonedDateTimeMockFail();
        for (var actual : actualLst) {
            assertEquals(0,secretMerchantService.getMerchantTown(actual).size());
        }
    }
}
