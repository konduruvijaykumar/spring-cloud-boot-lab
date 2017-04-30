/**
 * 
 */
package org.pjay.service;

import org.pjay.dao.AdjectiveFeignClient;
import org.pjay.dao.ArticleFeignClient;
import org.pjay.dao.NounFeignClient;
import org.pjay.dao.SubjectFeignClient;
import org.pjay.dao.VerbFeignClient;
import org.pjay.model.Word;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author vijayk
 *
 */
public class WordServiceImpl implements WordService {
	
	@Autowired
	private VerbFeignClient verbFeignClient;
	@Autowired
	private SubjectFeignClient subjectFeignClient;
	@Autowired
	private ArticleFeignClient articleFeignClient;
	@Autowired
	private AdjectiveFeignClient adjectiveFeignClient;
	@Autowired
	private NounFeignClient nounFeignClient;

	@Override
	public Word getSubject() {
		return subjectFeignClient.getWord();
	}

	@Override
	public Word getVerb() {
		return verbFeignClient.getWord();
	}

	@Override
	public Word getArticle() {
		return articleFeignClient.getWord();
	}

	@Override
	public Word getAdjective() {
		return adjectiveFeignClient.getWord();
	}

	@Override
	public Word getNoun() {
		return nounFeignClient.getWord();
	}

}
