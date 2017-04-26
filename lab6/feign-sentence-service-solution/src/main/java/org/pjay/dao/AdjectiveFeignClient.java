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
@FeignClient("WORD-RESTSERVICES-ADJECTIVE")
public interface AdjectiveFeignClient {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Word getWord();
	
	// Not sure if we are using this in lab6. This might be done in next lab when working on hystrix
	static class HystrixClientFallback implements AdjectiveFeignClient{

		@Override
		public Word getWord() {
			return new Word();
		}
		
	}

}
