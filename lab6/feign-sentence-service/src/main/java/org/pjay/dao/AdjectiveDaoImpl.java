/**
 * 
 */
package org.pjay.dao;

import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component("adjectiveRestService")
public class AdjectiveDaoImpl extends WordDaoImpl {

	@Override
	public String getPartOfSpeech() {
		return ADJECTIVE_ENDPOINT;
	}

}
