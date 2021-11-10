package models;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.Racing;

public class Race extends JFrame {
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	// ��ũ��������
	public static final int W = dm.width;
	public static final int H = dm.height;
	// â ũ��
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;

	private Racing rp = new Racing();

	public Race() {
		super("Racing Game");
		setLayout(null);
		setBounds((W / 2) - (WIDTH / 2), (H / 2) - (HEIGHT / 2), WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// ��������
		add(rp);
		setVisible(true);
		revalidate();// ���Ÿ޼���
		rp.run();
	}

}
