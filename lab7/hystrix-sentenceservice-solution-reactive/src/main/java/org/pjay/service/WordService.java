/**
 * 
 */
package org.pjay.service;

import org.pjay.model.Word;

import rx.Observable;

/**
 * @author vijayk
 *
 */
public interface WordService {
	
	Observable<Word> getSubject();
	Observable<Word> getVerb();
	Observable<Word> getArticle();
	Observable<Word> getAdjective();
	Observable<Word> getNoun();

}
