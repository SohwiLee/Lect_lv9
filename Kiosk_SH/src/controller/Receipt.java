package controller;

import java.awt.Font;

import javax.swing.JLabel;

import models.Kiosk;
import models.MyUtil;

public class Receipt extends MyUtil{
	// table �����͸� �̿��Ͽ� ������ �׸���
	JLabel question = new JLabel();
	public Receipt() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, Kiosk.height);
		
		this.question.setBounds((Kiosk.width/2)-130, 550, 300, 80);
		this.question.setText("�������� ����Ͻðڽ��ϱ�?");
		this.question.setFont(new Font("",Font.PLAIN,20));
		add(this.question);
	}
}
