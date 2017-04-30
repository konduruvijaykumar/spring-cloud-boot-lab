/**
 * 
 */
package org.pjay.service;

import org.pjay.model.Word;

/**
 * @author vijayk
 *
 */
public interface WordService {
	
	Word getSubject();
	Word getVerb();
	Word getArticle();
	Word getAdjective();
	Word getNoun();

}
