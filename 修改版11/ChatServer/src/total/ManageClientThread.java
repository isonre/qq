// ����һ������ͻ��˺ͷ���������ͨѶ���߳���
package total;

import java.util.*;

import major.SerConClientThread;
public class ManageClientThread {

	public static HashMap hm=new HashMap<String, SerConClientThread>();
	
	//��hm�����һ���ͻ���ͨѶ�߳�
	public static  void addClientThread(String uid,SerConClientThread ct)
	{
		hm.put(uid, ct);
	}
	
	public static SerConClientThread getClientThread(String uid)
	{
		return (SerConClientThread)hm.get(uid);
	}
	
}
