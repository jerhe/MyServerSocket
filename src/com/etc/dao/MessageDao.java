package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Message;
import com.etc.util.DBUTIL;

public class MessageDao extends DBUTIL {
	public ArrayList<Message> getToName(String fromname) {
		ArrayList<Message> list = new ArrayList<Message>();
		String sql = "select * from message where fromname=? and isread = 1";
		CachedRowSet crs = execQuery(sql, fromname);
		try {
			while (crs.next()) {
				int id = crs.getInt("id");
				String toname = crs.getString("toname");
				String content = crs.getString("content");
				Date sendtime = crs.getDate("sendtime");
				Message msg = new Message(id, fromname, toname, content,
						sendtime, 1);
				list.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void setRead(Message msg) {
		String sql = "update message set isread = 0 where id =?";
		execUpdate(sql, msg.getId());
	}

	public void saveMessage(Message msg) {
		String sql = "insert into message(id,fromname,toname,content,sendtime,isread) vlaues(?,?,?,?,?,1)";
		execUpdate(sql, msg.getId(), msg.getFromname(), msg.getToname(),
				msg.getContent(), msg.getSendtime());

	}
}
