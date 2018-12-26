package com.alibaba.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.springcloud.entites.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname("该ID"+id+"没有对应的信息");
				dept.setDb_source("no this in database");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
