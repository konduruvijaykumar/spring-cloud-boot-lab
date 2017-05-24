package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcloudbusClientSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudbusClientSolutionApplication.class, args);
	}
	
	// Error: during server startup
	// Note: https://stackoverflow.com/questions/32758000/java-lang-illegalstateexception-error-processing-condition-on-org-springframewo
	// This could be due to spring-integration-core-4.3.8.RELEASE.jar and spring-beans-4.3.7.RELEASE.jar -- version mismatch in spring and spring integration
	// IMP:: This works fine after matching versions properly with spring boot release 1.5.1 and in maven update check force update of snapshots/releases 
	
	//	2017-05-24 05:29:48.375  INFO 13708 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@21ff1d82: startup date [Wed May 24 05:29:48 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@570d17c0
	//	2017-05-24 05:29:50.930  INFO 13708 --- [  restartedMain] o.s.b.f.config.PropertiesFactoryBean     : Loading properties file from URL [jar:file:/C:/Users/krishna/.m2/repository/org/springframework/integration/spring-integration-core/4.3.8.RELEASE/spring-integration-core-4.3.8.RELEASE.jar!/META-INF/spring.integration.default.properties]
	//	2017-05-24 05:29:50.936  INFO 13708 --- [  restartedMain] o.s.i.config.IntegrationRegistrar        : No bean named 'integrationHeaderChannelRegistry' has been explicitly defined. Therefore, a default DefaultHeaderChannelRegistry will be created.
	//	2017-05-24 05:29:51.163 ERROR 13708 --- [  restartedMain] o.s.boot.SpringApplication               : Application startup failed
	//
	//	java.lang.IllegalStateException: Error processing condition on org.springframework.boot.devtools.autoconfigure.DevToolsDataSourceAutoConfiguration
	//		at org.springframework.boot.autoconfigure.condition.SpringBootCondition.matches(SpringBootCondition.java:64) ~[spring-boot-autoconfigure-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.context.annotation.ConditionEvaluator.shouldSkip(ConditionEvaluator.java:102) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$TrackedConditionEvaluator.shouldSkip(ConfigurationClassBeanDefinitionReader.java:436) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:127) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:116) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:320) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:228) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:270) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:93) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:686) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:524) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122) ~[spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:761) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:371) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1186) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1175) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.pjay.SpringcloudbusClientSolutionApplication.main(SpringcloudbusClientSolutionApplication.java:10) [classes/:na]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_131]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at java.lang.reflect.Method.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//	Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'integrationEvaluationContext': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.integration.config.IntegrationEvaluationContextFactoryBean]: Constructor threw exception; nested exception is java.lang.NoSuchMethodError: org.springframework.core.convert.support.DefaultConversionService.getSharedInstance()Lorg/springframework/core/convert/ConversionService;
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1155) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1099) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getSingletonFactoryBeanForTypeCheck(AbstractAutowireCapableBeanFactory.java:923) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getTypeForFactoryBean(AbstractAutowireCapableBeanFactory.java:804) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.isTypeMatch(AbstractBeanFactory.java:558) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.doGetBeanNamesForType(DefaultListableBeanFactory.java:432) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:395) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:389) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.boot.devtools.autoconfigure.DevToolsDataSourceAutoConfiguration$DevToolsDataSourceCondition.getMatchOutcome(DevToolsDataSourceAutoConfiguration.java:133) ~[spring-boot-devtools-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.autoconfigure.condition.SpringBootCondition.matches(SpringBootCondition.java:47) ~[spring-boot-autoconfigure-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		... 22 common frames omitted
	//	Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.integration.config.IntegrationEvaluationContextFactoryBean]: Constructor threw exception; nested exception is java.lang.NoSuchMethodError: org.springframework.core.convert.support.DefaultConversionService.getSharedInstance()Lorg/springframework/core/convert/ConversionService;
	//		at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:154) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:89) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1147) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		... 31 common frames omitted
	//	Caused by: java.lang.NoSuchMethodError: org.springframework.core.convert.support.DefaultConversionService.getSharedInstance()Lorg/springframework/core/convert/ConversionService;
	//		at org.springframework.expression.spel.support.StandardTypeConverter.<init>(StandardTypeConverter.java:46) ~[spring-expression-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.integration.config.IntegrationEvaluationContextFactoryBean.<init>(IntegrationEvaluationContextFactoryBean.java:83) ~[spring-integration-core-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	//		at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method) ~[na:1.8.0_131]
	//		at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source) ~[na:1.8.0_131]
	//		at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source) ~[na:1.8.0_131]
	//		at java.lang.reflect.Constructor.newInstance(Unknown Source) ~[na:1.8.0_131]
	//		at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:142) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		... 33 common frames omitted
	//
	//	2017-05-24 05:29:51.167  INFO 13708 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Closing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@21ff1d82: startup date [Wed May 24 05:29:48 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@570d17c0
	//	2017-05-24 05:29:51.171  WARN 13708 --- [  restartedMain] ationConfigEmbeddedWebApplicationContext : Exception thrown from LifecycleProcessor on context close
	//
	//	java.lang.IllegalStateException: LifecycleProcessor not initialized - call 'refresh' before invoking lifecycle methods via the context: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@21ff1d82: startup date [Wed May 24 05:29:48 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@570d17c0
	//		at org.springframework.context.support.AbstractApplicationContext.getLifecycleProcessor(AbstractApplicationContext.java:417) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.doClose(AbstractApplicationContext.java:1002) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.close(AbstractApplicationContext.java:961) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.boot.SpringApplication.handleRunFailure(SpringApplication.java:818) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:326) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1186) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1175) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.pjay.SpringcloudbusClientSolutionApplication.main(SpringcloudbusClientSolutionApplication.java:10) [classes/:na]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_131]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at java.lang.reflect.Method.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//
	//	2017-05-24 05:29:51.173 ERROR 13708 --- [  restartedMain] o.s.b.f.s.DefaultListableBeanFactory     : Destroy method on bean with name 'org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory' threw an exception
	//
	//	java.lang.IllegalStateException: ApplicationEventMulticaster not initialized - call 'refresh' before multicasting events via the context: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@21ff1d82: startup date [Wed May 24 05:29:48 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@570d17c0
	//		at org.springframework.context.support.AbstractApplicationContext.getApplicationEventMulticaster(AbstractApplicationContext.java:404) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.ApplicationListenerDetector.postProcessBeforeDestruction(ApplicationListenerDetector.java:97) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DisposableBeanAdapter.destroy(DisposableBeanAdapter.java:253) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.destroyBean(DefaultSingletonBeanRegistry.java:578) [spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.destroySingleton(DefaultSingletonBeanRegistry.java:554) [spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.destroySingleton(DefaultListableBeanFactory.java:961) [spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.destroySingletons(DefaultSingletonBeanRegistry.java:523) [spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.destroySingletons(DefaultListableBeanFactory.java:968) [spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.destroyBeans(AbstractApplicationContext.java:1033) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.doClose(AbstractApplicationContext.java:1009) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.close(AbstractApplicationContext.java:961) [spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.boot.SpringApplication.handleRunFailure(SpringApplication.java:818) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:326) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1186) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1175) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.pjay.SpringcloudbusClientSolutionApplication.main(SpringcloudbusClientSolutionApplication.java:10) [classes/:na]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_131]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at java.lang.reflect.Method.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//
	//	2017-05-24 05:29:51.176  WARN 13708 --- [  restartedMain] o.s.boot.SpringApplication               : Unable to close ApplicationContext
	//
	//	org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'integrationEvaluationContext': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.integration.config.IntegrationEvaluationContextFactoryBean]: Constructor threw exception; nested exception is java.lang.NoSuchMethodError: org.springframework.core.convert.support.DefaultConversionService.getSharedInstance()Lorg/springframework/core/convert/ConversionService;
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1155) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1086) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getSingletonFactoryBeanForTypeCheck(AbstractAutowireCapableBeanFactory.java:923) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getTypeForFactoryBean(AbstractAutowireCapableBeanFactory.java:804) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.isTypeMatch(AbstractBeanFactory.java:558) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.doGetBeanNamesForType(DefaultListableBeanFactory.java:432) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:395) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:515) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:508) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.context.support.AbstractApplicationContext.getBeansOfType(AbstractApplicationContext.java:1189) ~[spring-context-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.boot.SpringApplication.getExitCodeFromMappedException(SpringApplication.java:886) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.getExitCodeFromException(SpringApplication.java:872) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.handleExitCode(SpringApplication.java:858) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.handleRunFailure(SpringApplication.java:812) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:326) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1186) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.springframework.boot.SpringApplication.run(SpringApplication.java:1175) [spring-boot-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//		at org.pjay.SpringcloudbusClientSolutionApplication.main(SpringcloudbusClientSolutionApplication.java:10) [classes/:na]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_131]
	//		at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at java.lang.reflect.Method.invoke(Unknown Source) ~[na:1.8.0_131]
	//		at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-1.4.2.RELEASE.jar:1.4.2.RELEASE]
	//	Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.integration.config.IntegrationEvaluationContextFactoryBean]: Constructor threw exception; nested exception is java.lang.NoSuchMethodError: org.springframework.core.convert.support.DefaultConversionService.getSharedInstance()Lorg/springframework/core/convert/ConversionService;
	//		at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:154) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:89) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1147) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		... 22 common frames omitted
	//	Caused by: java.lang.NoSuchMethodError: org.springframework.core.convert.support.DefaultConversionService.getSharedInstance()Lorg/springframework/core/convert/ConversionService;
	//		at org.springframework.expression.spel.support.StandardTypeConverter.<init>(StandardTypeConverter.java:46) ~[spring-expression-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.integration.config.IntegrationEvaluationContextFactoryBean.<init>(IntegrationEvaluationContextFactoryBean.java:83) ~[spring-integration-core-4.3.8.RELEASE.jar:4.3.8.RELEASE]
	//		at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method) ~[na:1.8.0_131]
	//		at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source) ~[na:1.8.0_131]
	//		at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source) ~[na:1.8.0_131]
	//		at java.lang.reflect.Constructor.newInstance(Unknown Source) ~[na:1.8.0_131]
	//		at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:142) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		... 24 common frames omitted
	
	// Logs:: after POST bus/refresh method called on config server
	//	2017-05-24 06:14:28.869  INFO 14100 --- [bquYtYKMPM4AQ-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@1442d0ed: startup date [Wed May 24 06:14:28 IST 2017]; root of context hierarchy
	//	2017-05-24 06:14:29.611  INFO 14100 --- [bquYtYKMPM4AQ-1] trationDelegate$BeanPostProcessorChecker : Bean 'configurationPropertiesRebinderAutoConfiguration' of type [org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration$$EnhancerBySpringCGLIB$$20e9db19] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
	//	2017-05-24 06:14:30.394  INFO 14100 --- [bquYtYKMPM4AQ-1] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at: http://localhost:8001
	//	2017-05-24 06:14:35.401  INFO 14100 --- [bquYtYKMPM4AQ-1] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=lucky-word-client, profiles=[default], label=master, version=ea6320c1b78cc2f515572023cc05e37e7e43ecc2, state=null
	//	2017-05-24 06:14:35.402  INFO 14100 --- [bquYtYKMPM4AQ-1] b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource [name='configService', propertySources=[MapPropertySource [name='configClient'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/lucky-word-client.yml'], MapPropertySource [name='https://github.com/konduruvijaykumar/spring-cloud-boot-lab/configdata/application.yml']]]
	//	2017-05-24 06:14:35.405  INFO 14100 --- [bquYtYKMPM4AQ-1] o.s.boot.SpringApplication               : No active profile set, falling back to default profiles: default
	//	2017-05-24 06:14:35.438  INFO 14100 --- [bquYtYKMPM4AQ-1] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@54ec5629: startup date [Wed May 24 06:14:35 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@1442d0ed
	//	2017-05-24 06:14:36.577  INFO 14100 --- [bquYtYKMPM4AQ-1] o.s.boot.SpringApplication               : Started application in 9.437 seconds (JVM running for 1762.187)
	//	2017-05-24 06:14:36.580  INFO 14100 --- [bquYtYKMPM4AQ-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@54ec5629: startup date [Wed May 24 06:14:35 IST 2017]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@1442d0ed
	//	2017-05-24 06:14:43.158  INFO 14100 --- [bquYtYKMPM4AQ-1] o.s.cloud.bus.event.RefreshListener      : Received remote refresh request. Keys refreshed [config.client.version, wordConfig.luckyWord]
}
