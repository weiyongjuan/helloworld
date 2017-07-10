package com.example.cloud_config_client.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.cloud_config_client.entity.sysUser;

@Mapper
public interface userMapper {
	sysUser findAll();

}
