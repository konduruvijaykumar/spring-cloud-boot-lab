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
// https://help.github.com/articles/dealing-with-non-fast-forward-errors/
// http://stackoverflow.com/questions/4684352/what-does-git-push-non-fast-forward-updates-were-rejected-mean
// http://marklodato.github.io/visual-git-guide/index-en.html

@RestController
public class LuckyWordController {

	@Value("${lucky-word}")
	private String luckyWord;

	@RequestMapping("/lucky-word")
	private String showLuckyWord() {
		return "The lucky word is: " + luckyWord;
	}

}
