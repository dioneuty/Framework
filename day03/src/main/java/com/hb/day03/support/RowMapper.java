package com.hb.day03.support;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
	public abstract Object mapRow(ResultSet rs) throws SQLException;
}
