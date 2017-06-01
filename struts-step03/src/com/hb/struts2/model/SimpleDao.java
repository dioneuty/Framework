package com.hb.struts2.model;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SimpleDao {
	private static SqlMapClient smc;
	public SimpleDao(){
		String path = "./SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			smc = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<SimpleVo> seletAll() throws SQLException {
		return smc.queryForList("selectAll");
	}

}
