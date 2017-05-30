package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class EigenvaluePage implements Page{

	@Override
	public void switchpage(Point point, String string) {
		PagePool.eigen.getComboBox().setSelectedItem(string);
		PagePool.eigen.getFrame().setLocation(point);
		PagePool.eigen.getFrame().setVisible(true);
	}

}
