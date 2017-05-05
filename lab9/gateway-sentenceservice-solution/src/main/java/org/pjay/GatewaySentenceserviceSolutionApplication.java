package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewaySentenceserviceSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySentenceserviceSolutionApplication.class, args);
	}
}
