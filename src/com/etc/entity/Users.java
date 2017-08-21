package com.etc.entity;

import java.io.Serializable;

/**
 * ”√ªß¿‡
 * @author zhuzhen
 *
 */
public class Users implements Serializable {
	private int id;
	private String name;
	private String pwd;

	public Users() {
	}

	public Users(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Users(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

}
