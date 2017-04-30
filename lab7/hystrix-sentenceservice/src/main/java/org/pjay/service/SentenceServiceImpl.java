/**
 * 
 */
package org.pjay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vijayk
 *
 * Build a sentence by assembling randomly generated subjects, verbs,
 * articles, adjectives, and nouns.
 * 
 */
@Service
public class SentenceServiceImpl implements SentenceService {
	
	@Autowired
	WordService wordService;
	
	@Override
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s %s %s %s %s.", wordService.getSubject().getWord(),
				wordService.getVerb().getWord(), wordService.getArticle().getWord(),
				wordService.getAdjective().getWord(), wordService.getNoun().getWord());
		return sentence;
	}

}
