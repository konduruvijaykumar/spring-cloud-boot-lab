/**
 * 
 */
package org.pjay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class LuckyWordController {

	@Value("${lucky-word}")
	private String luckyWord;

	@RequestMapping("/lucky-word")
	private String showLuckyWord() {
		return "The lucky word is: " + luckyWord;
	}

}
