/**
 * 
 */
package org.pjay.dao;

import org.pjay.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

/**
 * @author vijayk
 *
 */
public abstract class WordDaoImpl implements WordDao {
	
	@Autowired
	LoadBalancerClient loadBalancer;
	
	public abstract String getPartOfSpeech();

	@Override
	public Word getWord() {
		ServiceInstance instance = loadBalancer.choose(getPartOfSpeech());
   		return (new RestTemplate()).getForObject(instance.getUri(),Word.class);
	}

}
