package com.alibaba.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.springcloud.entites.Dept;

/**
 * @Feign接口加注解
 * @author qiang
 *
 */
//@FeignClient(value="MICROSERVICECLOUD-DEPT")//解耦，整体进行熔断处理，面向切面编程，可以不用单独为每一个方法进行熔断处理
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	boolean add(Dept dept);
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	Dept get(@PathVariable("id")Long id);
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	List<Dept> list();

}
