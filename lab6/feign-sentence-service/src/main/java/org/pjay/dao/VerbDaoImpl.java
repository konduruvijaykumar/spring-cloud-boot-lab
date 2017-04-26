/**
 * 
 */
package org.pjay.dao;

import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component("verbRestService")
public class VerbDaoImpl extends WordDaoImpl {

	@Override
	public String getPartOfSpeech() {
		return VERB_ENDPOINT;
	}

}
