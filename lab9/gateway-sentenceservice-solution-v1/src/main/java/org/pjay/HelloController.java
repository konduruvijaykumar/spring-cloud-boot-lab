/**
 * 
 */
package org.pjay;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello from gateway server";
	}
	
	@RequestMapping("/hello-user/{name}")
	public String sayHelloPathParam(@PathVariable String name) {
		return "Hello " + name + " from gateway server Path Param";
	}
	
	@RequestMapping("/hello-user")
	public String sayHelloQueryParam(@RequestParam("name") String name) {
		return "Hello " + name + " from gateway server via Query Param";
	}
	
}
