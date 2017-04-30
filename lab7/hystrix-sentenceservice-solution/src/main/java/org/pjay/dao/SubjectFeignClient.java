/**
 * 
 */
package org.pjay.dao;

import org.pjay.model.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vijayk
 *
 */
@FeignClient("SUBJECT")
public interface SubjectFeignClient {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	Word getWord();

}
