package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignWordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignWordServiceApplication.class, args);
	}
}
