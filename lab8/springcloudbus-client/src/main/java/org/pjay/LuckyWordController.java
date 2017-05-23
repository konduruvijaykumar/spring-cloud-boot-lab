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
// In solution we will use below annotation to automatically refresh data
// TODO: Add @ConfigurationProperties here.
// The data in below fields will not be populated as the properties are "wordConfig.preamble", "wordConfig.luckyWord".
// This might work when you add @ConfigurationProperties with prefix property=wordConfig, Hence making changes as required to make it work
// Note: When you make changes to configuration files, it is not reflected in client application. As the data is read during startup of server and is cached.
// To refresh the configuration changes, we will see it next solution part 
public class LuckyWordController {

	// From Lab 3
	// @Value("${lucky-word}")
	// private String luckyWord;

	@Value("${wordConfig.luckyWord}")
	String luckyWord;
	@Value("${wordConfig.preamble}")
	String preamble;

	@RequestMapping("/lucky-word")
	private String showLuckyWord() {
		return preamble + ": " + luckyWord;
	}

//	public String getLuckyWord() {
//		return luckyWord;
//	}
//
//	public void setLuckyWord(String luckyWord) {
//		this.luckyWord = luckyWord;
//	}
//
//	public String getPreamble() {
//		return preamble;
//	}
//
//	public void setPreamble(String preamble) {
//		this.preamble = preamble;
//	}

}
