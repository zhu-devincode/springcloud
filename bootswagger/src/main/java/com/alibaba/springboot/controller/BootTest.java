package com.alibaba.springboot.controller;

import java.util.List;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.springboot.dao.DeptDao;
import com.alibaba.springboot.entity.Dept;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "对BootSwagger中springboot集成swagger2的测试")
public class BootTest {
	
	@Autowired
	private DeptDao deptDao;
	
	@GetMapping(value = "/findList")
	@ApiOperation(value = "查询全部用户信息", notes = "返回list集合的Json串")
	public List<Dept> getDeptList(){
		return deptDao.findAll();
	}
	
	@PostMapping(value = "/saveDept")
	@ApiOperation(value = "添加用户", notes = "返回添加的用户json串")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "name", value = "姓名", required = true, dataType = "String"),
		@ApiImplicitParam(paramType = "query", name = "age", value = "年龄", required = true, dataType = "String"),
	})
	public Dept addDept(@RequestParam("name") String name, @RequestParam("age")Integer age) {
		Dept dept = new Dept();
		dept.setName(name);
		dept.setAge(age);
		return deptDao.save(dept);
	}

}
