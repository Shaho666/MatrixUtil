package com.example.matrixui.pageswitch;

import java.awt.Point;

import com.example.matrixui.uiframe.PagePool;

public class RankOfMatrixPage implements Page {

	@Override
	public void switchpage(Point point, String string) {
		PagePool.rank.getComboBox().setSelectedItem(string);
		PagePool.rank.getFrame().setLocation(point);
		PagePool.rank.getFrame().setVisible(true);
	}

}
