package com.alibaba.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.springcloud.entites.Dept;

@RestController
public class DeptController_Consumer {
	
	//public static final String RESRFUL_URL_ADD = "http://localhost:8001";
	public static final String RESRFUL_URL_ADD = "http://MICROSERVICECLOUD-DEPT";
	
	/**
	 * 使用(url,requestMap,responseBean.class)三个参数分别代表
	 * Rest请求地址，请求参数，http响应转换被转换成的对象类型
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(RESRFUL_URL_ADD+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(RESRFUL_URL_ADD+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(RESRFUL_URL_ADD+"/dept/list", List.class);
	}

	@RequestMapping(value="/consumer/dept/discovery")
	public Object getDiscovery() {
		return restTemplate.getForObject(RESRFUL_URL_ADD+"/dept/discovery", Object.class);
	}
}
