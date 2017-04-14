/**
 * 
 */
package org.pjay;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
@RestController
public class WordController {
	
	@Value("${words}") String words;
	
	@RequestMapping("/")
	public String getWord(){
		String[] wordArray = words.split(",");
		Random random = new Random();
		return wordArray[random.nextInt(wordArray.length)];
	}

}
