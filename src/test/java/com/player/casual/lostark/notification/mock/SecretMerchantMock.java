package com.player.casual.lostark.notification.mock;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SecretMerchantMock {

    public static final List<ZonedDateTime> getZonedDateTimeMock3() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2022, 3, 3, 0, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 3, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 10, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 12, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 21, 30, 0, 0, ZoneId.of("CET"))
        ));
    }

    public static final List<ZonedDateTime> getZonedDateTimeMock5() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2022, 3, 3, 1, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 11, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 13, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 22, 30, 0, 0, ZoneId.of("CET"))
        ));
    }

    public static final List<ZonedDateTime> getZonedDateTimeMock6() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2022, 3, 3, 2, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 9, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 14, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 20, 30, 0, 0, ZoneId.of("CET"))
        ));
    }

    public static final List<ZonedDateTime> getZonedDateTimeMock8() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2022, 3, 3, 4, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 16, 30, 0, 0, ZoneId.of("CET"))
        ));
    }

    public static final List<ZonedDateTime> getZonedDateTimeMock9() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2022, 3, 3, 6, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 18, 30, 0, 0, ZoneId.of("CET"))
        ));
    }

    public static final List<ZonedDateTime> getZonedDateTimeMock10() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2022, 3, 3, 5, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 8, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 17, 30, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 19, 30, 0, 0, ZoneId.of("CET"))
        ));
    }

    public static final List<ZonedDateTime> getZonedDateTimeMockFail() {
        return new LinkedList<>(Arrays.asList(
                ZonedDateTime.of(2019, 3, 3, 1, 35, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2020, 3, 3, 11, 33, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2021, 3, 3, 13, 0, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 22, 49, 0, 0, ZoneId.of("CET")),
                ZonedDateTime.of(2022, 3, 3, 0, 20, 0, 0, ZoneId.of("CET"))
        ));
    }
}
