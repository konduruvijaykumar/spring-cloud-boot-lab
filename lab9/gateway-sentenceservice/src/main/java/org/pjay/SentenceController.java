/**
 * 
 */
package org.pjay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class SentenceController {
	
	@RequestMapping("/")
	public String getSentence() {
		return "sentence";
	}

}
