package major;

import total.*;
public class QqClientUser {
	//��Ӧ�ͻ�����ĸ���������࣬����˵ɾ��������Ӻ��ѣ������ļ��ȵȣ�����ҵ���߼����
	//����û���¼�ɹ����
	public boolean checkUser(User u)
	{
		return new QqClientConServer().sendLoginInfoToServer(u);
	}
	
}
