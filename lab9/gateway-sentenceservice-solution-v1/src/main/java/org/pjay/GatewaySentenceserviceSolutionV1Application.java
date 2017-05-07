package org.pjay;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
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
 * IMP::
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/321
 * http://stackoverflow.com/questions/35376860/zuul-proxy-not-able-to-route-resulting-in-com-netflix-zuul-exception-zuulexcept
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/1888
 * https://github.com/Netflix/ribbon/wiki/Getting-Started#the-properties-file-sample-clientproperties
 * https://github.com/Netflix/Hystrix/wiki/Configuration#execution.isolation.thread.timeoutInMilliseconds
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/1417
 * https://github.com/Netflix/zuul/wiki/How-it-Works
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
    
    
    // Logs:: after making changes to Zuul routes, we just made changes for verb and gateway services
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/verb-service/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/gateway-service/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/article/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/verb/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/subject/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/adjective/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//	2017-05-06 22:12:17.455  INFO 7708 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/api/noun/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]

    // Lets create a common or general ZuulFallbackProvider for all services
    // according to spring cloud documentation http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
    // return * or null for getRoute() overridden then same fall back for all services. If a specific route name is given then it is specific for that service
    // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
    
    // http://stackoverflow.com/questions/10930624/creating-json-objects-directly-from-model-classes-in-java
    // https://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
    
    // http://stackoverflow.com/questions/32113671/zuulproxy-fails-with-ribboncommand-timed-out-and-no-fallback-available-when-it
    // https://github.com/spring-cloud/spring-cloud-netflix/issues/1461
    // https://github.com/spring-cloud/spring-cloud-netflix/issues/321
    // http://stackoverflow.com/questions/39776876/setting-default-fallback-for-zuul-routing-failures
    // http://stackoverflow.com/questions/37748378/fallback-methods-at-zuul-server-in-spring-cloud/40622638#40622638
    
    // This is not working when server is not available or down, let's try having a service with delay inresponse 
    @Bean
    public ZuulFallbackProvider getZuulFallbackProvider(){
    	return new ZuulFallbackProvider(){

			@Override
			public String getRoute() {
				// return null;
				return "*";
			}

			@Override
			public ClientHttpResponse fallbackResponse() {
				//return null;
				return new ClientHttpResponse() {
					
					@Override
					public HttpHeaders getHeaders() {
		                HttpHeaders headers = new HttpHeaders();
		                headers.setContentType(MediaType.APPLICATION_JSON);
		                return headers;
					}
					
					@Override
					public InputStream getBody() throws IOException {
						//JSONObject jsonObj = new JSONObject();
						JSONObject jsonObj = new JSONObject(new Word("Service is temporarily unavailable, please try again later"));
						return new ByteArrayInputStream(jsonObj.toString().getBytes());
					}
					
					@Override
					public String getStatusText() throws IOException {
						return "Service Unavailable";
					}
					
					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE;
					}
					
					@Override
					public int getRawStatusCode() throws IOException {
						return 503;
					}
					
					@Override
					public void close() {
						
					}
				};
			}
    		
    	};
    }
    
    // TODO
    // Unable to trigger even for timeout service, though the server is running. Please try later to solve this problem
    // Logs:: not unable to find solution
	//    2017-05-07 17:06:49.162  INFO 3036 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//    2017-05-07 17:08:30.082  WARN 3036 --- [io-8080-exec-10] o.s.c.n.z.filters.post.SendErrorFilter   : Error during filtering
	//
	//    com.netflix.zuul.exception.ZuulException: Forwarding error
	//    	at org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter.handleException(RibbonRoutingFilter.java:170) ~[spring-cloud-netflix-core-1.2.6.RELEASE.jar:1.2.6.RELEASE]
	//    	at org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter.forward(RibbonRoutingFilter.java:145) ~[spring-cloud-netflix-core-1.2.6.RELEASE.jar:1.2.6.RELEASE]
	//    	at org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter.run(RibbonRoutingFilter.java:88) ~[spring-cloud-netflix-core-1.2.6.RELEASE.jar:1.2.6.RELEASE]
	//    	at com.netflix.zuul.ZuulFilter.runFilter(ZuulFilter.java:112) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at com.netflix.zuul.FilterProcessor.processZuulFilter(FilterProcessor.java:193) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at com.netflix.zuul.FilterProcessor.runFilters(FilterProcessor.java:157) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at com.netflix.zuul.FilterProcessor.route(FilterProcessor.java:118) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at com.netflix.zuul.ZuulRunner.route(ZuulRunner.java:96) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at com.netflix.zuul.http.ZuulServlet.route(ZuulServlet.java:116) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at com.netflix.zuul.http.ZuulServlet.service(ZuulServlet.java:81) ~[zuul-core-1.3.0.jar:1.3.0]
	//    	at org.springframework.web.servlet.mvc.ServletWrappingController.handleRequestInternal(ServletWrappingController.java:157) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.cloud.netflix.zuul.web.ZuulController.handleRequest(ZuulController.java:44) [spring-cloud-netflix-core-1.2.6.RELEASE.jar:1.2.6.RELEASE]
	//    	at org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter.handle(SimpleControllerHandlerAdapter.java:50) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:963) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:897) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at javax.servlet.http.HttpServlet.service(HttpServlet.java:622) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) [spring-webmvc-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at javax.servlet.http.HttpServlet.service(HttpServlet.java:729) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:230) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) [tomcat-embed-websocket-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.boot.web.filter.ApplicationContextHeaderFilter.doFilterInternal(ApplicationContextHeaderFilter.java:55) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.web.filter.ShallowEtagHeaderFilter.doFilterInternal(ShallowEtagHeaderFilter.java:110) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:105) [spring-boot-actuator-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:105) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.springframework.boot.actuate.autoconfigure.MetricsFilter.doFilterInternal(MetricsFilter.java:107) [spring-boot-actuator-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) [spring-web-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:192) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:165) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:108) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:472) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:349) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:784) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:802) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1410) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_121]
	//    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_121]
	//    	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.5.6.jar:8.5.6]
	//    	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_121]
	//    Caused by: com.netflix.hystrix.exception.HystrixRuntimeException: noun timed-out and no fallback available.
	//    	at com.netflix.hystrix.AbstractCommand$22.call(AbstractCommand.java:805) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.AbstractCommand$22.call(AbstractCommand.java:790) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$4.onError(OperatorOnErrorResumeNextViaFunction.java:140) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at com.netflix.hystrix.AbstractCommand$DeprecatedOnFallbackHookApplication$1.onError(AbstractCommand.java:1451) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.AbstractCommand$FallbackHookApplication$1.onError(AbstractCommand.java:1376) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.observers.Subscribers$5.onError(Subscribers.java:230) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeThrow.call(OnSubscribeThrow.java:44) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeThrow.call(OnSubscribeThrow.java:28) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.Observable.unsafeSubscribe(Observable.java:10211) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:51) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:35) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.Observable.unsafeSubscribe(Observable.java:10211) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:41) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.Observable.unsafeSubscribe(Observable.java:10211) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:41) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.Observable.unsafeSubscribe(Observable.java:10211) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:41) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.Observable.unsafeSubscribe(Observable.java:10211) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:41) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.Observable.unsafeSubscribe(Observable.java:10211) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$4.onError(OperatorOnErrorResumeNextViaFunction.java:142) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//    	at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$1.run(AbstractCommand.java:1121) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:41) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:37) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable.run(HystrixContextRunnable.java:57) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$2.tick(AbstractCommand.java:1138) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.util.HystrixTimer$1.run(HystrixTimer.java:99) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) ~[na:1.8.0_121]
	//    	at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308) ~[na:1.8.0_121]
	//    	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180) ~[na:1.8.0_121]
	//    	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294) ~[na:1.8.0_121]
	//    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_121]
	//    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_121]
	//    	... 1 common frames omitted
	//    Caused by: java.util.concurrent.TimeoutException: null
	//    	at com.netflix.hystrix.AbstractCommand.handleTimeoutViaFallback(AbstractCommand.java:980) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.AbstractCommand.access$500(AbstractCommand.java:59) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.AbstractCommand$12.call(AbstractCommand.java:595) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at com.netflix.hystrix.AbstractCommand$12.call(AbstractCommand.java:587) ~[hystrix-core-1.5.6.jar:1.5.6]
	//    	at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$4.onError(OperatorOnErrorResumeNextViaFunction.java:140) ~[rxjava-1.1.10.jar:1.1.10]
	//    	... 15 common frames omitted
    
}
