package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class DetOfMatrixPage implements Page {

	@Override
	public void switchpage(Point point, String string) {
		PagePool.det.getComboBox().setSelectedItem(string);
		PagePool.det.getFrame().setLocation(point);
		PagePool.det.getFrame().setVisible(true);
	}

}
