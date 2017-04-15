/**
 * 
 */
package org.pjay;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author vijayk
 *
 */
@RestController
public class SentenceController {

	@Autowired
	DiscoveryClient discoveryClient;

	@RequestMapping("/sentence")
	private String getSentence() {
		// Below lower case keys works fine, as this the app name we registered. Eureka server shows them as all Upper case keys. Hence upper or lower case both work fine 
		/*return String.format("%s %s %s %s %s.", getWord("lab4-restservice-subject"), getWord("lab4-restservice-verb"),
				getWord("lab4-restservice-article"), getWord("lab4-restservice-adjective"),
				getWord("lab4-restservice-noun"));*/
		return String.format("%s %s %s %s %s.", getWord("LAB4-RESTSERVICE-SUBJECT"), getWord("LAB4-RESTSERVICE-VERB"),
				getWord("LAB4-RESTSERVICE-ARTICLE"), getWord("LAB4-RESTSERVICE-ADJECTIVE"),
				getWord("LAB4-RESTSERVICE-NOUN"));
	}

	public String getWord(String service) {
		// service is the key value of microservices registered with Eureka
		System.out.println(discoveryClient.getServices().toString());
		// OutPut For Above::
		// [lab4-restservice-adjective, lab4-restservice-subject, lab4-restservice-verb, lab4-restservice-article, lab4-restservice-noun, lab4-restservice-sentence]
		// Only root service "/" registered. Hence the uri should be formed with the extra uri pattern manually here as below test end points does
		List<ServiceInstance> instanceInfos = discoveryClient.getInstances(service);
		if(null != instanceInfos && instanceInfos.size() > 0){
			URI uri = instanceInfos.get(0).getUri();
			if(null != uri){
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}
	
	// Below are Testing end points for verifying the end points registry keys with eureka server - This are called on noun rest service
	@RequestMapping("/hello")
	public String sayHello() {
		// Only root service "/" registered. Hence the uri should be formed with the extra uri pattern manually
		//List<ServiceInstance> instanceInfos = discoveryClient.getInstances("lab4-restservice-noun/hello");
		List<ServiceInstance> instanceInfos = discoveryClient.getInstances("lab4-restservice-noun");
		URI updatedUri;
		if(null != instanceInfos && instanceInfos.size() > 0){
			URI uri = instanceInfos.get(0).getUri();
			if(null != uri){
				try {
					updatedUri = new URI(uri.toString()+"/hello");
					return (new RestTemplate()).getForObject(updatedUri, String.class);
				} catch (RestClientException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@RequestMapping("/hello/{username}")
	public String sayHelloUser(@PathVariable String username) {
		// Only root service "/" registered. Hence the uri should be formed with the extra uri pattern manually
		//List<ServiceInstance> instanceInfos = discoveryClient.getInstances("lab4-restservice-noun/hello/"+username);
		List<ServiceInstance> instanceInfos = discoveryClient.getInstances("lab4-restservice-noun");
		//URI updatedUri;
		if(null != instanceInfos && instanceInfos.size() > 0){
			URI uri = instanceInfos.get(0).getUri();
			if(null != uri){
				try {
					// Not Working::
					//updatedUri = new URI(uri.toString()+"/hello/"+username);
					//updatedUri = new URI(String.format(uri.toString()+"/hello/"+username, "UTF8"));
					// http://stackoverflow.com/questions/749709/how-to-deal-with-the-urisyntaxexception
					// http://stackoverflow.com/questions/4992317/illegal-character-in-path-at-index-16
					// Error::
					/**
						java.net.URISyntaxException: Illegal character in path at index 40: http://DESKTOP-02EQ34S:62388/hello/Vijay Konduru
							at java.net.URI$Parser.fail(URI.java:2848)
							at java.net.URI$Parser.checkChars(URI.java:3021)
							at java.net.URI$Parser.parseHierarchical(URI.java:3105)
							at java.net.URI$Parser.parse(URI.java:3053)
							at java.net.URI.<init>(URI.java:588)
							at org.pjay.SentenceController.sayHelloUser(SentenceController.java:89)
					 */
					
					// Not Working::
					// http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
					//Map<String, String> params = new HashMap<String, String>();
					//params.put("username", username);
				    //params.put("username", String.format(username, "UTF8"));
				    // Error::
				    /**
						java.net.URISyntaxException: Illegal character in path at index 35: http://DESKTOP-02EQ34S:62388/hello/{username}
							at java.net.URI$Parser.fail(URI.java:2848)
							at java.net.URI$Parser.checkChars(URI.java:3021)
							at java.net.URI$Parser.parseHierarchical(URI.java:3105)
							at java.net.URI$Parser.parse(URI.java:3053)
							at java.net.URI.<init>(URI.java:588)
							at org.pjay.SentenceController.sayHelloUser(SentenceController.java:108)
				     */
					//updatedUri = new URI(uri.toString()+"/hello/"+String.format(username, "UTF8"));
					//updatedUri = new URI(uri.toString()+"/hello/"+URLEncoder.encode(username, "UTF8"));
					//updatedUri = new URI(uri.toString()+"/hello/{username}");
					// Results can be weird like below
					// Url shown on browser http://desktop-02eq34s:8020/hello/Vijay%20Konduru
					// OutPut:: "Hi there Vijay+Konduru" -- It should have been "Hi there Vijay Konduru"
					//return (new RestTemplate()).getForObject(updatedUri, String.class);
					//return (new RestTemplate()).getForObject(updatedUri.toString(), String.class, params);
					//return (new RestTemplate()).getForObject(updatedUri.toString(), String.class, username);
					
					
					// http://stackoverflow.com/questions/35998790/resttemplate-how-to-send-url-parameters-and-query-parameters-together
					// http://stackoverflow.com/questions/8297215/spring-resttemplate-get-with-parameters
					//updatedUri = new URI(uri.toString()+"/hello/{username}");
					// Error:: java.net.URISyntaxException: Illegal character in path at index 35: http://DESKTOP-02EQ34S:62388/hello/{username}					
					String strUrl = uri.toString()+"/hello/{username}";
					UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(strUrl);
					Map<String, String> params = new HashMap<String, String>();
					params.put("username", username);
					//System.out.println(builder.buildAndExpand(params).toUri()); //http://DESKTOP-02EQ34S:62388/hello/Vijay%20Konduru
					return (new RestTemplate()).getForObject(builder.buildAndExpand(params).toUri(), String.class);
				} catch (RestClientException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@RequestMapping("/test")
	public String testMethod() {
		// Only root service "/" registered. Hence the uri should be formed with the extra uri pattern manually
		//List<ServiceInstance> instanceInfos = discoveryClient.getInstances("lab4-restservice-noun/test");
		List<ServiceInstance> instanceInfos = discoveryClient.getInstances("lab4-restservice-noun");
		URI updatedUri;
		if(null != instanceInfos && instanceInfos.size() > 0){
			URI uri = instanceInfos.get(0).getUri();
			if(null != uri){
				try {
					updatedUri = new URI(uri.toString()+"/test");
					return (new RestTemplate()).getForObject(updatedUri, String.class);
				} catch (RestClientException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
