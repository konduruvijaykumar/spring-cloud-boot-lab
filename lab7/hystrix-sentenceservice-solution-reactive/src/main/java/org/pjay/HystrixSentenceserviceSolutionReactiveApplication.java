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
	
	// Logs::
	
	//	2017-05-01 08:16:32.825  INFO 11556 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Starting heartbeat executor: renew interval is: 30
	//	2017-05-01 08:16:32.828  INFO 11556 --- [  restartedMain] c.n.discovery.InstanceInfoReplicator     : InstanceInfoReplicator onDemand update allowed rate per min is 4
	//	2017-05-01 08:16:32.832  INFO 11556 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Discovery Client initialized at timestamp 1493606792832 with initial instances count: 7
	//	2017-05-01 08:16:32.967  INFO 11556 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Registering application sentence with eureka with status UP
	//	2017-05-01 08:16:32.968  INFO 11556 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1493606792968, current=UP, previous=STARTING]
	//	2017-05-01 08:16:32.971  INFO 11556 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8021: registering service...
	//	2017-05-01 08:16:33.051  INFO 11556 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8021 - registration status: 204
	//	2017-05-01 08:16:33.056  INFO 11556 --- [  restartedMain] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
	//	2017-05-01 08:16:33.062  INFO 11556 --- [  restartedMain] ration$HystrixMetricsPollerConfiguration : Starting poller
	//	2017-05-01 08:16:33.182  INFO 11556 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8021 (http)
	//	2017-05-01 08:16:33.184  INFO 11556 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8021
	//	2017-05-01 08:16:33.191  INFO 11556 --- [  restartedMain] ntenceserviceSolutionReactiveApplication : Started HystrixSentenceserviceSolutionReactiveApplication in 17.123 seconds (JVM running for 18.137)
	//	2017-05-01 08:20:32.901  INFO 11556 --- [tbeatExecutor-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8021 - Re-registering apps/SENTENCE
	//	2017-05-01 08:20:32.902  INFO 11556 --- [tbeatExecutor-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8021: registering service...
	//	2017-05-01 08:20:32.909  INFO 11556 --- [tbeatExecutor-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_SENTENCE/DESKTOP-02EQ34S:sentence:8021 - registration status: 204
	//	2017-05-01 08:21:17.515  INFO 11556 --- [nio-8021-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//	2017-05-01 08:21:17.515  INFO 11556 --- [nio-8021-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//	2017-05-01 08:21:17.579  INFO 11556 --- [nio-8021-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 64 ms
	//	2017-05-01 08:21:32.639  INFO 11556 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-05-01 08:23:00.893  INFO 11556 --- [strix-SUBJECT-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7012415a: startup date [Mon May 01 08:23:00 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@51642f6
	//	2017-05-01 08:23:00.961  INFO 11556 --- [strix-SUBJECT-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 08:23:01.313  INFO 11556 --- [strix-SUBJECT-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:01.375  INFO 11556 --- [strix-SUBJECT-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-SUBJECT
	//	2017-05-01 08:23:01.562  INFO 11556 --- [strix-SUBJECT-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:SUBJECT instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=SUBJECT,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 08:23:01.567  INFO 11556 --- [strix-SUBJECT-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 08:23:01.605  INFO 11556 --- [strix-SUBJECT-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:01.608  INFO 11556 --- [strix-SUBJECT-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client SUBJECT initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=SUBJECT,current list of Servers=[DESKTOP-02EQ34S:subject:faa59bfd269a093e744cb60dc161e927],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:subject:faa59bfd269a093e744cb60dc161e927;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@102f84c5
	//	2017-05-01 08:23:01.785  INFO 11556 --- [rix-ADJECTIVE-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@44288240: startup date [Mon May 01 08:23:01 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@51642f6
	//	2017-05-01 08:23:01.881  INFO 11556 --- [rix-ADJECTIVE-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 08:23:01.917  INFO 11556 --- [rix-ADJECTIVE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:01.919  INFO 11556 --- [rix-ADJECTIVE-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-ADJECTIVE
	//	2017-05-01 08:23:01.920  INFO 11556 --- [rix-ADJECTIVE-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:ADJECTIVE instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=ADJECTIVE,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 08:23:01.921  INFO 11556 --- [rix-ADJECTIVE-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 08:23:01.932  INFO 11556 --- [rix-ADJECTIVE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:01.934  INFO 11556 --- [rix-ADJECTIVE-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client ADJECTIVE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=ADJECTIVE,current list of Servers=[DESKTOP-02EQ34S:adjective:1448b5f566e43d5f23f6aeb1b08cda1b],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:adjective:1448b5f566e43d5f23f6aeb1b08cda1b;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@18de67cd
	//	2017-05-01 08:23:01.972  INFO 11556 --- [ hystrix-NOUN-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@70d56c8a: startup date [Mon May 01 08:23:01 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@51642f6
	//	2017-05-01 08:23:02.013  INFO 11556 --- [ hystrix-NOUN-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 08:23:02.038  INFO 11556 --- [ hystrix-NOUN-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:02.044  INFO 11556 --- [ hystrix-NOUN-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-NOUN
	//	2017-05-01 08:23:02.045  INFO 11556 --- [ hystrix-NOUN-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:NOUN instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=NOUN,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 08:23:02.046  INFO 11556 --- [ hystrix-NOUN-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 08:23:02.047  INFO 11556 --- [ hystrix-NOUN-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:02.049  INFO 11556 --- [ hystrix-NOUN-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client NOUN initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=NOUN,current list of Servers=[DESKTOP-02EQ34S:noun:15980872afb249cc033c8bb61869225f],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:noun:15980872afb249cc033c8bb61869225f;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@49b0caa4
	//	2017-05-01 08:23:02.079  INFO 11556 --- [ hystrix-VERB-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@40f6ff39: startup date [Mon May 01 08:23:02 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@51642f6
	//	2017-05-01 08:23:02.108  INFO 11556 --- [ hystrix-VERB-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 08:23:02.136  INFO 11556 --- [ hystrix-VERB-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:02.139  INFO 11556 --- [ hystrix-VERB-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-VERB
	//	2017-05-01 08:23:02.140  INFO 11556 --- [ hystrix-VERB-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:VERB instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=VERB,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 08:23:02.144  INFO 11556 --- [ hystrix-VERB-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 08:23:02.145  INFO 11556 --- [ hystrix-VERB-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:02.146  INFO 11556 --- [ hystrix-VERB-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client VERB initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=VERB,current list of Servers=[DESKTOP-02EQ34S:verb:b9fce3e6b3f68a8c888deac7acf551b3],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:verb:b9fce3e6b3f68a8c888deac7acf551b3;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@2afac92c
	//	2017-05-01 08:23:02.166  INFO 11556 --- [strix-ARTICLE-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@522da50a: startup date [Mon May 01 08:23:02 IST 2017]; parent: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@51642f6
	//	2017-05-01 08:23:02.192  INFO 11556 --- [strix-ARTICLE-1] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-05-01 08:23:02.234  INFO 11556 --- [strix-ARTICLE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:02.235  INFO 11556 --- [strix-ARTICLE-1] c.n.u.concurrent.ShutdownEnabledTimer    : Shutdown hook installed for: NFLoadBalancer-PingTimer-ARTICLE
	//	2017-05-01 08:23:02.236  INFO 11556 --- [strix-ARTICLE-1] c.netflix.loadbalancer.BaseLoadBalancer  : Client:ARTICLE instantiated a LoadBalancer:DynamicServerListLoadBalancer:{NFLoadBalancer:name=ARTICLE,current list of Servers=[],Load balancer stats=Zone stats: {},Server stats: []}ServerList:null
	//	2017-05-01 08:23:02.237  INFO 11556 --- [strix-ARTICLE-1] c.n.l.DynamicServerListLoadBalancer      : Using serverListUpdater PollingServerListUpdater
	//	2017-05-01 08:23:02.238  INFO 11556 --- [strix-ARTICLE-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:02.239  INFO 11556 --- [strix-ARTICLE-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client ARTICLE initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=ARTICLE,current list of Servers=[DESKTOP-02EQ34S:article:1c96ab5c07dbb8b698211773efc74922],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:1;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
	//	},Server stats: [[Server:DESKTOP-02EQ34S:article:1c96ab5c07dbb8b698211773efc74922;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Thu Jan 01 05:30:00 IST 1970;	First connection made: Thu Jan 01 05:30:00 IST 1970;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
	//	]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@b7ef975
	//	2017-05-01 08:23:02.636  INFO 11556 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: SUBJECT.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:03.035  INFO 11556 --- [erListUpdater-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ADJECTIVE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:03.049  INFO 11556 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: NOUN.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:03.155  INFO 11556 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: VERB.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
	//	2017-05-01 08:23:03.247  INFO 11556 --- [erListUpdater-1] c.netflix.config.ChainedDynamicProperty  : Flipping property: ARTICLE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
}
