package com.player.casual.lostark.notification.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TimeUtilsTest {

    private static final String FORMAT_ZONED_DATETIME = "yyyy-MM-dd HH:mm:ss.SSSSSSZ";
    private static int zoneDateTimeToTimeFormatPassIndex = 0;

    @ParameterizedTest
    @ValueSource(strings = {
            "2022-03-28 00:00:00.000000+0200", "2022-03-28 01:30:00.000000+0200", "2022-03-28 02:30:00.000000-0200",
            "2022-03-28 03:30:00.000000+0200", "2022-03-28 04:30:00.000000+0200",
            "2022-03-28 05:30:00.070000+0700", "2022-03-28 06:30:00.070000+0700", "2022-03-28 07:30:00.070000+0700",
            "2022-03-28 08:30:00.070000+0700", "2022-03-28 09:30:00.070000+0700",
            "2022-03-28 10:30:00.123456-0600", "2022-03-28 11:30:00.123456-0600", "2022-03-28 12:30:00.123456-0600",
            "2022-03-28 13:30:00.123456-0600", "2022-03-28 14:30:00.123456-0600",
            "2022-03-28 15:30:59.000000+0000", "2022-03-28 16:30:59.000000+0000", "2022-03-28 17:30:59.000000+0000",
            "2022-03-28 18:30:59.000000+0000", "2022-03-28 19:30:59.000000+0000",
            "2022-03-28 20:30:00.999999+0000", "2022-03-28 21:30:00.999999+0000", "2022-03-28 22:30:00.999999+0000",
            "2022-03-28 23:30:00.999999+0000", "2022-03-28 00:30:00.999999+0000",
    })
    void zonedDatetimeToTimeFormatPass(String in) {
        var zonedDateTime = stringToZonedDateTime(in);
        var actual = TimeUtils.zonedDatetimeToTimeFormat(zonedDateTime);
        var expectLst = new LinkedList<>(Arrays.asList(
                "00:00", "01:30", "02:30", "03:30", "04:30",
                "05:30", "06:30", "07:30", "08:30", "09:30",
                "10:30", "11:30", "12:30", "13:30", "14:30",
                "15:30", "16:30", "17:30", "18:30", "19:30",
                "20:30", "21:30", "22:30", "23:30", "00:30"
        ));
        assertEquals(expectLst.get(zoneDateTimeToTimeFormatPassIndex), actual);
        zoneDateTimeToTimeFormatPassIndex++;
    }

    @Test
    void zonedDateTimeToTimeFormatNullPointerException() {
        assertThatThrownBy(() -> TimeUtils.zonedDatetimeToTimeFormat(null)).isInstanceOf(NullPointerException.class);
    }

    private ZonedDateTime stringToZonedDateTime(String in) {
        return ZonedDateTime.parse(in, DateTimeFormatter.ofPattern(FORMAT_ZONED_DATETIME));
    }
}
