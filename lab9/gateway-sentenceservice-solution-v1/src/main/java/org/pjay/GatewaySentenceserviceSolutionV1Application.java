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
 * http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
 * http://ryanjbaxter.com/cloud/spring%20cloud/spring/2016/10/27/hystrix-fallbacks-with-zuul.html
 * https://github.com/spring-cloud/spring-cloud-netflix/blob/master/docs/src/main/asciidoc/spring-cloud-netflix.adoc#providing-hystrix-fallbacks-for-routes
 * https://github.com/spring-cloud-samples/zuul-server
 * https://github.com/spring-cloud-samples/zuul-server/blob/master/src/main/java/zuulserver/ZuulServerApplication.java
 * http://stackoverflow.com/questions/42216079/zuul-implementing-multiple-zuulfallbackprovider-for-multiple-zuul-routes
 * http://tachniki.blogspot.in/2017/02/generic-ZuulFallbackProvider.html
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/1283
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
    
    // Logs:: 
	//    2017-05-06 13:27:27.346  INFO 8380 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_GATEWAY/DESKTOP-02EQ34S:gateway: registering service...
	//    2017-05-06 13:27:27.394  INFO 8380 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_GATEWAY/DESKTOP-02EQ34S:gateway - registration status: 204
	//    2017-05-06 13:27:27.502  INFO 8380 --- [  restartedMain] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
	//    2017-05-06 13:27:27.508  INFO 8380 --- [  restartedMain] ration$HystrixMetricsPollerConfiguration : Starting poller
	//    2017-05-06 13:27:27.627  INFO 8380 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
	//    2017-05-06 13:27:27.629  INFO 8380 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8080
	//    2017-05-06 13:27:27.637  INFO 8380 --- [  restartedMain] ewaySentenceserviceSolutionV1Application : Started GatewaySentenceserviceSolutionV1Application in 16.682 seconds (JVM running for 17.791)
	//    2017-05-06 13:27:34.990  INFO 8380 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//    2017-05-06 13:27:34.990  INFO 8380 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//    2017-05-06 13:27:35.038  INFO 8380 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 48 ms
	//    2017-05-06 13:27:35.082  INFO 8380 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/verb/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-06 13:27:35.082  INFO 8380 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/gateway-service/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-06 13:27:35.082  INFO 8380 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/article/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-06 13:27:35.082  INFO 8380 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/subject/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-06 13:27:35.082  INFO 8380 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/adjective/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-06 13:27:35.082  INFO 8380 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/noun/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
    
}
