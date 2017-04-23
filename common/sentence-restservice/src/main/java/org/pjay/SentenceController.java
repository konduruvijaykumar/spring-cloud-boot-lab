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
		// In commons project we made changes to names of word server applications to word-restservices-***. Hence we modify below names for discovery
		// Below lower case keys works fine, as this the app name we registered. Eureka server shows them as all Upper case keys. Hence upper or lower case both work fine 
		/*return String.format("%s %s %s %s %s.", getWord("word-restservices-subject"), getWord("word-restservices-verb"),
				getWord("word-restservices-article"), getWord("word-restservices-adjective"),
				getWord("word-restservices-noun"));*/
		return String.format("%s %s %s %s %s.", getWord("WORD-RESTSERVICES-SUBJECT"), getWord("WORD-RESTSERVICES-VERB"),
				getWord("WORD-RESTSERVICES-ARTICLE"), getWord("WORD-RESTSERVICES-ADJECTIVE"),
				getWord("WORD-RESTSERVICES-NOUN"));
	}

	public String getWord(String service) {
		// service is the key value of microservices registered with Eureka
		System.out.println(discoveryClient.getServices().toString());
		// OutPut For Above::
		// [word-restservices-adjective, word-restservices-subject, word-restservices-verb, word-restservices-article, word-restservices-noun, word-restservices-sentence]
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

}
