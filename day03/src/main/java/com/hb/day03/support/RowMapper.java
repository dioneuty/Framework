package com.hb.day03.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RowMapper {
	final List list = new ArrayList();
	
	Object mapRow(ResultSet rs) throws SQLException;
}
