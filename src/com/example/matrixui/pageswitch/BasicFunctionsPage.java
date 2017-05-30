package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class BasicFunctionsPage implements Page {

	@Override
	public void switchpage(Point point, String string) {
		PagePool.basics.getComboBox().setSelectedItem(string);
		PagePool.basics.getFrame().setLocation(point);
		PagePool.basics.getFrame().setVisible(true);
	}

}
