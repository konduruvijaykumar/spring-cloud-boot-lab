package org.pjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerSolutionApplication.class, args);
	}
	
	// Error Observed:
	// TODO: Solution to be found, not provided even at spring cloud git repo
	// https://github.com/spring-cloud/spring-cloud-netflix/issues/1601
	// http://stackoverflow.com/questions/33358976/spring-cloud-eureka-error-when-running -- Not sure if this is a solution for this error
	
	//	2m2017-04-20 03:52:37.911 ERROR 11712 --- [hresholdUpdater] c.n.e.r.PeerAwareInstanceRegistryImpl    : Cannot update renewal threshold
	//
	//	org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration$RefreshableEurekaClientConfiguration': Initialization of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'environment' available
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:564) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:372) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1173) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1067) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory$2.getObject(AbstractBeanFactory.java:345) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.cloud.context.scope.GenericScope$BeanLifecycleWrapper.getBean(GenericScope.java:359) ~[spring-cloud-context-1.1.8.RELEASE.jar:1.1.8.RELEASE]
	//		at org.springframework.cloud.context.scope.GenericScope.get(GenericScope.java:176) ~[spring-cloud-context-1.1.8.RELEASE.jar:1.1.8.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:340) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.aop.target.SimpleBeanTargetSource.getTarget(SimpleBeanTargetSource.java:35) ~[spring-aop-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:192) ~[spring-aop-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at com.sun.proxy.$Proxy82.getApplications(Unknown Source) ~[na:na]
	//		at com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl.updateRenewalThreshold(PeerAwareInstanceRegistryImpl.java:523) [eureka-core-1.4.12.jar:1.4.12]
	//		at com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl.access$000(PeerAwareInstanceRegistryImpl.java:92) [eureka-core-1.4.12.jar:1.4.12]
	//		at com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl$2.run(PeerAwareInstanceRegistryImpl.java:194) [eureka-core-1.4.12.jar:1.4.12]
	//		at java.util.TimerThread.mainLoop(Timer.java:555) [na:1.8.0_121]
	//		at java.util.TimerThread.run(Timer.java:505) [na:1.8.0_121]
	//	Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'environment' available
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:372) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:372) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1173) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1067) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$ShortcutDependencyDescriptor.resolveShortcut(AutowiredAnnotationBeanPostProcessor.java:740) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1077) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.resolvedCachedArgument(AutowiredAnnotationBeanPostProcessor.java:548) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.access$200(AutowiredAnnotationBeanPostProcessor.java:117) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:577) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		... 23 common frames omitted
	//	Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'environment' available
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanDefinition(DefaultListableBeanFactory.java:687) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getMergedLocalBeanDefinition(AbstractBeanFactory.java:1207) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:284) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:275) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$ShortcutDependencyDescriptor.resolveShortcut(AutowiredAnnotationBeanPostProcessor.java:740) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1077) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.resolvedCachedArgument(AutowiredAnnotationBeanPostProcessor.java:548) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.access$200(AutowiredAnnotationBeanPostProcessor.java:117) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:577) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366) ~[spring-beans-4.3.7.RELEASE.jar:4.3.7.RELEASE]
	//		... 50 common frames omitted

}
