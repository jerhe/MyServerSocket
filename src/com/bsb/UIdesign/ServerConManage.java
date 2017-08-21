package com.bsb.UIdesign;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;







public class ServerConManage {
	private static final ServerConManage instance = new ServerConManage();
	ServerManage Window;
	
	public void setWindow(ServerManage window) {
		this.Window = window;
		
	}
	public static ServerConManage getCM() {
		return instance;	
	}
	public  void send(String out) {
		
		Window.appendTextother(out+"用户连接了客户端");
		
	}
}
