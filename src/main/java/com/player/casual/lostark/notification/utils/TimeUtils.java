package com.player.casual.lostark.notification.utils;

import lombok.extern.log4j.Log4j2;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Log4j2
public class TimeUtils {

    private static final String FORMAT_ZONED_DATETIME = "yyyy-MM-dd HH:mm:ss.SSSSSSZ";
    private static final String FORMAT_TIME = "HH:mm";

    private TimeUtils() {
    }

    public static String zonedDateTimeToTimeZoneFormat(ZonedDateTime in) {
        try{
            return in != null ? in.format(DateTimeFormatter.ofPattern(FORMAT_ZONED_DATETIME)) : null;
        } catch (DateTimeParseException | NullPointerException e) {
            log.error(e.getClass().getSimpleName() + ": " + in);
            throw e;
        }
    }

    public static String zonedDatetimeToTimeFormat(ZonedDateTime in) {
        try{
            return in.format(DateTimeFormatter.ofPattern(FORMAT_TIME));
        } catch (DateTimeParseException | NullPointerException e) {
            log.error(e.getClass().getSimpleName() + ": " + in);
            throw e;
        }
    }
}
