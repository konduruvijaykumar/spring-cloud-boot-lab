/**
 * 
 */
package org.pjay.service;

import org.pjay.dao.AdjectiveFeignClient;
import org.pjay.dao.ArticleFeignClient;
import org.pjay.dao.NounFeignClient;
import org.pjay.dao.SubjectFeignClient;
import org.pjay.dao.VerbFeignClient;
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

	private VerbFeignClient verbFeignClient;
	private SubjectFeignClient subjectFeignClient;
	private ArticleFeignClient articleFeignClient;
	private AdjectiveFeignClient adjectiveFeignClient;
	private NounFeignClient nounFeignClient;

	@Override
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s %s %s %s %s.", subjectFeignClient.getWord().getWord(),
				verbFeignClient.getWord().getWord(), articleFeignClient.getWord().getWord(),
				adjectiveFeignClient.getWord().getWord(), nounFeignClient.getWord().getWord());
		return sentence;
	}

	@Autowired
	public void setVerbFeignClient(VerbFeignClient verbFeignClient) {
		this.verbFeignClient = verbFeignClient;
	}

	@Autowired
	public void setSubjectFeignClient(SubjectFeignClient subjectFeignClient) {
		this.subjectFeignClient = subjectFeignClient;
	}

	@Autowired
	public void setArticleFeignClient(ArticleFeignClient articleFeignClient) {
		this.articleFeignClient = articleFeignClient;
	}

	@Autowired
	public void setAdjectiveFeignClient(AdjectiveFeignClient adjectiveFeignClient) {
		this.adjectiveFeignClient = adjectiveFeignClient;
	}

	@Autowired
	public void setNounFeignClient(NounFeignClient nounFeignClient) {
		this.nounFeignClient = nounFeignClient;
	}

}
