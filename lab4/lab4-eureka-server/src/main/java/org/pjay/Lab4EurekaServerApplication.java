package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lab4EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaServerApplication.class, args);
	}
	
	// Logs:
	//	2017-04-12 08:45:46.807  INFO 16048 --- [  restartedMain] org.pjay.Lab4EurekaServerApplication     : No active profile set, falling back to default profiles: default
	//	2017-04-12 08:45:46.833  INFO 16048 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@544f12a2: startup date [Wed Apr 12 08:45:46 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@106ea124
	//	2017-04-12 08:45:49.346  WARN 16048 --- [  restartedMain] o.s.c.a.ConfigurationClassPostProcessor  : Cannot enhance @Configuration bean definition 'refreshScope' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.
	//	2017-04-12 08:45:49.790  INFO 16048 --- [  restartedMain] o.s.cloud.context.scope.GenericScope     : BeanFactory id=c8b2e73d-88aa-3353-a615-dc4a00ed9077
	//	2017-04-12 08:45:49.825  INFO 16048 --- [  restartedMain] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
	//	2017-04-12 08:45:49.858  INFO 16048 --- [  restartedMain] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$b5424a35] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-04-12 08:45:50.586  INFO 16048 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8010 (http)
	//	2017-04-12 08:45:50.601  INFO 16048 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service Tomcat
	//	2017-04-12 08:45:50.603  INFO 16048 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
	//	2017-04-12 08:45:50.903  INFO 16048 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	//	2017-04-12 08:45:50.904  INFO 16048 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 4071 ms
	//	2017-04-12 08:45:51.850  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'metricsFilter' to: [/*]
	//	2017-04-12 08:45:51.850  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
	//	2017-04-12 08:45:51.851  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
	//	2017-04-12 08:45:51.851  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
	//	2017-04-12 08:45:51.852  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
	//	2017-04-12 08:45:51.853  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'webRequestTraceFilter' to: [/*]
	//	2017-04-12 08:45:51.854  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'servletContainer' to urls: [/eureka/*]
	//	2017-04-12 08:45:51.855  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'applicationContextIdFilter' to: [/*]
	//	2017-04-12 08:45:51.857  INFO 16048 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
	//	2017-04-12 08:45:52.234  INFO 16048 --- [ost-startStop-1] c.s.j.s.i.a.WebApplicationImpl           : Initiating Jersey application, version 'Jersey: 1.19.1 03/11/2016 02:08 PM'
	//	2017-04-12 08:45:52.342  INFO 16048 --- [ost-startStop-1] c.n.d.provider.DiscoveryJerseyProvider   : Using JSON encoding codec LegacyJacksonJson
	//	2017-04-12 08:45:52.344  INFO 16048 --- [ost-startStop-1] c.n.d.provider.DiscoveryJerseyProvider   : Using JSON decoding codec LegacyJacksonJson
	//	2017-04-12 08:45:52.533  INFO 16048 --- [ost-startStop-1] c.n.d.provider.DiscoveryJerseyProvider   : Using XML encoding codec XStreamXml
	//	2017-04-12 08:45:52.534  INFO 16048 --- [ost-startStop-1] c.n.d.provider.DiscoveryJerseyProvider   : Using XML decoding codec XStreamXml
	//	2017-04-12 08:45:53.502  INFO 16048 --- [  restartedMain] o.s.c.n.eureka.InstanceInfoFactory       : Setting initial instance status as: STARTING
	//	2017-04-12 08:45:53.570  INFO 16048 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Client configured to neither register nor query for data.
	//	2017-04-12 08:45:53.587  INFO 16048 --- [  restartedMain] com.netflix.discovery.DiscoveryClient    : Discovery Client initialized at timestamp 1491966953587 with initial instances count: 0
	//	2017-04-12 08:45:53.879  INFO 16048 --- [  restartedMain] c.n.eureka.DefaultEurekaServerContext    : Initializing ...
	//	2017-04-12 08:45:53.882  WARN 16048 --- [  restartedMain] c.n.eureka.cluster.PeerEurekaNodes       : The replica size seems to be empty. Check the route 53 DNS Registry
	//	2017-04-12 08:45:53.905  INFO 16048 --- [  restartedMain] c.n.e.registry.AbstractInstanceRegistry  : Finished initializing remote region registries. All known remote regions: []
	//	2017-04-12 08:45:53.906  INFO 16048 --- [  restartedMain] c.n.eureka.DefaultEurekaServerContext    : Initialized
	//	2017-04-12 08:45:54.484  INFO 16048 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@544f12a2: startup date [Wed Apr 12 08:45:46 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@106ea124
	//	2017-04-12 08:45:54.690  INFO 16048 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/],methods=[GET]}" onto public java.lang.String org.springframework.cloud.netflix.eureka.server.EurekaController.status(javax.servlet.http.HttpServletRequest,java.util.Map<java.lang.String, java.lang.Object>)
	//	2017-04-12 08:45:54.693  INFO 16048 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/lastn],methods=[GET]}" onto public java.lang.String org.springframework.cloud.netflix.eureka.server.EurekaController.lastn(javax.servlet.http.HttpServletRequest,java.util.Map<java.lang.String, java.lang.Object>)
	//	2017-04-12 08:45:54.701  INFO 16048 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
	//	2017-04-12 08:45:54.705  INFO 16048 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	//	2017-04-12 08:45:54.774  INFO 16048 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-12 08:45:54.775  INFO 16048 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-12 08:45:54.861  INFO 16048 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-12 08:45:55.737  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.738  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(java.security.Principal)
	//	2017-04-12 08:45:55.739  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/refresh || /refresh.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.endpoint.GenericPostableMvcEndpoint.invoke()
	//	2017-04-12 08:45:55.741  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.743  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
	//	2017-04-12 08:45:55.743  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.745  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.749  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
	//	2017-04-12 08:45:55.750  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.750  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.context.environment.EnvironmentManagerMvcEndpoint.value(java.util.Map<java.lang.String, java.lang.String>)
	//	2017-04-12 08:45:55.751  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/reset],methods=[POST]}" onto public java.util.Map<java.lang.String, java.lang.Object> org.springframework.cloud.context.environment.EnvironmentManagerMvcEndpoint.reset()
	//	2017-04-12 08:45:55.752  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/archaius || /archaius.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.757  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.760  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.761  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/restart || /restart.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.context.restart.RestartMvcEndpoint.invoke()
	//	2017-04-12 08:45:55.762  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.763  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.766  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/resume || /resume.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.endpoint.GenericPostableMvcEndpoint.invoke()
	//	2017-04-12 08:45:55.768  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/heapdump || /heapdump.json],methods=[GET],produces=[application/octet-stream]}" onto public void org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint.invoke(boolean,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException
	//	2017-04-12 08:45:55.769  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/features || /features.json],methods=[GET],produces=[application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
	//	2017-04-12 08:45:55.770  INFO 16048 --- [  restartedMain] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/pause || /pause.json],methods=[POST]}" onto public java.lang.Object org.springframework.cloud.endpoint.GenericPostableMvcEndpoint.invoke()
	//	2017-04-12 08:45:56.016  INFO 16048 --- [  restartedMain] o.s.ui.freemarker.SpringTemplateLoader   : SpringTemplateLoader for FreeMarker: using resource loader [org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@544f12a2: startup date [Wed Apr 12 08:45:46 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@106ea124] and template loader path [classpath:/templates/]
	//	2017-04-12 08:45:56.018  INFO 16048 --- [  restartedMain] o.s.w.s.v.f.FreeMarkerConfigurer         : ClassTemplateLoader for Spring macros added to FreeMarker configuration
	//	2017-04-12 08:45:56.132  INFO 16048 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
	//	2017-04-12 08:45:56.240  WARN 16048 --- [  restartedMain] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
	//	2017-04-12 08:45:56.240  INFO 16048 --- [  restartedMain] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
	//	2017-04-12 08:45:56.252  WARN 16048 --- [  restartedMain] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
	//	2017-04-12 08:45:56.252  INFO 16048 --- [  restartedMain] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
	//	2017-04-12 08:45:56.378  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
	//	2017-04-12 08:45:56.389  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'refreshScope' has been autodetected for JMX exposure
	//	2017-04-12 08:45:56.391  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'environmentManager' has been autodetected for JMX exposure
	//	2017-04-12 08:45:56.394  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'configurationPropertiesRebinder' has been autodetected for JMX exposure
	//	2017-04-12 08:45:56.395  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'refreshEndpoint' has been autodetected for JMX exposure
	//	2017-04-12 08:45:56.397  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'restartEndpoint' has been autodetected for JMX exposure
	//	2017-04-12 08:45:56.407  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'environmentManager': registering with JMX server as MBean [org.springframework.cloud.context.environment:name=environmentManager,type=EnvironmentManager]
	//	2017-04-12 08:45:56.423  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'restartEndpoint': registering with JMX server as MBean [org.springframework.cloud.context.restart:name=restartEndpoint,type=RestartEndpoint]
	//	2017-04-12 08:45:56.440  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'refreshScope': registering with JMX server as MBean [org.springframework.cloud.context.scope.refresh:name=refreshScope,type=RefreshScope]
	//	2017-04-12 08:45:56.467  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'configurationPropertiesRebinder': registering with JMX server as MBean [org.springframework.cloud.context.properties:name=configurationPropertiesRebinder,context=544f12a2,type=ConfigurationPropertiesRebinder]
	//	2017-04-12 08:45:56.488  INFO 16048 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'refreshEndpoint': registering with JMX server as MBean [org.springframework.cloud.endpoint:name=refreshEndpoint,type=RefreshEndpoint]
	//	2017-04-12 08:45:56.900  INFO 16048 --- [  restartedMain] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 0
	//	2017-04-12 08:45:56.902  INFO 16048 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Registering application lab4-eureka-server with eureka with status UP
	//	2017-04-12 08:45:56.912  INFO 16048 --- [      Thread-17] o.s.c.n.e.server.EurekaServerBootstrap   : Setting the eureka configuration..
	//	2017-04-12 08:45:56.914  INFO 16048 --- [      Thread-17] o.s.c.n.e.server.EurekaServerBootstrap   : Eureka data center value eureka.datacenter is not set, defaulting to default
	//	2017-04-12 08:45:56.915  INFO 16048 --- [      Thread-17] o.s.c.n.e.server.EurekaServerBootstrap   : Eureka environment value eureka.environment is not set, defaulting to test
	//	2017-04-12 08:45:56.936  INFO 16048 --- [      Thread-17] o.s.c.n.e.server.EurekaServerBootstrap   : isAws returned false
	//	2017-04-12 08:45:56.937  INFO 16048 --- [      Thread-17] o.s.c.n.e.server.EurekaServerBootstrap   : Initialized server context
	//	2017-04-12 08:45:56.938  INFO 16048 --- [      Thread-17] c.n.e.r.PeerAwareInstanceRegistryImpl    : Got 1 instances from neighboring DS node
	//	2017-04-12 08:45:56.939  INFO 16048 --- [      Thread-17] c.n.e.r.PeerAwareInstanceRegistryImpl    : Renew threshold is: 1
	//	2017-04-12 08:45:56.939  INFO 16048 --- [      Thread-17] c.n.e.r.PeerAwareInstanceRegistryImpl    : Changing status to UP
	//	2017-04-12 08:45:56.965  INFO 16048 --- [      Thread-17] e.s.EurekaServerInitializerConfiguration : Started Eureka Server
	//	2017-04-12 08:45:57.306  INFO 16048 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8010 (http)
	//	2017-04-12 08:45:57.308  INFO 16048 --- [  restartedMain] c.n.e.EurekaDiscoveryClientConfiguration : Updating port to 8010
	//	2017-04-12 08:45:57.320  INFO 16048 --- [  restartedMain] org.pjay.Lab4EurekaServerApplication     : Started Lab4EurekaServerApplication in 15.248 seconds (JVM running for 25.812)
	//	2017-04-12 08:46:16.426  INFO 16048 --- [nio-8010-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
	//	2017-04-12 08:46:16.426  INFO 16048 --- [nio-8010-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
	//	2017-04-12 08:46:16.467  INFO 16048 --- [nio-8010-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 41 ms
	//	2017-04-12 08:46:56.942  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:47:56.942  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:48:56.943  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 1ms
	//	2017-04-12 08:49:56.943  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:50:56.944  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:51:56.944  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:52:56.944  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:53:56.945  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:54:56.946  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 1ms
	//	2017-04-12 08:55:53.884  WARN 16048 --- [eerNodesUpdater] c.n.eureka.cluster.PeerEurekaNodes       : The replica size seems to be empty. Check the route 53 DNS Registry
	//	2017-04-12 08:55:56.946  INFO 16048 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 08:58:35.801  INFO 16048 --- [22)-192.168.1.3] inMXBeanRegistrar$SpringApplicationAdmin : Application shutdown requested.
	//	2017-04-12 08:58:35.801  INFO 16048 --- [22)-192.168.1.3] ationConfigEmbeddedWebApplicationContext : Closing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@544f12a2: startup date [Wed Apr 12 08:45:46 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@106ea124
	//	2017-04-12 08:58:35.804  INFO 16048 --- [22)-192.168.1.3] c.n.e.EurekaDiscoveryClientConfiguration : Unregistering application lab4-eureka-server with eureka with status DOWN
	//	2017-04-12 08:58:35.804  INFO 16048 --- [22)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Shutting down DiscoveryClient ...
	//	2017-04-12 08:58:35.805  INFO 16048 --- [22)-192.168.1.3] com.netflix.discovery.DiscoveryClient    : Completed shut down of DiscoveryClient
	//	2017-04-12 08:58:35.811  INFO 16048 --- [22)-192.168.1.3] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 0
	//	2017-04-12 08:58:35.820  INFO 16048 --- [22)-192.168.1.3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
	//	2017-04-12 08:58:35.820  INFO 16048 --- [22)-192.168.1.3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans
	//	2017-04-12 08:58:35.822  INFO 16048 --- [22)-192.168.1.3] c.n.eureka.DefaultEurekaServerContext    : Shutting down ...
	//	2017-04-12 08:58:35.824  INFO 16048 --- [22)-192.168.1.3] c.n.eureka.DefaultEurekaServerContext    : Shut down
	//	2017-04-12 08:58:36.019  INFO 16048 --- [22)-192.168.1.3] o.apache.catalina.core.StandardService   : Stopping service Tomcat
	//	2017-04-12 08:58:36.023  INFO 16048 --- [ost-startStop-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Destroying Spring FrameworkServlet 'dispatcherServlet'
	
	
	// Logs after registering one service:
	//	2017-04-12 10:20:46.955  INFO 10108 --- [nio-8010-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 72 ms
	//	2017-04-12 10:20:47.884  INFO 10108 --- [nio-8010-exec-2] c.n.e.registry.AbstractInstanceRegistry  : Registered instance UNKNOWN/DESKTOP-02EQ34S:0 with status UP (replication=false)
	//	2017-04-12 10:21:02.941  INFO 10108 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 10:22:02.945  INFO 10108 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 4ms
	//	2017-04-12 10:23:02.957  INFO 10108 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 12ms
	//	2017-04-12 10:23:59.517  WARN 10108 --- [eerNodesUpdater] c.n.eureka.cluster.PeerEurekaNodes       : The replica size seems to be empty. Check the route 53 DNS Registry
	//	2017-04-12 10:24:02.958  INFO 10108 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
	//	2017-04-12 10:25:02.966  INFO 10108 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 8ms
	//	2017-04-12 10:26:02.980  INFO 10108 --- [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 14ms

}
