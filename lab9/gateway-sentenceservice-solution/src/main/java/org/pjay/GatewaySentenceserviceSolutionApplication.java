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
    
    // Logs::
	//    2017-05-05 13:28:56.257  INFO 4616 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Starting heartbeat executor: renew interval is: 30
	//    2017-05-05 13:28:56.261  INFO 4616 --- [  restartedMain] c.n.discovery.InstanceInfoReplicator     : InstanceInfoReplicator onDemand update allowed rate per min is 4
	//    2017-05-05 13:28:56.265  INFO 4616 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Discovery Client initialized at timestamp 1493971136265 with initial instances count: 5
	//    2017-05-05 13:28:56.422  INFO 4616 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Registering application gateway with eureka with status UP
	//    2017-05-05 13:28:56.423  INFO 4616 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1493971136423, current=UP, previous=STARTING]
	//    2017-05-05 13:28:56.426  INFO 4616 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_GATEWAY/DESKTOP-02EQ34S:gateway: registering service...
	//    2017-05-05 13:28:56.525  INFO 4616 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_GATEWAY/DESKTOP-02EQ34S:gateway - registration status: 204
	//    2017-05-05 13:28:56.554  INFO 4616 --- [  restartedMain] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
	//    2017-05-05 13:28:56.687  INFO 4616 --- [  restartedMain] ration$HystrixMetricsPollerConfiguration : Starting poller
	//    2017-05-05 13:28:56.877  INFO 4616 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
	//    2017-05-05 13:28:56.881  INFO 4616 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8080
	//    2017-05-05 13:28:56.888  INFO 4616 --- [  restartedMain] atewaySentenceserviceSolutionApplication : Started GatewaySentenceserviceSolutionApplication in 24.51 seconds (JVM running for 25.842)
	//    2017-05-05 13:29:12.783  INFO 4616 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//    2017-05-05 13:29:12.783  INFO 4616 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//    2017-05-05 13:29:12.838  INFO 4616 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 55 ms
	//    2017-05-05 13:29:12.888  INFO 4616 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/services/article/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-05 13:29:12.888  INFO 4616 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/services/verb/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-05 13:29:12.889  INFO 4616 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/services/subject/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-05 13:29:12.889  INFO 4616 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/services/adjective/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-05 13:29:12.889  INFO 4616 --- [nio-8080-exec-1] o.s.c.n.zuul.web.ZuulHandlerMapping      : Mapped URL path [/services/noun/**] onto handler of type [class org.springframework.cloud.netflix.zuul.web.ZuulController]
	//    2017-05-05 13:29:18.939  INFO 4616 --- [nio-8080-exec-9] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@1e3d55ea: startup date [Fri May 05 13:29:18 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6ad6a85e
	//    2017-05-05 13:29:19.087  INFO 4616 --- [nio-8080-exec-9] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//    2017-05-05 13:29:19.479  INFO 4616 --- [nio-8080-exec-9] c.netflix.config.ChainedDynamicProperty  : Flipping property: adjective.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//    2017-05-05 13:29:19.510  INFO 4616 --- [nio-8080-exec-9] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-adjective
	//    2017-05-05 13:29:19.586  INFO 4616 --- [nio-8080-exec-9] c.netflix.loadbalancer.BaseLoadBalancer  : Client:adjective instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=adjective,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//    2017-05-05 13:29:19.596  INFO 4616 --- [nio-8080-exec-9] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//    2017-05-05 13:29:19.653  INFO 4616 --- [nio-8080-exec-9] c.netflix.config.ChainedDynamicProperty  : Flipping property: adjective.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//    2017-05-05 13:29:19.656  INFO 4616 --- [nio-8080-exec-9] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client adjective initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=adjective,current list of Servers=[DESKTOP-02EQ34S:adjective:85d8c35d413a61a3cb17cf4f6fba3db7],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//    },Server stats: [[Server:DESKTOP-02EQ34S:adjective:85d8c35d413a61a3cb17cf4f6fba3db7;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//    ]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@d5df1ab
    
    
    // Logs:: After verb service is killed and Hystrix fall back not available
    
	//    2017-05-05 14:03:55.263  WARN 4616 --- [nio-8080-exec-9] o.s.c.n.z.filters.post.SendErrorFilter   : Error during filtering
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
	//    Caused by: com.netflix.hystrix.exception.HystrixRuntimeException: verb timed-out and no fallback available.
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
	//
	//    2017-05-05 14:03:55.982  INFO 4616 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//    2017-05-05 14:08:55.983  INFO 4616 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration

}
