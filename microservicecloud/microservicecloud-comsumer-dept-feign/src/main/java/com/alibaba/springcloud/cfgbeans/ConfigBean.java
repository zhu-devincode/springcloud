package com.alibaba.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {/**applicationContext.xml=@Configuration*/
	
	/**
	 * RestTemplate提供了多种便捷访问远程Http服务的方法
	 * 是一种简单便捷的访问restful服务模板类，是spring提供的用于
	 * 访问Rest服务的客户端模板工具类
	 */
	@Bean
	@LoadBalanced	//springcloud ribbon 是基于NetFlix Ribbon事项的 一套客户端 负载均衡工具
	public RestTemplate getRestTemplate() { 
		return new RestTemplate();
	}
	
	/*@Bean
	public IRule myIRule() {
		//return new RoundRobinRule();	//随机算法，替换轮询
		//return new RandomRule();
		return new RetryRule();
	}*/

}
