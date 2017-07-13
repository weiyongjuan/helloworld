package com.example.cloud_config_client.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.cloud_config_client.dao.UserMapper;
import com.example.cloud_config_client.entity.sysUser;

@Service
@ComponentScan(basePackages="com.example.cloud_config_client.dao")
public class UserServer {
	
	@Autowired
	
	private UserMapper userMapper;
	
	public List<sysUser> findAll(){
		return userMapper.findAll();
	}

}
