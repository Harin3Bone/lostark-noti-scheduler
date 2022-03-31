package com.player.casual.lostark.notification.service;

import com.player.casual.lostark.notification.enums.Town;
import com.player.casual.lostark.notification.exception.InvalidException;
import com.player.casual.lostark.notification.mock.SecretMerchantMock;
import com.player.casual.lostark.notification.service.impl.SecretMerchantServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
            var actual = secretMerchantService.getTownByTime(mock);
            assertEquals(Arrays.asList(Town.RETHAMIS, Town.NORTH_VERN, Town.YORN), actual);
            assertEquals(3, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList5() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock5();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getTownByTime(mock);
            assertEquals(Arrays.asList(Town.YUDIA, Town.EAST_LUTERRA, Town.ANIKA, Town.SHUSHIRE, Town.FEITON), actual);
            assertEquals(5, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList6() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock6();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getTownByTime(mock);
            assertEquals(Arrays.asList(Town.WEST_RUTTERRA, Town.EAST_LUTERRA, Town.TORTOYK, Town.ARTHETINE, Town.ROHENDEL, Town.PUNIKA), actual);
            assertEquals(6, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList8() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock8();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getTownByTime(mock);
            assertEquals(Arrays.asList(Town.RETHAMIS, Town.YUDIA, Town.EAST_LUTERRA, Town.ANIKA, Town.NORTH_VERN, Town.SHUSHIRE, Town.YORN, Town.FEITON), actual);
            assertEquals(8,actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList9Value() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock9();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getTownByTime(mock);
            assertEquals(Arrays.asList(Town.RETHAMIS, Town.WEST_RUTTERRA, Town.EAST_LUTERRA, Town.TORTOYK, Town.ARTHETINE, Town.NORTH_VERN, Town.ROHENDEL, Town.YORN, Town.PUNIKA), actual);
            assertEquals(9,actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseList10Value() {
        var mockLst = SecretMerchantMock.getZonedDateTimeMock10();
        for (var mock : mockLst) {
            var actual = secretMerchantService.getTownByTime(mock);
            assertEquals(Arrays.asList(Town.YUDIA, Town.WEST_RUTTERRA, Town.EAST_LUTERRA, Town.TORTOYK, Town.ANIKA, Town.ARTHETINE, Town.SHUSHIRE, Town.ROHENDEL, Town.FEITON, Town.PUNIKA), actual);
            assertEquals(10, actual.size());
        }
    }

    @Test
    void getMerchantTimeTestCaseException() {
        var actualLst = SecretMerchantMock.getZonedDateTimeMockFail();
        for (var actual : actualLst) {
            assertThatThrownBy(() -> secretMerchantService.getTownByTime(actual)).isInstanceOf(InvalidException.class);
        }
    }
}
