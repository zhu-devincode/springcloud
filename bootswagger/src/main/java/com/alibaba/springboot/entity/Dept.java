package com.alibaba.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix="boy")	//从配置文件中取值注入属性中
//@Component
@Entity(name = "dept")
@ApiModel(value = "对象模型")
public class Dept {
	
	@Id	//主键
	@GeneratedValue	//自增
	@ApiModelProperty(value = "id", required = true)
	private Integer id;
	@ApiModelProperty(value = "姓名", required = true)
	private String name;
	@ApiModelProperty(value = "年龄", required = true)
    private Integer age;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
    
	
}
