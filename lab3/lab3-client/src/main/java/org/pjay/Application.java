package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// Logs:
	//	2017-04-11 23:53:14.297  INFO 8404 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8001
	//	2017-04-11 23:53:16.010  INFO 8404 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=lab3-client, profiles=[default], label=master, version=6612802f0d1b4336caea893ece3904b3c5b7330b, state=null
	//	2017-04-11 23:53:16.011  INFO 8404 --- [  restartedMain] b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource [name='configService', propertySources=[MapPropertySource [name='configClient'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab3-client.yml']]]
	//	2017-04-11 23:53:16.047  INFO 8404 --- [  restartedMain] org.pjay.Application                     : No active profile set, falling back to default profiles: default
	//	2017-04-11 23:53:16.105  INFO 8404 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@16197975: startup date [Tue Apr 11 23:53:16 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@403cb4a7
	//	2017-04-11 23:53:18.150  WARN 8404 --- [  restartedMain] o.s.c.a.ConfigurationClassPostProcessor  : Cannot enhance @Configuration bean definition 'refreshScope' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.
	//	2017-04-11 23:53:18.283  INFO 8404 --- [  restartedMain] o.s.cloud.context.scope.GenericScope     : BeanFactory id=e49bcc21-6878-3c83-9fd2-3650b6da37e4
	//	2017-04-11 23:53:18.301  INFO 8404 --- [  restartedMain] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$a17cbf05] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-04-11 23:53:18.865  INFO 8404 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8002 (http)
	//	2017-04-11 23:53:18.900  INFO 8404 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service Tomcat
	//	2017-04-11 23:53:18.910  INFO 8404 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
	//	2017-04-11 23:53:19.085  INFO 8404 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	//	2017-04-11 23:53:19.086  INFO 8404 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2982 ms
	//	2017-04-11 23:53:19.336  INFO 8404 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
	//	2017-04-11 23:53:19.342  INFO 8404 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
	//	2017-04-11 23:53:19.343  INFO 8404 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
	//	2017-04-11 23:53:19.343  INFO 8404 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
	//	2017-04-11 23:53:19.344  INFO 8404 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
	//	2017-04-11 23:53:19.752  INFO 8404 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@16197975: startup date [Tue Apr 11 23:53:16 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@403cb4a7
	//	2017-04-11 23:53:19.861  INFO 8404 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/lucky-word]}" onto private java.lang.String org.pjay.LuckyWordController.showLuckyWord()
	//	2017-04-11 23:53:19.875  INFO 8404 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
	//	2017-04-11 23:53:19.875  INFO 8404 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	//	2017-04-11 23:53:19.979  INFO 8404 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-11 23:53:19.980  INFO 8404 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-11 23:53:20.043  INFO 8404 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	
	
	// VM args change for running with profile without changing bootstrap yml or properties file to add profiles
	// -Dspring.profiles.active=northamerica
	// Might be lab3-client-northamerica.properties was first to read from repo, this file was taken for rendering data. We get "The lucky word is: World of Vjay" from controller
	
	// Logs: after changing VM args
	//	2017-04-12 00:01:20.716  INFO 6880 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8001
	//	2017-04-12 00:01:22.366  INFO 6880 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=lab3-client, profiles=[northamerica], label=master, version=6612802f0d1b4336caea893ece3904b3c5b7330b, state=null
	//	2017-04-12 00:01:22.373  INFO 6880 --- [  restartedMain] b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource [name='configService', propertySources=[MapPropertySource [name='configClient'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab3-client-northamerica.properties'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab3-client-northamerica.yml'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab3-client.yml']]]
	//	2017-04-12 00:01:22.389  INFO 6880 --- [  restartedMain] org.pjay.Application                     : The following profiles are active: northamerica
}
