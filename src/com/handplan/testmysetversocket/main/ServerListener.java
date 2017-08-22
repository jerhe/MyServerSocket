package com.handplan.testmysetversocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	ServerSocket serverSocket;
	Socket socket;
	ChatSocket cs;
	final int TYPESINGEL=1;
	final int TYPEGROUP=2;



	@Override
	public void run() {
		// 1-65535
		try {
			//���÷�������Ķ˿�
			serverSocket = new ServerSocket(8066);
			//һֱ�ڼ����Ƿ������ݴ�����
			while (true) {
				socket = serverSocket.accept();

				//JOptionPane.showMessageDialog(null, "���û�����8066�˿�");
				
				cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);

			}

		} catch (IOException e) {
			e.printStackTrace();
			//ChatManager.getChatManager().remove(cs);
		}
	}
	
	public void infoClose() {
		try {
			serverSocket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cs.stop();
	}
}
