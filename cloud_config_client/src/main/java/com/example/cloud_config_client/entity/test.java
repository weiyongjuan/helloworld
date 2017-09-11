package com.example.cloud_config_client.entity;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String [] args){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("张三", "张三");
		System.out.println(map.get("李四"));
	}

}
