package com.alibaba.springcloud.service;

import java.util.List;

import com.alibaba.springcloud.entites.Dept;

public interface DeptService {
	
	boolean add(Dept dept);
	
	Dept get(Long id);
	
	List<Dept> list();

}
