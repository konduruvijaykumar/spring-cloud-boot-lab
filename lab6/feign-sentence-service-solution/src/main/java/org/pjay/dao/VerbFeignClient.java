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
@FeignClient("WORD-RESTSERVICES-VERB")
public interface VerbFeignClient {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Word getWord();

}
