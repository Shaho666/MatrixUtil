package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class WelComePage implements Page {

	@Override
	public void switchpage(Point point, String string) {
		PagePool.welcome.getComboBox().setSelectedItem(string);
		PagePool.welcome.getFrame().setLocation(point);
		PagePool.welcome.getFrame().setVisible(true);
	}

}
