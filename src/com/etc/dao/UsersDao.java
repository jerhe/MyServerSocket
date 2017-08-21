package com.etc.dao;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Users;
import com.etc.util.DBUTIL;

public class UsersDao extends DBUTIL {

	public Users getUsersById(int id) {
		String sql = "select * from usertable where id =?";
		CachedRowSet crs = execQuery(sql, id);
		Users users = null;
		try {
			if (crs.next()) {
				users = new Users(crs.getInt("id"), crs.getString("name"),
						crs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public Users getUsersByName(String name) {
		String sql = "select * from usertable where name =?";
		CachedRowSet crs = execQuery(sql,name);
		Users users = null;
		try {
			if (crs.next()) {
				users = new Users(crs.getInt("id"), crs.getString("name"),
						crs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
