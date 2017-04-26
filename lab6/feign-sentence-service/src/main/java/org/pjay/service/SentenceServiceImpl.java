/**
 * 
 */
package org.pjay.service;

import org.springframework.stereotype.Service;

/**
 * @author vijayk
 *
 * Build a sentence by assembling randomly generated subjects, verbs, 
 * articles, adjectives, and nouns.  The individual parts of speech will 
 * be obtained by calling the various DAOs.
 * 
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	@Override
	public String buildSentence() {
		return null;
	}

}
