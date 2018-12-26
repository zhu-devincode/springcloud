package com.alibaba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.alibaba.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//在该启动类里面自动加载自定义的Ribbon配置类，从而生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
