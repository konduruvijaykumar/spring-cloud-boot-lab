package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4RestserviceNounApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4RestserviceNounApplication.class, args);
	}
	
	// Logs on start:
	//	2017-04-15 22:47:44.330  INFO 8156 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
	//	2017-04-15 22:47:44.528  INFO 8156 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 57018 (http)
	//	2017-04-15 22:47:44.529  INFO 8156 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 57018
	//	2017-04-15 22:47:44.543  INFO 8156 --- [           main] o.s.c.n.eureka.InstanceInfoFactory       : Setting initial instance status as: STARTING
	//	2017-04-15 22:47:45.522  INFO 8156 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using JSON encoding codec LegacyJacksonJson
	//	2017-04-15 22:47:45.529  INFO 8156 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using JSON decoding codec LegacyJacksonJson
	//	2017-04-15 22:47:45.747  INFO 8156 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using XML encoding codec XStreamXml
	//	2017-04-15 22:47:45.748  INFO 8156 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using XML decoding codec XStreamXml
	//	2017-04-15 22:47:46.131  INFO 8156 --- [           main] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-15 22:47:46.393  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Disable delta property : false
	//	2017-04-15 22:47:46.395  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Single vip registry refresh property : null
	//	2017-04-15 22:47:46.395  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Force full registry fetch : false
	//	2017-04-15 22:47:46.396  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Application is null : false
	//	2017-04-15 22:47:46.396  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Registered Applications size is zero : true
	//	2017-04-15 22:47:46.396  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Application version is -1: true
	//	2017-04-15 22:47:46.396  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Getting all instance registry info from the eureka server
	//	2017-04-15 22:47:46.760  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : The response status is 200
	//	2017-04-15 22:47:46.762  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Starting heartbeat executor: renew interval is: 30
	//	2017-04-15 22:47:46.768  INFO 8156 --- [           main] c.n.discovery.InstanceInfoReplicator     : InstanceInfoReplicator onDemand update allowed rate per min is 4
	//	2017-04-15 22:47:46.773  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Discovery Client initialized at timestamp 1492276666772 with initial instances count: 1
	//	2017-04-15 22:47:46.872  INFO 8156 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Registering application lab4-restservice-noun with eureka with status UP
	//	2017-04-15 22:47:46.874  INFO 8156 --- [           main] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1492276666874, current=UP, previous=STARTING]
	//	2017-04-15 22:47:46.877  INFO 8156 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-NOUN/DESKTOP-02EQ34S:lab4-restservice-noun:0: registering service...
	//	2017-04-15 22:47:46.937  INFO 8156 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-NOUN/DESKTOP-02EQ34S:lab4-restservice-noun:0 - registration status: 204
	//	2017-04-15 22:47:46.954  INFO 8156 --- [           main] org.pjay.Lab4RestserviceNounApplication  : Started Lab4RestserviceNounApplication in 10.768 seconds (JVM running for 11.628)
	
	
	// Logs when shutdown requested
	//	2017-04-16 01:42:46.449  INFO 8156 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 01:47:46.451  INFO 8156 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 01:52:46.453  INFO 8156 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 01:57:46.455  INFO 8156 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 02:02:46.457  INFO 8156 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 02:02:54.692  INFO 8156 --- [(2)-192.168.1.3] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
	//	2017-04-16 02:02:54.693  INFO 8156 --- [(2)-192.168.1.3] ationConfigEmbeddedWebApplicationContext : Closing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@320de594: startup date [Sat Apr 15 22:47:38 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@54c5a2ff
	//	2017-04-16 02:02:54.699  INFO 8156 --- [(2)-192.168.1.3] c.n.e.EurekaDiscoveryClientConfiguration : Unregistering application lab4-restservice-noun with eureka with status DOWN
	//	2017-04-16 02:02:54.699  WARN 8156 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1492288374699, current=DOWN, previous=UP]
	//	2017-04-16 02:02:54.701  INFO 8156 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-NOUN/DESKTOP-02EQ34S:lab4-restservice-noun:0: registering service...
	//	2017-04-16 02:02:54.702  INFO 8156 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Shutting down DiscoveryClient ...
	//	2017-04-16 02:02:54.704  INFO 8156 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Unregistering ...
	//	2017-04-16 02:02:54.709  INFO 8156 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-NOUN/DESKTOP-02EQ34S:lab4-restservice-noun:0 - registration status: 204
	//	2017-04-16 02:02:54.715  INFO 8156 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-NOUN/DESKTOP-02EQ34S:lab4-restservice-noun:0 - deregister  status: 200
	//	2017-04-16 02:02:54.722  INFO 8156 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Completed shut down of DiscoveryClient
	//	2017-04-16 02:02:54.732  INFO 8156 --- [(2)-192.168.1.3] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 0
	//	2017-04-16 02:02:54.740  INFO 8156 --- [(2)-192.168.1.3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
	//	2017-04-16 02:02:54.742  INFO 8156 --- [(2)-192.168.1.3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans
	//	2017-04-16 02:02:54.802  INFO 8156 --- [(2)-192.168.1.3] o.apache.catalina.core.StandardService   : Stopping service Tomcat
	//	2017-04-16 02:02:54.807  INFO 8156 --- [ost-startStop-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Destroying Spring FrameworkServlet 'dispatcherServlet'

}
