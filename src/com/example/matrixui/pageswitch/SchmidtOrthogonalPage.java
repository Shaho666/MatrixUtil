package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class SchmidtOrthogonalPage implements Page{

	@Override
	public void switchpage(Point point, String string) {
		PagePool.sched.getComboBox().setSelectedItem(string);
		PagePool.sched.getFrame().setLocation(point);
		PagePool.sched.getFrame().setVisible(true);
	}

}
