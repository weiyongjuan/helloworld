package com.example.cloud_config_client.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cloud_config_client.dao.userMapper;
import com.example.cloud_config_client.entity.sysUser;

@Service
public class userServer {
	@Autowired
	private userMapper sysUserMapper;
	
	public sysUser findAll(){
		return sysUserMapper.findAll();
	}

}
