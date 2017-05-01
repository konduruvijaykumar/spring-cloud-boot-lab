package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HystrixSentenceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSentenceserviceApplication.class, args);
	}
	
	// Logs:: first attempt failed due to timeout for hystrix, but we have not used hystrix code here. Need to verify and from second attempt it started working fine 
	
	//	2017-05-01 06:11:33.622  INFO 8564 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8020: registering service...
	//	2017-05-01 06:11:33.760  INFO 8564 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8020 - registration status: 204
	//	2017-05-01 06:11:33.808  INFO 8564 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8020 (http)
	//	2017-05-01 06:11:33.809  INFO 8564 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8020
	//	2017-05-01 06:11:33.814  INFO 8564 --- [  restartedMain] o.p.HystrixSentenceserviceApplication    : Started HystrixSentenceserviceApplication in 14.496 seconds (JVM running for 15.452)
	//	2017-05-01 06:11:59.828  INFO 8564 --- [nio-8020-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//	2017-05-01 06:11:59.830  INFO 8564 --- [nio-8020-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//	2017-05-01 06:11:59.884  INFO 8564 --- [nio-8020-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 53 ms
	//	2017-05-01 06:12:15.937  INFO 8564 --- [strix-SUBJECT-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@38c864e7: startup date [Mon May 01 06:12:15 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@72087627
	//	2017-05-01 06:12:16.075  INFO 8564 --- [strix-SUBJECT-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 06:12:16.424  INFO 8564 --- [strix-SUBJECT-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:16.462  INFO 8564 --- [strix-SUBJECT-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-SUBJECT
	//	2017-05-01 06:12:16.563  INFO 8564 --- [strix-SUBJECT-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:SUBJECT instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=SUBJECT,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 06:12:16.567  INFO 8564 --- [strix-SUBJECT-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 06:12:16.632  INFO 8564 --- [strix-SUBJECT-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:16.635  INFO 8564 --- [strix-SUBJECT-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client SUBJECT initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=SUBJECT,current list of Servers=[DESKTOP-02EQ34S:subject:91198458aa1623919736316c69d13413],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:subject:91198458aa1623919736316c69d13413;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@51567974
	//	2017-05-01 06:12:16.979 ERROR 8564 --- [nio-8020-exec-3] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is com.netflix.hystrix.exception.HystrixRuntimeException: SubjectFeignClient#getWord() timed-out and no fallback available.] with root cause
	//
	//	java.util.concurrent.TimeoutException: null
	//		at com.netflix.hystrix.AbstractCommand.handleTimeoutViaFallback(AbstractCommand.java:980) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.AbstractCommand.access$500(AbstractCommand.java:59) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.AbstractCommand$12.call(AbstractCommand.java:595) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.AbstractCommand$12.call(AbstractCommand.java:587) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at rx.internal.operators.OperatorOnErrorResumeNextViaFunction$4.onError(OperatorOnErrorResumeNextViaFunction.java:140) ~[rxjava-1.1.10.jar:1.1.10]
	//		at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//		at rx.internal.operators.OnSubscribeDoOnEach$DoOnEachSubscriber.onError(OnSubscribeDoOnEach.java:87) ~[rxjava-1.1.10.jar:1.1.10]
	//		at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$1.run(AbstractCommand.java:1121) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:41) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable$1.call(HystrixContextRunnable.java:37) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.strategy.concurrency.HystrixContextRunnable.run(HystrixContextRunnable.java:57) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.AbstractCommand$HystrixObservableTimeoutOperator$2.tick(AbstractCommand.java:1138) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at com.netflix.hystrix.util.HystrixTimer$1.run(HystrixTimer.java:99) ~[hystrix-core-1.5.6.jar:1.5.6]
	//		at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) ~[na:1.8.0_121]
	//		at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308) ~[na:1.8.0_121]
	//		at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180) ~[na:1.8.0_121]
	//		at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294) ~[na:1.8.0_121]
	//		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) ~[na:1.8.0_121]
	//		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) ~[na:1.8.0_121]
	//		at java.lang.Thread.run(Thread.java:745) [na:1.8.0_121]
	//
	//	2017-05-01 06:12:17.573  INFO 8564 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.148  INFO 8564 --- [ hystrix-VERB-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@4dd200be: startup date [Mon May 01 06:12:53 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@72087627
	//	2017-05-01 06:12:53.197  INFO 8564 --- [ hystrix-VERB-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 06:12:53.238  INFO 8564 --- [ hystrix-VERB-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.246  INFO 8564 --- [ hystrix-VERB-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-VERB
	//	2017-05-01 06:12:53.246  INFO 8564 --- [ hystrix-VERB-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:VERB instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=VERB,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 06:12:53.247  INFO 8564 --- [ hystrix-VERB-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 06:12:53.248  INFO 8564 --- [ hystrix-VERB-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.252  INFO 8564 --- [ hystrix-VERB-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client VERB initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=VERB,current list of Servers=[DESKTOP-02EQ34S:verb:0fcf5d3f4c53cbba22551f3dc3aec493],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:verb:0fcf5d3f4c53cbba22551f3dc3aec493;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@64380f3f
	//	2017-05-01 06:12:53.314  INFO 8564 --- [strix-ARTICLE-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@50abe598: startup date [Mon May 01 06:12:53 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@72087627
	//	2017-05-01 06:12:53.341  INFO 8564 --- [strix-ARTICLE-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 06:12:53.365  INFO 8564 --- [strix-ARTICLE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.369  INFO 8564 --- [strix-ARTICLE-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-ARTICLE
	//	2017-05-01 06:12:53.370  INFO 8564 --- [strix-ARTICLE-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:ARTICLE instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=ARTICLE,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 06:12:53.372  INFO 8564 --- [strix-ARTICLE-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 06:12:53.373  INFO 8564 --- [strix-ARTICLE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.374  INFO 8564 --- [strix-ARTICLE-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client ARTICLE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=ARTICLE,current list of Servers=[DESKTOP-02EQ34S:article:3faf027808a8cf7d660c213fae02e28d],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:article:3faf027808a8cf7d660c213fae02e28d;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@38b07994
	//	2017-05-01 06:12:53.431  INFO 8564 --- [rix-ADJECTIVE-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@27efa2fd: startup date [Mon May 01 06:12:53 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@72087627
	//	2017-05-01 06:12:53.456  INFO 8564 --- [rix-ADJECTIVE-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 06:12:53.483  INFO 8564 --- [rix-ADJECTIVE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.488  INFO 8564 --- [rix-ADJECTIVE-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-ADJECTIVE
	//	2017-05-01 06:12:53.489  INFO 8564 --- [rix-ADJECTIVE-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:ADJECTIVE instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=ADJECTIVE,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 06:12:53.490  INFO 8564 --- [rix-ADJECTIVE-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 06:12:53.492  INFO 8564 --- [rix-ADJECTIVE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.494  INFO 8564 --- [rix-ADJECTIVE-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client ADJECTIVE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=ADJECTIVE,current list of Servers=[DESKTOP-02EQ34S:adjective:d2eee79dbd5c19321898f7e4be9e8457],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:adjective:d2eee79dbd5c19321898f7e4be9e8457;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@74f41042
	//	2017-05-01 06:12:53.550  INFO 8564 --- [ hystrix-NOUN-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@56ce521b: startup date [Mon May 01 06:12:53 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@72087627
	//	2017-05-01 06:12:53.576  INFO 8564 --- [ hystrix-NOUN-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 06:12:53.587  INFO 8564 --- [ hystrix-NOUN-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.589  INFO 8564 --- [ hystrix-NOUN-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-NOUN
	//	2017-05-01 06:12:53.590  INFO 8564 --- [ hystrix-NOUN-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:NOUN instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=NOUN,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 06:12:53.592  INFO 8564 --- [ hystrix-NOUN-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 06:12:53.594  INFO 8564 --- [ hystrix-NOUN-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:53.595  INFO 8564 --- [ hystrix-NOUN-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client NOUN initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=NOUN,current list of Servers=[DESKTOP-02EQ34S:noun:9d3af65f80a8f9f779963d71c61dabea],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:noun:9d3af65f80a8f9f779963d71c61dabea;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@6fe163b4
	//	2017-05-01 06:12:54.270  INFO 8564 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:54.373  INFO 8564 --- [erListUpdater-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:54.492  INFO 8564 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 06:12:54.594  INFO 8564 --- [erListUpdater-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647

}
