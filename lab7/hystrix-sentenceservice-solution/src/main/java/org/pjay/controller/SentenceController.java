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
