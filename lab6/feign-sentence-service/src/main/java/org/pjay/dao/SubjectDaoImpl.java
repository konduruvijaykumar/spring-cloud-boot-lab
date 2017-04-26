/**
 * 
 */
package org.pjay.dao;

import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component("subjectRestService")
public class SubjectDaoImpl extends WordDaoImpl {

	@Override
	public String getPartOfSpeech() {
		return SUBJECT_ENDPOINT;
	}

}
