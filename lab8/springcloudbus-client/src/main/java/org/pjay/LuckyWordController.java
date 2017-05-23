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
// In solution we will use below annotation to automatically refresh data
// TODO: Add @ConfigurationProperties here.
public class LuckyWordController {

	// From Lab 3
	// @Value("${lucky-word}")
	// private String luckyWord;

	String luckyWord;
	String preamble;

	@RequestMapping("/lucky-word")
	private String showLuckyWord() {
		return preamble + ": " + luckyWord;
	}

	public String getLuckyWord() {
		return luckyWord;
	}

	public void setLuckyWord(String luckyWord) {
		this.luckyWord = luckyWord;
	}

	public String getPreamble() {
		return preamble;
	}

	public void setPreamble(String preamble) {
		this.preamble = preamble;
	}

}
