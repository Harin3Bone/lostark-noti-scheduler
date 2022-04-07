package com.player.casual.lostark.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class LostarkNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostarkNotificationApplication.class, args);
	}

}
