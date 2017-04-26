/**
 * 
 */
package org.pjay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author vijayk
 *
 */
@RestController
public class SentenceController {
	
	@Autowired LoadBalancerClient loadBalancer;
	
	/**
	 * Display a small list of Sentences to the caller:
	 */
	@RequestMapping("/sentence")
	public String getSentence() {
		// Taking a lot of time so reducing to 2 or 3 calls of sentence formation, found that noun server was not responding. Hence was taking lot of time
		// With only ribbon service call, application was not failing and not showing response for long time if one of the server is not working. Hence we need a circuit breaker to solve this problem
		// return "<h3>Some Sentences</h3><br/>" + buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>";
		return "<h3>Some Sentences</h3><br/>" + buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>"
				+ buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>";
	}

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		try{
			sentence =  
				String.format("%s %s %s %s %s.",
					getWord("WORD-RESTSERVICES-SUBJECT"),
					getWord("WORD-RESTSERVICES-VERB"),
					getWord("WORD-RESTSERVICES-ARTICLE"),
					getWord("WORD-RESTSERVICES-ADJECTIVE"),
					getWord("WORD-RESTSERVICES-NOUN") );			
		} catch ( Exception e ) {
			System.out.println(e);
		}
		System.out.println("sentence :: " + sentence);
		return sentence;
	}

	/**
	 * Obtain a random word for a given part of speech, where the part 
	 * of speech is indicated by the given service / client ID:
	 */
	public String getWord(String service) {
		ServiceInstance instance = loadBalancer.choose(service);
   		return (new RestTemplate()).getForObject(instance.getUri(),String.class);
	}

}
