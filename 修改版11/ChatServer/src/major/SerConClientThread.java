/**
 * ���ܣ��Ƿ�������ĳ���ͻ��˵�ͨ���߳�
 */
package major;

import java.util.*;
import java.net.*;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import total.ManageClientThread;
import total.*;

public class SerConClientThread extends Thread {// extends JFrame implements
												// Runnable

	Socket socket;

	public SerConClientThread(Socket s) {
		socket = s;
	}

	public void run() {

		while (true) {
			// ������߳̾Ϳ��Խ��տͻ��˵���Ϣ.
			try {
				ObjectInputStream ois = new ObjectInputStream(
						socket.getInputStream());
				Message m = (Message) ois.readObject();

				// �Դӿͻ���ȡ�õ���Ϣ���������жϣ�Ȼ������Ӧ�Ĵ���
				if (m.getMesType().equals("3"))// MessageType.message_comm_mes
				{
					// ���ת��.
					// ȡ�ý����˵�ͨ���̣߳���Ϊ��hashmap����ȡ�������˵�socket_id
					SerConClientThread sc = ManageClientThread
							.getClientThread(m.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(
							sc.socket.getOutputStream());
					oos.writeObject(m);
				} else if (m.getMesType().equals("20"))// MessageType.message_comm_mes
				{
					// ���ת��.
					// ȡ�ý����˵�ͨ���̣߳���Ϊ��hashmap����ȡ�������˵�socket_id
					// Iterator it = ManageClientThread.hm.keySet().iterator();
					Set<String> it = ManageClientThread.hm.keySet();
					for (String uid : it) {
						if (!m.getSender().equals(uid)) {
							System.out.println(uid);
							SerConClientThread sc = (SerConClientThread) ManageClientThread.hm
									.get(uid);
							ObjectOutputStream oos = new ObjectOutputStream(
									sc.socket.getOutputStream());
							oos.writeObject(m);
						}
					}
				}
				// �����ļ�
				else if (m.getMesType().equals("6")) {// ��ʾ׼�������ļ�
					SerConClientThread sc1 = ManageClientThread
							.getClientThread(m.getSender());// ȡ�����Ƿ����˵��߳�
					ObjectOutputStream oos1 = new ObjectOutputStream(
							sc1.socket.getOutputStream());
					oos1.writeObject(m);
				} else if (m.getMesType().equals("4")) {// �����ļ�

					SerConClientThread sc1 = ManageClientThread
							.getClientThread(m.getSender());// ȡ�����Ƿ����˵��߳�
					ObjectOutputStream oos1 = new ObjectOutputStream(
							sc1.socket.getOutputStream());
					oos1.writeObject(m);
				} else if (m.getMesType().equals("5"))// �ļ����ճ���ʼ����
				{
					SerConClientThread sc = ManageClientThread
							.getClientThread(m.getGetter());// ȡ�����ǽ����˵��߳�
					ObjectOutputStream oos = new ObjectOutputStream(sc.socket.getOutputStream());
					oos.writeObject(m);
				}
				// �����ļ���
				else if (m.getMesType().equals("7")) {// ��ʾ׼�����ͷ��ļ���
					SerConClientThread sc1 = ManageClientThread.getClientThread(m.getSender());// ȡ�����Ƿ����˵��߳�
					ObjectOutputStream oos1 = new ObjectOutputStream(
							sc1.socket.getOutputStream());
					oos1.writeObject(m);
				} else if (m.getMesType().equals("8")) {// �ļ��н��ճ���ʼ����
					SerConClientThread sc1 = ManageClientThread.getClientThread(m.getGetter());// ȡ�����ǽ����˵��߳�
					ObjectOutputStream oos1 = new ObjectOutputStream(
							sc1.socket.getOutputStream());
					oos1.writeObject(m);

				} else if (m.getMesType().equals("9")) {// �ļ��н��ճ���ʼ����
					SerConClientThread sc1 = ManageClientThread
							.getClientThread(m.getSender());// ȡ�����Ƿ����˵��߳�
					ObjectOutputStream oos1 = new ObjectOutputStream(
							sc1.socket.getOutputStream());
					oos1.writeObject(m);
				} else if (m.getMesType().equals("10")) {// �ļ��н��ճ���ʼ����
					System.out.println("10");
					SerConClientThread sc1 = ManageClientThread
							.getClientThread(m.getGetter());// ȡ�����ǽ����˵��߳�
					ObjectOutputStream oos1 = new ObjectOutputStream(
							sc1.socket.getOutputStream());
					oos1.writeObject(m);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		}

	}
}
