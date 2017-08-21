package com.handplan.testmysetversocket.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import com.bsb.UIdesign.ServerConManage;
import com.bsb.UIdesign.ServerManage;
public class ChatSocket extends Thread {
	
	Socket socket;
	boolean flag=false;
	public ChatSocket(Socket s){
		this.socket = s;
	}

	public void out(String out) {
		try {
			//输出给客户端
			socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		try {
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream(),"UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				ChatManager.getChatManager().publish(this, line);
				if(!flag)
				{ServerConManage.getCM().send(line);
				flag=true;}			
			}
			br.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
