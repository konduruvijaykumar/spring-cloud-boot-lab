/**
 * 
 */
package org.pjay.service;

import java.util.concurrent.Executor;

import org.pjay.dao.AdjectiveFeignClient;
import org.pjay.dao.ArticleFeignClient;
import org.pjay.dao.NounFeignClient;
import org.pjay.dao.SubjectFeignClient;
import org.pjay.dao.VerbFeignClient;
import org.pjay.model.Word;
import org.pjay.model.Word.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rx.Observable;
import rx.schedulers.Schedulers;

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
	@Autowired
	Executor executor;	//	Source of threads

	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Observable<Word> getSubject() {
		//	This 'reactive' observable is backed by a regular Java Callable, which can run in a different thread:
		return Observable.fromCallable(
			() ->  new Word (subjectFeignClient.getWord().getWord(), Role.subject)
		).subscribeOn(Schedulers.from(executor));
		//return subjectFeignClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackVerb")
	public Observable<Word> getVerb() {
		return Observable.fromCallable(
				() ->  new Word (verbFeignClient.getWord().getWord(), Role.verb)
			).subscribeOn(Schedulers.from(executor));
		//return verbFeignClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackArticle")
	public Observable<Word> getArticle() {
		return Observable.fromCallable(
				() ->  new Word (articleFeignClient.getWord().getWord(), Role.article)
			).subscribeOn(Schedulers.from(executor));
		//return articleFeignClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Observable<Word> getAdjective() {
		return Observable.fromCallable(
				() ->  new Word (adjectiveFeignClient.getWord().getWord(), Role.adjective)
			).subscribeOn(Schedulers.from(executor));
		//return adjectiveFeignClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Observable<Word> getNoun() {
		return Observable.fromCallable(
				() ->  new Word (nounFeignClient.getWord().getWord(), Role.noun)
			).subscribeOn(Schedulers.from(executor));
		//return nounFeignClient.getWord();
	}
	
	public Word getFallbackSubject() {
		return new Word("Someone", Role.subject);
	}
	
	public Word getFallbackVerb() {
		return new Word("does", Role.verb);
	}
	
	public Word getFallbackArticle() {
		return new Word("", Role.article);
	}
	
	public Word getFallbackAdjective() {
		return new Word("", Role.adjective);
	}
	
	public Word getFallbackNoun() {
		return new Word("something", Role.noun);
	}

}
