package com.weathergif.weathergif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients
@SpringBootApplication
public class WeathergifApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeathergifApplication.class, args);
	}

}
