/**
 * ����qq�����������ڼ������ȴ�ĳ��qq�ͻ��ˣ�������
 */
package major;

import total.*;
import java.net.*;
import java.io.*;
import java.util.*;

import total.ManageClientThread;

public class QqServerConClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqServerConClient qscc = new QqServerConClient();
	}

	public QqServerConClient() {
		try {
			System.out.println("����������8000����");
			ServerSocket ss = new ServerSocket(8000);

			while (true) {
				Socket s = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(
						s.getInputStream());// ���տͻ��˷�������Ϣ.
				User u = (User) ois.readObject();// ��װ��User������Ϊ��һ�ν��ܵ��Ķ�����Ҫ������֤��¼��
				Message m = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(
						s.getOutputStream());
				if (u.getPasswd().equals("000")) {
					m.setMesType("1"); // ���سɹ���½��Ϣ��
					oos.writeObject(m); // ��m����д�ؿͻ���ȥ
					// ��¼�ɹ�
					SerConClientThread scct = new SerConClientThread(s);// ÿ��socket������һ���߳�
					// Ȼ����µ������̷߳ŵ�ManageClientThread����ȥ����
					ManageClientThread.addClientThread(u.getUserId(), scct);// ��ΪaddClientThread�����Ǿ�̬�ģ�Ҫ������ֱ��ȥ����
					// ����
					scct.start();
				} else {
					m.setMesType("2");
					oos.writeObject(m);
					s.close();
					ois.close();
					oos.close();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
