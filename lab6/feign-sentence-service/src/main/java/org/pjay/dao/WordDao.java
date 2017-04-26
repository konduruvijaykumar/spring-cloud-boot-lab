/**
 * 
 */
package org.pjay.dao;

import org.pjay.model.Word;

/**
 * @author vijayk
 *
 */
public interface WordDao {
	
	static final String SUBJECT_ENDPOINT = "WORD-RESTSERVICES-SUBJECT";
	static final String VERB_ENDPOINT = "WORD-RESTSERVICES-VERB";
	static final String ARTICLE_ENDPOINT = "WORD-RESTSERVICES-ARTICLE";
	static final String ADJECTIVE_ENDPOINT = "WORD-RESTSERVICES-ADJECTIVE";
	static final String NOUN_ENDPOINT = "WORD-RESTSERVICES-NOUN";
	
	Word getWord();

}
