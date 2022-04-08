package com.player.casual.lostark.notification.utils;

import com.player.casual.lostark.notification.enums.Continent;

import java.util.List;

public class MessageUtils {


    private MessageUtils() {
    }


    public static String continentListToString(List<Continent> in) {
        if (in.isEmpty()) {
            return "N/A";
        }

        StringBuilder sb = new StringBuilder();
        for (Continent continent : in) {
            sb.append(continent.getName());
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
