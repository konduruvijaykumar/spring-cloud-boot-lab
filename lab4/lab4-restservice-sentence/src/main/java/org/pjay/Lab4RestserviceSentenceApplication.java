package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4RestserviceSentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4RestserviceSentenceApplication.class, args);
	}
	
	// Logs when shutdown requested
	//	2017-04-16 01:52:53.846  INFO 8376 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 01:57:53.848  INFO 8376 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-16 02:00:22.268  INFO 8376 --- [(2)-192.168.1.3] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
	//	2017-04-16 02:00:22.269  INFO 8376 --- [(2)-192.168.1.3] ationConfigEmbeddedWebApplicationContext : Closing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@3fa2213: startup date [Sat Apr 15 22:52:46 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@54c5a2ff
	//	2017-04-16 02:00:22.275  INFO 8376 --- [(2)-192.168.1.3] c.n.e.EurekaDiscoveryClientConfiguration : Unregistering application lab4-restservice-sentence with eureka with status DOWN
	//	2017-04-16 02:00:22.276  WARN 8376 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1492288222276, current=DOWN, previous=UP]
	//	2017-04-16 02:00:22.277  INFO 8376 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-SENTENCE/DESKTOP-02EQ34S:lab4-restservice-sentence:8020: registering service...
	//	2017-04-16 02:00:22.280  INFO 8376 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Shutting down DiscoveryClient ...
	//	2017-04-16 02:00:22.283  INFO 8376 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Unregistering ...
	//	2017-04-16 02:00:22.293  INFO 8376 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-SENTENCE/DESKTOP-02EQ34S:lab4-restservice-sentence:8020 - deregister  status: 200
	//	2017-04-16 02:00:22.301  INFO 8376 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_LAB4-RESTSERVICE-SENTENCE/DESKTOP-02EQ34S:lab4-restservice-sentence:8020 - registration status: 204
	//	2017-04-16 02:00:22.305  INFO 8376 --- [(2)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Completed shut down of DiscoveryClient
	//	2017-04-16 02:00:22.334  INFO 8376 --- [(2)-192.168.1.3] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 0
	//	2017-04-16 02:00:22.358  INFO 8376 --- [(2)-192.168.1.3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
	//	2017-04-16 02:00:22.359  INFO 8376 --- [(2)-192.168.1.3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans
	//	2017-04-16 02:00:22.397  INFO 8376 --- [(2)-192.168.1.3] o.apache.catalina.core.StandardService   : Stopping service Tomcat
	//	2017-04-16 02:00:22.419  INFO 8376 --- [ost-startStop-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Destroying Spring FrameworkServlet 'dispatcherServlet'

}
