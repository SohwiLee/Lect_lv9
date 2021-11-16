package controller;

import java.awt.Color;

import models.Kiosk;
import models.MyUtil;

public class CashPanel extends MyUtil{

	public CashPanel() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, Kiosk.height);
		setBackground(Color.black);
	}
}
