/**
 * 
 */
package org.pjay.service;

import org.pjay.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vijayk
 *
 * Build a sentence by assembling randomly generated subjects, verbs,
 * articles, adjectives, and nouns. The individual parts of speech will
 * be obtained by calling the various DAOs.
 * 
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	private WordDao verbRestService;
	private WordDao subjectRestService;
	private WordDao articleRestService;
	private WordDao adjectiveRestService;
	private WordDao nounRestService;

	@Override
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s %s %s %s %s.", subjectRestService.getWord().getWord(),
				verbRestService.getWord().getWord(), articleRestService.getWord().getWord(),
				adjectiveRestService.getWord().getWord(), nounRestService.getWord().getWord());
		return sentence;
	}

	// @Autowired on variables without setter should also work. Please verify

	@Autowired
	public void setVerbRestService(WordDao verbRestService) {
		this.verbRestService = verbRestService;
	}

	@Autowired
	public void setSubjectRestService(WordDao subjectRestService) {
		this.subjectRestService = subjectRestService;
	}

	@Autowired
	public void setArticleRestService(WordDao articleRestService) {
		this.articleRestService = articleRestService;
	}

	@Autowired
	public void setAdjectiveRestService(WordDao adjectiveRestService) {
		this.adjectiveRestService = adjectiveRestService;
	}

	@Autowired
	public void setNounRestService(WordDao nounRestService) {
		this.nounRestService = nounRestService;
	}

}
