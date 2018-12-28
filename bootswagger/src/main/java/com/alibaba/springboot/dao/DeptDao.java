package com.alibaba.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alibaba.springboot.entity.Dept;

public interface DeptDao extends JpaRepository<Dept, Integer>{

}
