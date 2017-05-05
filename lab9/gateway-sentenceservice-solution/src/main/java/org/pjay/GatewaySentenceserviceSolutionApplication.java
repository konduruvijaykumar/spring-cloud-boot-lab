package org.pjay;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewaySentenceserviceSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySentenceserviceSolutionApplication.class, args);
	}
	
	// Not needed for this project
	// Etags used for caching data, instead of rebuilding response.
	// When server sends response for the first time, it calculates hash for the object and sends it to browser via etags
	// When browser requests for the object again the server will verify if browser sent hash via etag is same for the object response produced
	// If so the the server does not transmit the bulky object, instead sends 304 which indicates browser that the object or resource is not modified
	// So browser will use the existing. This reduces the bulky object transfer via network
	// https://httpstatuses.com/304 -- not modified
    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }    
}
