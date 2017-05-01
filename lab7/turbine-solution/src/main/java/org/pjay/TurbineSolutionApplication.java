package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author vijayk
 * 
 * https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 * management.port= # Management endpoint HTTP port. Uses the same port as the application by default. Configure a different port to use management-specific SSL.
 * 
 * TODO:
 * Not working properly, need to verify this
 * http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
 * https://github.com/Netflix/Turbine/wiki/Configuration-(1.x)
 * https://github.com/spring-cloud-samples/turbine
 * https://dzone.com/articles/spring-cloud-with-turbine
 * http://www.java-allandsundry.com/2016/01/spring-cloud-with-turbine.html
 * http://www.java-allandsundry.com/2016/05/spring-cloud-with-turbine-amqp.html
 * 
 */
@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class TurbineSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineSolutionApplication.class, args);
	}
	
	// not using present as part of lab instruction in code
	
//	@Bean
//	public TurbineProperties turbineProperties() {
//		return new TurbineProperties();
//	}
//
//	@Bean
//	public InstanceDiscovery instanceDiscovery() {
//		return new ConfigPropertyBasedDiscovery();
//	}
	
}
