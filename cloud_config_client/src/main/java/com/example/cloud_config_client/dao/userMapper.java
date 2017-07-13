package com.example.cloud_config_client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.cloud_config_client.entity.sysUser;

@Mapper
public interface userMapper {
	List<sysUser> findAll();

}
