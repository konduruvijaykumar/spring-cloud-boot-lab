/**
 * 
 */
package org.pjay.controller;

import org.pjay.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class SentenceController {
	
	@Autowired
	SentenceService sentenceService;
	
	/**
	 * Display a small list of Sentences to the caller:
	 */
	@RequestMapping("/sentence")
	public String getSentence() {
		// Taking a lot of time so reducing to 2 or 3 calls of sentence formation, found that noun server was not responding. Hence was taking lot of time
		// With only ribbon service call, application was not failing and not showing response for long time if one of the server is not working. Hence we need a circuit breaker to solve this problem
		// return "<h3>Some Sentences</h3><br/>" + buildSentence() + "<br/><br/>" + buildSentence() + "<br/><br/>";
		long start = System.currentTimeMillis();
		String output = "<h3>Some Sentences</h3><br/>" + 
						sentenceService.buildSentence() + "<br/><br/>" + 
						sentenceService.buildSentence() + "<br/><br/>" + 
						sentenceService.buildSentence() + "<br/><br/>" + 
						sentenceService.buildSentence() + "<br/><br/>" + 
						sentenceService.buildSentence() + "<br/><br/>";
		long end = System.currentTimeMillis();
		return output + "Elapsed time (ms): " + (end - start);
	}

}
