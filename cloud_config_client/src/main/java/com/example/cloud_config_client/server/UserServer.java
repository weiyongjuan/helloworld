package com.example.cloud_config_client.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cloud_config_client.dao.UserMapper;
import com.example.cloud_config_client.entity.sysUser;

@Service
public class UserServer {
	
	@Autowired
	
	private UserMapper userMapper;
	
	public List<sysUser> findAll(){
		return userMapper.findAll();
	}
   public static void main(String [] args){
     String a = "";
     String b = " ";
     System.out.println(a.trim().equals(b.trim()));
   }
}
