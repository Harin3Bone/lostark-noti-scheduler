package com.player.casual.lostark.notification.enums;

import lombok.Getter;

@Getter
public enum Continent {

    RETHAMIS("Rethamis"),
    YUDIA("Yudia"),
    WEST_RUTTERRA("West Luterra"),
    EAST_LUTERRA("East Luterra"),
    TORTOYK("Tortoyk"),
    ANIKA("Anika"),
    ARTHETINE("Arthetine"),
    NORTH_VERN("Noth Vern"),
    SHUSHIRE("Shushire"),
    ROHENDEL("Rohendel"),
    YORN("Yorn"),
    FEITON("Feiton"),
    PUNIKA("Punika"),
    SOUTH_VERN("South Vern");

    private final String name;

    private Continent(String name) {
        this.name = name;
    }

}
