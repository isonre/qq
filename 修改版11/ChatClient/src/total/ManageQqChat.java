/**
 * ����һ�������û�����������
 */
package total;

import java.util.*;
import view.*;
public class ManageQqChat {
    //String Ϊһ��loginIdAnFriendId ��Ϊ�ĸ��û���¼��ID��
	private static HashMap hm=new HashMap<String, QqChat>();
	
	//����
	public static void addQqChat(String loginIdAnFriendId,QqChat qqChat)
	{
		hm.put(loginIdAnFriendId, qqChat);
	}
	//ȡ��
	public static QqChat getQqChat(String loginIdAnFriendId )
	{
		return (QqChat)hm.get(loginIdAnFriendId);
	}
	
}
