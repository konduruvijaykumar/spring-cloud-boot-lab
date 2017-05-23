/**
 * 
 */
package org.pjay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
@ConfigurationProperties(prefix = "wordConfig")
public class LuckyWordController {

	//@Value("${wordConfig.luckyWord}")
	String luckyWord;
	//@Value("${wordConfig.preamble}")
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
