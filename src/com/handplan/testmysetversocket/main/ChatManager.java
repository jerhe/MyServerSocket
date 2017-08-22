package com.handplan.testmysetversocket.main;

import java.util.Vector;

public class ChatManager {

	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager() {
		return cm;
	}
	//定义线程同步的集合防止多个客户端访问时出现数据异常
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket cs) {
		vector.add(cs);
		
	}
	
	public void remove(ChatSocket cs){
		vector.remove(cs);
	}
	
	//
	public void publish(ChatSocket cs,String out) {
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket csChatSocket = vector.get(i);
			
			if (!cs.equals(csChatSocket)) {
				//传输数据给客户端
				csChatSocket.out(out);
			}
		}
	}
}
