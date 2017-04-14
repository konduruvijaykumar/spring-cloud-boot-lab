/**
 * 
 */
package org.pjay;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
		/*String.format("%s %s %s %s %s.", getWord("lab4-restservice-subject"), getWord("lab4-restservice-verb"),
				getWord("lab4-restservice-article"), getWord("lab4-restservice-adjective"),
				getWord("lab4-restservice-noun"));*/
		return String.format("%s %s %s %s %s.", getWord("LAB4-RESTSERVICE-SUBJECT"), getWord("LAB4-RESTSERVICE-VERB"),
				getWord("LAB4-RESTSERVICE-ARTICLE"), getWord("LAB4-RESTSERVICE-ADJECTIVE"),
				getWord("LAB4-RESTSERVICE-NOUN"));
	}

	public String getWord(String service) {
		// service is the key value of microservices registered with Eureka
		List<ServiceInstance> instanceInfos = discoveryClient.getInstances(service);
		if(null != instanceInfos && instanceInfos.size() > 0){
			URI uri = instanceInfos.get(0).getUri();
			if(null != uri){
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}

}
