/**
 * 
 */
package org.pjay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author vijayk
 *
 */
// Not a rest controller, we are using this as spring mvc app with sentence.html loaded from templates
//@RestController
@Controller
public class SentenceController {
	
	@RequestMapping("/")
	public String getSentence() {
		return "sentence";
	}

}
