/**
 * 
 */
package org.pjay.dao;

import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component("nounRestService")
public class NounDaoImpl extends WordDaoImpl {

	@Override
	public String getPartOfSpeech() {
		return NOUN_ENDPOINT;
	}

}
