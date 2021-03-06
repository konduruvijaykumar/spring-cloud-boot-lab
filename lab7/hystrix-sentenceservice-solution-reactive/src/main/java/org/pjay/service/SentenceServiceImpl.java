/**
 * 
 */
package org.pjay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.pjay.model.Sentence;
import org.pjay.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rx.Observable;

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
	
//	@Override
//	public String buildSentence() {
//		// removing default sentence given in case of failure. As we have fallback method in case of hystrix
//		//String sentence = "There was a problem assembling the sentence!";
//		return String.format("%s %s %s %s %s.", 
//				wordService.getSubject().getWord(),
//				wordService.getVerb().getWord(), 
//				wordService.getArticle().getWord(),
//				wordService.getAdjective().getWord(), 
//				wordService.getNoun().getWord());
//		//return sentence;
//	}
	
	// Assemble a sentence by gathering random words of each part of speech
	public String buildSentence() {
		Sentence sentence = new Sentence();
		
		//	Launch calls to all child services, using Observables 
		//	to handle the responses from each one:
		List<Observable<Word>> observables = createObservables();
		
		//	Use a CountDownLatch to detect when ALL of the calls are complete:
		CountDownLatch latch = new CountDownLatch(observables.size());
		
		Observable.merge(observables).subscribe(
					//	(Lambda) When each service call is complete, contribute its word
					//	to the sentence, and decrement the CountDownLatch
					(word) -> {
						sentence.add(word);
						latch.countDown();
					}
				);
		
		//	This code will wait until the LAST service call is complete:
		waitForAll(latch);

		//	Return the completed sentence:
		return sentence.toString();
	}
	
	/**
	 * Ultimately, we will need to wait for all 5 calls to 
	 * be completed before the sentence can be assembled.  
	 * This code waits for the last call to come back:
	 */
	private void waitForAll(CountDownLatch latch) {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This code launches calls to all 5 child services, 
	 * using Observables to monitor the completion:
	 */
	private List<Observable<Word>> createObservables(){
		List<Observable<Word>> observables = new ArrayList<>();
		observables.add(wordService.getSubject());
		observables.add(wordService.getVerb());
		observables.add(wordService.getArticle());
		observables.add(wordService.getAdjective());
		observables.add(wordService.getNoun());
		return observables;
	}

}
