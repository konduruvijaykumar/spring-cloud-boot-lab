/**
 * 
 */
package org.pjay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
// This was added to test calls from zuul server for different parameters in request and delay response
@RestController
public class HelloController {
	
	@Value("${spring.application.name}")
	private String serverType;
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello from " + serverType + " server";
	}
	
	@RequestMapping("/hello-user/{name}")
	public String sayHelloPathParam(@PathVariable String name) {
		return "Hello " + name + " from " + serverType + " server Path Param";
	}
	
	@RequestMapping("/hello-user")
	public String sayHelloQueryParam(@RequestParam("name") String name) {
		return "Hello " + name + " from " + serverType + " server via Query Param";
	}
	
	@RequestMapping("/timeout")
	public String delayResponse(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "This is a response from delay thread";
	}
	
}
