package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class InverseMatrixPage implements Page{

	@Override
	public void switchpage(Point point, String string) {
		PagePool.inverse.getComboBox().setSelectedItem(string);
		PagePool.inverse.getFrame().setLocation(point);
		PagePool.inverse.getFrame().setVisible(true);
	}

}
