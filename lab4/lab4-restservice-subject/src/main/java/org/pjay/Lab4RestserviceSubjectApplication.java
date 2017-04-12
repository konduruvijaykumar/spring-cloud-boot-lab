package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4RestserviceSubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4RestserviceSubjectApplication.class, args);
	}
	
	// Logs:
	//	2017-04-12 10:20:40.278  INFO 8240 --- [           main] o.p.Lab4RestserviceSubjectApplication    : No active profile set, falling back to default profiles: default
	//	2017-04-12 10:20:40.293  INFO 8240 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@3543df7d: startup date [Wed Apr 12 10:20:40 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@45099dd3
	//	2017-04-12 10:20:41.119  WARN 8240 --- [           main] o.s.c.a.ConfigurationClassPostProcessor  : Cannot enhance @Configuration bean definition 'refreshScope' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.
	//	2017-04-12 10:20:41.292  INFO 8240 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=2087e421-53bc-3ab9-bb37-6f19e2fdda38
	//	2017-04-12 10:20:41.312  INFO 8240 --- [           main] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-04-12 10:20:41.351  INFO 8240 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$44bef5c5] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-04-12 10:20:41.746  INFO 8240 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 0 (http)
	//	2017-04-12 10:20:41.762  INFO 8240 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
	//	2017-04-12 10:20:41.762  INFO 8240 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
	//	2017-04-12 10:20:41.978  INFO 8240 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	//	2017-04-12 10:20:41.978  INFO 8240 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1685 ms
	//	2017-04-12 10:20:42.261  INFO 8240 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
	//	2017-04-12 10:20:42.269  INFO 8240 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
	//	2017-04-12 10:20:42.270  INFO 8240 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
	//	2017-04-12 10:20:42.271  INFO 8240 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
	//	2017-04-12 10:20:42.273  INFO 8240 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
	//	2017-04-12 10:20:43.055  INFO 8240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@3543df7d: startup date [Wed Apr 12 10:20:40 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@45099dd3
	//	2017-04-12 10:20:43.180  INFO 8240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/]}" onto public java.lang.String org.pjay.WordController.getWord()
	//	2017-04-12 10:20:43.186  INFO 8240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
	//	2017-04-12 10:20:43.189  INFO 8240 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	//	2017-04-12 10:20:43.229  INFO 8240 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-12 10:20:43.230  INFO 8240 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-12 10:20:43.297  INFO 8240 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-12 10:20:43.743  WARN 8240 --- [           main] o.s.c.n.a.ArchaiusAutoConfiguration      : No spring.application.name found, defaulting to 'application'
	//	2017-04-12 10:20:43.749  WARN 8240 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
	//	2017-04-12 10:20:43.749  INFO 8240 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
	//	2017-04-12 10:20:43.761  WARN 8240 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
	//	2017-04-12 10:20:43.761  INFO 8240 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
	//	2017-04-12 10:20:43.865  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
	//	2017-04-12 10:20:43.883  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'refreshScope' has been autodetected for JMX exposure
	//	2017-04-12 10:20:43.886  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'environmentManager' has been autodetected for JMX exposure
	//	2017-04-12 10:20:43.893  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'configurationPropertiesRebinder' has been autodetected for JMX exposure
	//	2017-04-12 10:20:43.898  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'environmentManager': registering with JMX server as MBean [org.springframework.cloud.context.environment:name=environmentManager,type=EnvironmentManager]
	//	2017-04-12 10:20:43.923  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'refreshScope': registering with JMX server as MBean [org.springframework.cloud.context.scope.refresh:name=refreshScope,type=RefreshScope]
	//	2017-04-12 10:20:43.948  INFO 8240 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'configurationPropertiesRebinder': registering with JMX server as MBean [org.springframework.cloud.context.properties:name=configurationPropertiesRebinder,context=3543df7d,type=ConfigurationPropertiesRebinder]
	//	2017-04-12 10:20:44.161  INFO 8240 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
	//	2017-04-12 10:20:44.268  INFO 8240 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 63620 (http)
	//	2017-04-12 10:20:44.271  INFO 8240 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 63620
	//	2017-04-12 10:20:44.284  INFO 8240 --- [           main] o.s.c.n.eureka.InstanceInfoFactory       : Setting initial instance status as: STARTING
	//	2017-04-12 10:20:45.423  INFO 8240 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using JSON encoding codec LegacyJacksonJson
	//	2017-04-12 10:20:45.426  INFO 8240 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using JSON decoding codec LegacyJacksonJson
	//	2017-04-12 10:20:45.687  INFO 8240 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using XML encoding codec XStreamXml
	//	2017-04-12 10:20:45.697  INFO 8240 --- [           main] c.n.d.provider.DiscoveryJerseyProvider   : Using XML decoding codec XStreamXml
	//	2017-04-12 10:20:46.095  INFO 8240 --- [           main] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Disable delta property : false
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Single vip registry refresh property : null
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Force full registry fetch : false
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Application is null : false
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Registered Applications size is zero : true
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Application version is -1: true
	//	2017-04-12 10:20:46.615  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Getting all instance registry info from the eureka server
	//	2017-04-12 10:20:47.307  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : The response status is 200
	//	2017-04-12 10:20:47.308  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Starting heartbeat executor: renew interval is: 30
	//	2017-04-12 10:20:47.312  INFO 8240 --- [           main] c.n.discovery.InstanceInfoReplicator     : InstanceInfoReplicator onDemand update allowed rate per min is 4
	//	2017-04-12 10:20:47.317  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Discovery Client initialized at timestamp 1491972647316 with initial instances count: 0
	//	2017-04-12 10:20:47.467  INFO 8240 --- [           main] c.n.e.EurekaDiscoveryClientConfiguration : Registering application unknown with eureka with status UP
	//	2017-04-12 10:20:47.469  INFO 8240 --- [           main] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1491972647469, current=UP, previous=STARTING]
	//	2017-04-12 10:20:47.472  INFO 8240 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_UNKNOWN/DESKTOP-02EQ34S:0: registering service...
	//	2017-04-12 10:20:47.476  INFO 8240 --- [           main] o.p.Lab4RestserviceSubjectApplication    : Started Lab4RestserviceSubjectApplication in 9.486 seconds (JVM running for 10.331)
	//	2017-04-12 10:20:47.969  INFO 8240 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_UNKNOWN/DESKTOP-02EQ34S:0 - registration status: 204
	//	2017-04-12 10:21:17.311  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Disable delta property : false
	//	2017-04-12 10:21:17.311  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Single vip registry refresh property : null
	//	2017-04-12 10:21:17.311  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Force full registry fetch : false
	//	2017-04-12 10:21:17.314  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Application is null : false
	//	2017-04-12 10:21:17.314  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Registered Applications size is zero : true
	//	2017-04-12 10:21:17.315  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Application version is -1: false
	//	2017-04-12 10:21:17.315  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : Getting all instance registry info from the eureka server
	//	2017-04-12 10:21:17.433  INFO 8240 --- [freshExecutor-0] com.netflix.discovery.DiscoveryClient    : The response status is 200
	//	2017-04-12 10:21:36.440  INFO 8240 --- [o-auto-1-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//	2017-04-12 10:21:36.444  INFO 8240 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//	2017-04-12 10:21:36.488  INFO 8240 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 43 ms
	//	2017-04-12 10:25:46.628  INFO 8240 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration
	//	2017-04-12 10:30:46.644  INFO 8240 --- [trap-executor-0] c.n.d.s.r.aws.ConfigClusterResolver      : Resolving eureka endpoints via configuration

}
