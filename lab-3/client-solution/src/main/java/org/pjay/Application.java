package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// Logs:
	//	2017-04-06 20:02:31.934  INFO 1168 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8001
	//	2017-04-06 20:02:40.533  INFO 1168 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=lab-3-client, profiles=[default], label=master, version=681b5e4f1b60225649d0c5146620ca5f3c7692f4, state=null
	//	2017-04-06 20:02:40.534  INFO 1168 --- [  restartedMain] b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource [name='configService', propertySources=[MapPropertySource [name='configClient'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab-3-client.yml']]]
	//	2017-04-06 20:02:40.546  INFO 1168 --- [  restartedMain] org.pjay.Application                     : No active profile set, falling back to default profiles: default
	//	2017-04-06 20:02:40.677  INFO 1168 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1f9cec48: startup date [Thu Apr 06 20:02:40 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@2b112d8e
	//	2017-04-06 20:02:42.134  WARN 1168 --- [  restartedMain] o.s.c.a.ConfigurationClassPostProcessor  : Cannot enhance @Configuration bean definition 'refreshScope' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.
	//	2017-04-06 20:02:42.328  INFO 1168 --- [  restartedMain] o.s.cloud.context.scope.GenericScope     : BeanFactory id=b3435a9a-6fb9-31ce-ba9a-0118ae90ff54
	//	2017-04-06 20:02:42.346  INFO 1168 --- [  restartedMain] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration' of type [org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-04-06 20:02:42.366  INFO 1168 --- [  restartedMain] trationDelegate$BeanPostProcessorChecker : Bean 'validator' of type [org.springframework.validation.beanvalidation.LocalValidatorFactoryBean] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-04-06 20:02:42.401  INFO 1168 --- [  restartedMain] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$fc32a51c] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-04-06 20:02:43.149  INFO 1168 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8002 (http)
	//	2017-04-06 20:02:43.164  INFO 1168 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service Tomcat
	//	2017-04-06 20:02:43.165  INFO 1168 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.11
	//	2017-04-06 20:02:43.348  INFO 1168 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	//	2017-04-06 20:02:43.348  INFO 1168 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2671 ms
	//	2017-04-06 20:02:43.661  INFO 1168 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
	//	2017-04-06 20:02:43.669  INFO 1168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
	//	2017-04-06 20:02:43.670  INFO 1168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
	//	2017-04-06 20:02:43.670  INFO 1168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
	//	2017-04-06 20:02:43.670  INFO 1168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
	//	2017-04-06 20:02:44.108  INFO 1168 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1f9cec48: startup date [Thu Apr 06 20:02:40 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@2b112d8e
	//	2017-04-06 20:02:44.228  INFO 1168 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/lucky-word]}" onto private java.lang.String org.pjay.LuckyWordController.showLuckyWord()
	//	2017-04-06 20:02:44.238  INFO 1168 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
	//	2017-04-06 20:02:44.238  INFO 1168 --- [  restartedMain] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
	//	2017-04-06 20:02:44.292  INFO 1168 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-06 20:02:44.292  INFO 1168 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	//	2017-04-06 20:02:44.363  INFO 1168 --- [  restartedMain] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
	
	
	// VM args change for running with profile without changing bootstrap yml or properties file to add profiles
	// -Dspring.profiles.active=northamerica
	// Might be lab-3-client-northamerica.properties was first to read from repo, this file was taken for rendering data. We get "The lucky word is: World of Vjay" from controller
	
	// Logs: after changing VM args
	//	2017-04-07 05:55:13.575  INFO 15824 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8001
	//	2017-04-07 05:55:23.845  INFO 15824 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=lab-3-client, profiles=[northamerica], label=master, version=adf56e4a82042f3ce5a82370111fac167ec7f535, state=null
	//	2017-04-07 05:55:23.845  INFO 15824 --- [  restartedMain] b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource [name='configService', propertySources=[MapPropertySource [name='configClient'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab-3-client-northamerica.properties'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab-3-client-northamerica.yml'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lab-3-client.yml']]]
	//	2017-04-07 05:55:23.882  INFO 15824 --- [  restartedMain] org.pjay.Application                     : The following profiles are active: northamerica
}
