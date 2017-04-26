/**
 * 
 */
package org.pjay.dao;

import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component("articleRestService")
public class ArticleDaoImpl extends WordDaoImpl {

	@Override
	public String getPartOfSpeech() {
		return ARTICLE_ENDPOINT;
	}

}
