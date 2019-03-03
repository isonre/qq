/**
 * ����:qq�ͻ��˵�¼����
 */
package view;

import total.*;
import major.*;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QqClientLogin extends JFrame implements ActionListener {
	JLabel jbl1;// ������ǩ
	JPanel jp2;// �м����
	JLabel jp2_jbl1, jp2_jbl2;// QQ�����ǩ��QQ�����ǩ
	JTextField jp2_jtf;// QQ�����
	JPasswordField jp2_jpf;// QQ�����
	JPanel jp1;// �ϲ����
	JButton jp1_jb1, jp1_jb2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QqClientLogin qqClientLogin = new QqClientLogin();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}
	}

	public QqClientLogin() {
		// ����
		jbl1 = new JLabel(new ImageIcon("image/QQ1.jpg"));

		// �в�
		JPanel panel_1 = new JPanel();
		jp2_jbl1 = new JLabel("QQ����");
		jp2_jbl2 = new JLabel("QQ����");
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();

		jp2_jbl1.setBounds(70, 53, 51, 15);
		jp2_jbl2.setBounds(70, 91, 51, 15);
		panel_1.setLayout(null);
		panel_1.add(jp2_jbl1);
		panel_1.add(jp2_jbl2);
		jp2_jtf.setBounds(131, 50, 121, 21);
		panel_1.add(jp2_jtf);
		jp2_jtf.setColumns(10);
		jp2_jpf.setBounds(131, 88, 121, 21);
		panel_1.add(jp2_jpf);

		// �ϲ�
		jp1 = new JPanel();
		jp1_jb1 = new JButton("��¼");
		jp1_jb2 = new JButton("ȡ��");
		// ��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp1.add(jp1_jb1);
		jp1_jb2.addActionListener(this);
		jp1.add(jp1_jb2);

		this.add(jbl1, "North");
		this.add(panel_1, BorderLayout.CENTER);
		this.add(jp1, "South");

		setBounds(100, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == jp1_jb1)// ��¼
		{
			QqClientUser qqClientUser = new QqClientUser();
			User u = new User();
			u.setUserId(jp2_jtf.getText().trim());
			u.setPasswd(new String(jp2_jpf.getPassword()));
			if (qqClientUser.checkUser(u)) {
				try {

					QqFriendList qqList = new QqFriendList(u.getUserId());

				} catch (Exception e) {
					e.printStackTrace();
				}
				// �رյ���¼����
				// this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "�û����������");
			}
		} else if (arg0.getSource() == jp1_jb2)// ȡ��
		{
			System.exit(0);

		}
	}

}
