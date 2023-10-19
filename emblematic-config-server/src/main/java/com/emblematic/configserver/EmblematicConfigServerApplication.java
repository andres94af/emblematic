package com.emblematic.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EmblematicConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmblematicConfigServerApplication.class, args);
	}

}
