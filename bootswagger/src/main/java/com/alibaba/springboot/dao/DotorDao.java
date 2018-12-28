package com.alibaba.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alibaba.springboot.entity.Doctor;

public interface DotorDao extends JpaRepository<Doctor, Integer>{

}
