package com.hb.day03.support;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private static Map<String, String> map = new HashMap<String, String>();
	
	public static void setMap(String key, String value){
		map.put(key, value);
	}
	
	public static MyController mapping(String uri) {
		MyController controller = null;
		try{
			Class clazz = Class.forName(map.get(uri));
			controller = (MyController) clazz.newInstance();
			
		} catch (Exception e) {
		}
		return controller;
	}

}
