package com.alibaba.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.springboot.dao.DotorDao;
import com.alibaba.springboot.entity.Doctor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "测试swagger2接口模拟")
public class BootDoctor {
	
	@Autowired
	private DotorDao dotorDao;
	
	/**
	 * 后台使用对象接受参数时，需要添加@RequestBody注解，swagger默认采用json传参
	 * @param doctor
	 * @return
	 */
	@PostMapping("addDoctor")
	@ApiOperation(value = "添加用户信息", notes = "")
	public String addDoctor(@RequestBody Doctor doctor) {
		if(null == doctor || null == doctor.getId()) {
			//throw new HttpStatus401Exception("添加医生用户信息失败，未知原因，请联系管理员！");
		}
		try {					
			dotorDao.save(doctor);
			System.out.println("成功添加！");
		} catch (Exception e) {
			//throw new HttpStatus401Exception("添加失败");
		}
		return doctor.getName();
	}
	
	@GetMapping(value = "/update/{id}")
	@ApiOperation(value = "修改医生信息", notes = "返回修改成功的信息")
	@ApiImplicitParam()
	public String updateDoctor(@PathVariable("id") Integer id) {
		if(null == id) {
			//throw new HttpStatus500Exception("id不能为空");
		}
		//Optional<Doctor> list = dotorDao.findById(id);
		
		return "修改成功！";				
	}

}
