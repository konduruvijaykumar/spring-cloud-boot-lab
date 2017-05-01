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
	
	// Logs::
	
	//	2017-05-01 07:07:26.434  INFO 10588 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8020: registering service...
	//	2017-05-01 07:07:26.508  INFO 10588 --- [  restartedMain] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
	//	2017-05-01 07:07:26.573  INFO 10588 --- [  restartedMain] ration$HystrixMetricsPollerConfiguration : Starting poller
	//	2017-05-01 07:07:26.578  INFO 10588 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8020 - registration status: 204
	//	2017-05-01 07:07:26.697  INFO 10588 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8020 (http)
	//	2017-05-01 07:07:26.698  INFO 10588 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8020
	//	2017-05-01 07:07:26.705  INFO 10588 --- [  restartedMain] ystrixSentenceserviceSolutionApplication : Started HystrixSentenceserviceSolutionApplication in 18.316 seconds (JVM running for 19.475)
	//	2017-05-01 07:08:56.772  INFO 10588 --- [nio-8020-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//	2017-05-01 07:08:56.772  INFO 10588 --- [nio-8020-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//	2017-05-01 07:08:56.848  INFO 10588 --- [nio-8020-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 76 ms
	//	2017-05-01 07:09:02.488  INFO 10588 --- [strix-SUBJECT-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@23dbb7d1: startup date [Mon May 01 07:09:02 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5e31f866
	//	2017-05-01 07:09:02.551  INFO 10588 --- [strix-SUBJECT-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 07:09:02.831  INFO 10588 --- [strix-SUBJECT-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:02.860  INFO 10588 --- [strix-SUBJECT-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-SUBJECT
	//	2017-05-01 07:09:02.914  INFO 10588 --- [strix-SUBJECT-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:SUBJECT instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=SUBJECT,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 07:09:02.920  INFO 10588 --- [strix-SUBJECT-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 07:09:02.974  INFO 10588 --- [strix-SUBJECT-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:02.977  INFO 10588 --- [strix-SUBJECT-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client SUBJECT initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=SUBJECT,current list of Servers=[DESKTOP-02EQ34S:subject:c06a03a6f2e41e6f7621b73b30e12d4a],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:subject:c06a03a6f2e41e6f7621b73b30e12d4a;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@387fdcaf
	//	2017-05-01 07:09:03.203  INFO 10588 --- [ hystrix-VERB-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@39889c57: startup date [Mon May 01 07:09:03 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5e31f866
	//	2017-05-01 07:09:03.234  INFO 10588 --- [ hystrix-VERB-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 07:09:03.257  INFO 10588 --- [ hystrix-VERB-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.260  INFO 10588 --- [ hystrix-VERB-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-VERB
	//	2017-05-01 07:09:03.260  INFO 10588 --- [ hystrix-VERB-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:VERB instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=VERB,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 07:09:03.261  INFO 10588 --- [ hystrix-VERB-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 07:09:03.263  INFO 10588 --- [ hystrix-VERB-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.264  INFO 10588 --- [ hystrix-VERB-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client VERB initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=VERB,current list of Servers=[DESKTOP-02EQ34S:verb:d6cb177113302038d8d4e046fd7f76dd],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:verb:d6cb177113302038d8d4e046fd7f76dd;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@6512558e
	//	2017-05-01 07:09:03.308  INFO 10588 --- [strix-ARTICLE-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@66386403: startup date [Mon May 01 07:09:03 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5e31f866
	//	2017-05-01 07:09:03.334  INFO 10588 --- [strix-ARTICLE-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 07:09:03.349  INFO 10588 --- [strix-ARTICLE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.351  INFO 10588 --- [strix-ARTICLE-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-ARTICLE
	//	2017-05-01 07:09:03.352  INFO 10588 --- [strix-ARTICLE-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:ARTICLE instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=ARTICLE,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 07:09:03.353  INFO 10588 --- [strix-ARTICLE-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 07:09:03.354  INFO 10588 --- [strix-ARTICLE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.355  INFO 10588 --- [strix-ARTICLE-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client ARTICLE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=ARTICLE,current list of Servers=[DESKTOP-02EQ34S:article:356d8b1df96ffb37e2a34d1200c2520f],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:article:356d8b1df96ffb37e2a34d1200c2520f;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@56b142b3
	//	2017-05-01 07:09:03.532  INFO 10588 --- [rix-ADJECTIVE-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@46c3dd93: startup date [Mon May 01 07:09:03 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5e31f866
	//	2017-05-01 07:09:03.562  INFO 10588 --- [rix-ADJECTIVE-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 07:09:03.580  INFO 10588 --- [rix-ADJECTIVE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.582  INFO 10588 --- [rix-ADJECTIVE-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-ADJECTIVE
	//	2017-05-01 07:09:03.584  INFO 10588 --- [rix-ADJECTIVE-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:ADJECTIVE instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=ADJECTIVE,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 07:09:03.585  INFO 10588 --- [rix-ADJECTIVE-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 07:09:03.586  INFO 10588 --- [rix-ADJECTIVE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.586  INFO 10588 --- [rix-ADJECTIVE-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client ADJECTIVE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=ADJECTIVE,current list of Servers=[DESKTOP-02EQ34S:adjective:ede01eba6b341cd5f190b9bcda48946a],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:adjective:ede01eba6b341cd5f190b9bcda48946a;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@17f06d78
	//	2017-05-01 07:09:03.671  INFO 10588 --- [ hystrix-NOUN-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@d6c81d0: startup date [Mon May 01 07:09:03 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5e31f866
	//	2017-05-01 07:09:03.707  INFO 10588 --- [ hystrix-NOUN-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 07:09:03.718  INFO 10588 --- [ hystrix-NOUN-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.720  INFO 10588 --- [ hystrix-NOUN-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-NOUN
	//	2017-05-01 07:09:03.721  INFO 10588 --- [ hystrix-NOUN-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:NOUN instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=NOUN,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 07:09:03.721  INFO 10588 --- [ hystrix-NOUN-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 07:09:03.722  INFO 10588 --- [ hystrix-NOUN-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:03.723  INFO 10588 --- [ hystrix-NOUN-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client NOUN initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=NOUN,current list of Servers=[DESKTOP-02EQ34S:noun:21f65d7107123e2dddec96b370d09a95],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:noun:21f65d7107123e2dddec96b370d09a95;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@54b2869c
	//	2017-05-01 07:09:03.929  INFO 10588 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:04.283  INFO 10588 --- [erListUpdater-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:04.354  INFO 10588 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:04.586  INFO 10588 --- [erListUpdater-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:09:04.723  INFO 10588 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 07:17:25.771  INFO 10588 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-05-01 07:17:53.127  INFO 10588 --- [nio-8020-exec-8] ashboardConfiguration$ProxyStreamServlet : 
	//
	//	Proxy opening connection to: http://localhost:8020/hystrix.stream
	//
	//
	//	2017-05-01 07:17:53.129  INFO 10588 --- [nio-8020-exec-7] ashboardConfiguration$ProxyStreamServlet : 
	//
	//	Proxy opening connection to: http://localhost:8020/hystrix.stream
	
	// Logs after word service not having fallback stops
	
	//	2017-05-01 07:33:39.864 ERROR 10588 --- [nio-8020-exec-6] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is com.netflix.hystrix.exception.HystrixRuntimeException: VerbFeignClient#getWord() timed-out and no fallback available.] with root cause
	//
	//	                                                                       java.util.concurrent.TimeoutException: null
	//	                                                                       	at com.netflix.hystrix.AbstractCommand.handleTimeoutViaFallback(AbstractCommand.java:980) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.AbstractCommand.access$500(AbstractCommand.java:59) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.AbstractCommand$12.call(AbstractCommand.java:595) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.AbstractCommand$12.call(AbstractCommand.java:587) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$4.onError(OperatorOnErrorResumeNextViaFunction.java:140) ~[rxjava-1.1.10.jar:1.1.10]
	//	                                                                       	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//	                                                                       	at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//	                                                                       	at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$1.run(AbstractCommand.java:1121) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:41) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:37) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable.run(HystrixContextRunnable.java:57) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$2.tick(AbstractCommand.java:1138) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at com.netflix.hystrix.util.HystrixTimer$1.run(HystrixTimer.java:99) ~[hystrix-core-1.5.6.jar:1.5.6]
	//	                                                                       	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) ~[na:1.8.0_121]
	//	                                                                       	at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308) ~[na:1.8.0_121]
	//	                                                                       	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180) ~[na:1.8.0_121]
	//	                                                                       	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294) ~[na:1.8.0_121]
	//	                                                                       	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) ~[na:1.8.0_121]
	//	                                                                       	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) ~[na:1.8.0_121]
	//	                                                                       	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_121]

}
