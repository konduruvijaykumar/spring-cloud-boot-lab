package org.pjay;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class HystrixSentenceserviceSolutionReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSentenceserviceSolutionReactiveApplication.class, args);
	}
	
	// Create a Thread pool executor bean with size of thread pool as 6. I am expecting it to be 5 as we call five word services
	// Need to test and check
	@Bean
	public Executor getThreadPoolExecutor(){
		//return Executors.newFixedThreadPool(6);
		return Executors.newFixedThreadPool(5);
	}
}
