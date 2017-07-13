package com.example.cloud_config_client.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cloud_config_client.dao.UserMapper;
import com.example.cloud_config_client.entity.sysUser;

@Component
public class UserServer {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<sysUser> findAll(){
		return userMapper.findAll();
	}

}
