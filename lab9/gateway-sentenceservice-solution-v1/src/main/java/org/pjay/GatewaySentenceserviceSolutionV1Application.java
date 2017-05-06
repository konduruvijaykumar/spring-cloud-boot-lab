package org.pjay;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

/**
 * @author vijayk
 *
 * http://ryanjbaxter.com/cloud/spring%20cloud/spring/2016/10/27/hystrix-fallbacks-with-zuul.html
 * https://github.com/spring-cloud/spring-cloud-netflix/blob/master/docs/src/main/asciidoc/spring-cloud-netflix.adoc#providing-hystrix-fallbacks-for-routes
 * https://github.com/spring-cloud-samples/zuul-server
 * https://github.com/spring-cloud-samples/zuul-server/blob/master/src/main/java/zuulserver/ZuulServerApplication.java
 * http://stackoverflow.com/questions/42216079/zuul-implementing-multiple-zuulfallbackprovider-for-multiple-zuul-routes
 * http://tachniki.blogspot.in/2017/02/generic-ZuulFallbackProvider.html
 * 
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewaySentenceserviceSolutionV1Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySentenceserviceSolutionV1Application.class, args);
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
