package com.example.matrixui.uimplement;

import java.awt.EventQueue;

import com.example.matrixui.uiframe.PagePool;

public class MatrixMain {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Welcome window = PagePool.welcome;
					window.getFrame().setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});

	}

}
