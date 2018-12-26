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


@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return deptService.list();
	}
	
	@RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();//获取注册表里面的微服务个数
		System.out.println("********************"+list);
		
		List<ServiceInstance> serviceList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for(ServiceInstance e: serviceList) {
			System.out.println(e.getServiceId()+"\t"+e.getHost()+"\t"+e.getPort()+"\t"+e.getUri());
		}
		return this.client;
	}
}
