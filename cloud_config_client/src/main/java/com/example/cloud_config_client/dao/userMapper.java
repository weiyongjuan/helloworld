package com.example.cloud_config_client.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.cloud_config_client.entity.sysUser;

@Mapper
public interface userMapper {
	@Select("select user_id,user_name,user_password,phone from sys_user")
	sysUser findAll();

}
