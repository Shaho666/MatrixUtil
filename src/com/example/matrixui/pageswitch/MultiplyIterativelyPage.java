package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class MultiplyIterativelyPage implements Page{

	@Override
	public void switchpage(Point point, String string) {
		PagePool.muliter.getComboBox().setSelectedItem(string);
		PagePool.muliter.getFrame().setLocation(point);
		PagePool.muliter.getFrame().setVisible(true);
	}

}
