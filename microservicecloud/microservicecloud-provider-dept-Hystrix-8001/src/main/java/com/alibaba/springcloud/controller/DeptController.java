package com.alibaba.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.springcloud.entites.Dept;
import com.alibaba.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	/**如果抛异常则调用processHytrix_Get方法进行处理*/
	@HystrixCommand(fallbackMethod = "processHytrix_Get")
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if(dept==null) {
			throw new RuntimeException();
		}
		return dept;
	}
	public Dept processHytrix_Get(@PathVariable("id")Long id) {
		Dept dept = new Dept();
		dept.setDeptno(id);
		dept.setDname("该ID"+id+"没有对应的信息");
		dept.setDb_source("no this in database");
		return dept;
	}

	
}
