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
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author vijayk
 *
 */
// IMP:
// http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
// We will use Hystrix for fallback and test few methods for now (By stopping respective servers). If required you can have fallback for all methods
@Service
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
	@HystrixCommand(fallbackMethod="getFallbackSubject")
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
	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Word getAdjective() {
		return adjectiveFeignClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Word getNoun() {
		return nounFeignClient.getWord();
	}
	
	public Word getFallbackSubject() {
		return new Word("Someone");
	}
	
	public Word getFallbackAdjective() {
		return new Word("");
	}
	
	public Word getFallbackNoun() {
		return new Word("something");
	}

}
