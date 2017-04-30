package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author vijayk
 *
 */

// IMP::
// http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
// http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign
// https://github.com/spring-cloud-samples
// http://stackoverflow.com/questions/39305684/spring-cloud-feign-feign-doesnt-put-parameter-into-http-body-when-issuing-post
// https://github.com/spring-cloud/spring-cloud-netflix/issues/1634
// https://github.com/OpenFeign/feign/blob/master/core/src/main/java/feign/RequestTemplate.java#L653
// https://github.com/OpenFeign/feign/issues/329#event-561389611
// https://github.com/spring-cloud/spring-cloud-netflix/issues/617

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class HystrixSentenceserviceSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSentenceserviceSolutionApplication.class, args);
	}
}
