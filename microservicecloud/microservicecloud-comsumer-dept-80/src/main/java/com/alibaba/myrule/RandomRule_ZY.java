package com.alibaba.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZY extends AbstractLoadBalancerRule{

	// total = 0; 总数每台机器轮五次 当total=5时才往下走下一台
	//index = 0; 当前对外提供的服务器地址
	//total需要重置为0，但如果已经五次了后，index应该为1
	//分析，5次，但服务器是8001、8002、8003
	
	private int total = 0;	//总共被调用的次数，目前要求每台调用五次
	private int currrentIndex = 0;	//当前提供的服务器号
	
	public Server choose(ILoadBalancer lb,Object key) {
		if(lb == null) {
			return null;
		}
		Server server = null;
		while(server == null) {
			if(Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			
			int serverCount = allList.size();
			if(serverCount == 0) {
				return null;
			}
			
			//int index = rand.netInt(serverCount);
			// server = upList.get(index)
			
			if(total < 5) {
				server = upList.get(currrentIndex);
				total ++;
			}else {
				total = 0;
				currrentIndex ++;
				if(currrentIndex >= upList.size()) {
					currrentIndex = 0;
				}
			}
			if(server == null) {
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server = null;
			Thread.yield();
		}
		return server;
	}
	
	@Override
	public Server choose(Object key) {
		
		return choose(getLoadBalancer(),key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

}
