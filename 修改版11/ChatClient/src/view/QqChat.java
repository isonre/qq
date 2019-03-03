/**
 * �������������Ľ���
 * ��Ϊ�ͻ��ˣ�Ҫ���ڶ�ȡ��״̬��������ǰ�������һ���߳�
 */
package view;

import total.*;
import major.*;
import major.ClientConServerThread.FileSendingThread;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class QqChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb,jb1,jb2,jb3;
	JPanel jp,jp1;
	String ownerId;
	String friendId;
	File file;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}
	}
	
	public QqChat(String ownerId,String friend)
	{
		this.ownerId=ownerId;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(30);
		jb=new JButton("������Ϣ");
		jb.addActionListener(this);
		jb1=new JButton("�����ļ�");
		jb1.addActionListener(this);
		jb3=new JButton("�����ļ���");
		jb3.addActionListener(this);
		jb2=new JButton("Ⱥ��");
		jb2.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jp.add(jb1);
		jp.add(jb3);
		jp.add(jb2);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle(ownerId+" �� "+friend+" �����촰��");
		this.setIconImage((new ImageIcon("image/qq.gif").getImage()));
		this.setSize(500, 450);
		this.setVisible(true); 
		
		
	}
	
	public void showMessage(Message m)
	{
		String info=m.getSender()+"˵:"+m.getCon()+"\r\n";
		this.jta.append(info);
		jtf.setText("");
	}
    public void showMessage1(Message m)//ȷ�Ͻ����ļ�
	{
    	int option=JOptionPane.showConfirmDialog(this,"�ͻ������ļ����͹������Ƿ���գ�", "�ļ�������ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option==JOptionPane.YES_OPTION){						
			m.setMesType("4");
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
    public void showMessage2(Message m)
	{
	
		int option=JOptionPane.showConfirmDialog(this,"�ļ��Ѵ������", "�ļ����������ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option==JOptionPane.YES_OPTION){
			this.jta.append("�ļ����ճɹ�");
		}

	}
    
    public void showMessage3(Message m)//ȷ�Ͻ����ļ���
   	{
       	int option1=JOptionPane.showConfirmDialog(this,"�ͻ������ļ��з��͹������Ƿ���գ�", "�ļ�������ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
   		if(option1==JOptionPane.YES_OPTION){						
   			m.setMesType("9");
   			try {
   				ObjectOutputStream oos=new ObjectOutputStream
   				(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
   				oos.writeObject(m);
   			} catch (Exception e) {
   				e.printStackTrace();
   			}	
   		}
   	}
    


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb)//������Ϣ
		{
			Message m=new Message();
			m.setMesType("3");//MessageType.message_comm_mes
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			this.jta.append("��˵:"+jtf.getText()+"\r\n");
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}		
		 else if(arg0.getSource()==jb1) {//�����ļ�
			 Message m=new Message();
		     m.setMesType("6");//5
			 m.setSender(this.ownerId);
			 m.setGetter(this.friendId);	
			 this.jta.append("���ڷ����ļ�"+"\r\n");
					try {
						ObjectOutputStream oos=new ObjectOutputStream
						(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
						oos.writeObject(m);
					} catch (Exception e) {
						e.printStackTrace();
					}	
				}	
		 else if(arg0.getSource()==jb3) {//�����ļ���
			 Message m=new Message();
		     m.setMesType("7");
			 m.setSender(this.ownerId);
			 m.setGetter(this.friendId);	
			 this.jta.append("���ڷ����ļ���"+"\r\n");
			 try {
					ObjectOutputStream oos=new ObjectOutputStream
					(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
					oos.writeObject(m);
				} catch (Exception e) {
					e.printStackTrace();
				}	
		 }

			}

}
