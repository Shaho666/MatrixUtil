package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class LinearEquationsPage implements Page {

	@Override
	public void switchpage(Point point, String string) {
		PagePool.leq.getComboBox().setSelectedItem(string);
		PagePool.leq.getFrame().setLocation(point);
		PagePool.leq.getFrame().setVisible(true);
	}

}
