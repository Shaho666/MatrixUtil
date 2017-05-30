package com.example.matrixui.uiframe;

import java.awt.Font;

import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class RootAdvanced extends RootPage{
	
	protected JTextArea inputArea = null;
	
	protected JLabel inputLabel = null;
	
	protected JButton clickButton = null;
	
	protected JButton clearButton = null;
	
	protected JComboBox<String> clearBox = null;
	
	public RootAdvanced() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 108, 225, 225);
		frame.getContentPane().add(scrollPane);
		
		inputArea = new JTextArea();
		inputArea.setFont(new Font(consolas, Font.PLAIN, 20));
		scrollPane.setViewportView(inputArea);
		
		inputLabel = new JLabel(properties.getProperty("INVERSED"));
		inputLabel.setFont(new Font(consolas, Font.PLAIN, 18));
		inputLabel.setBounds(102, 339, 165, 15);
		frame.getContentPane().add(inputLabel);
		
		clickButton = new JButton(properties.getProperty("CALCULATE"));
		
		clickButton.setFont(new Font(consolas, Font.PLAIN, 18));
		clickButton.setBounds(134, 400, 530, 33);
		frame.getContentPane().add(clickButton);
		
		clearButton = new JButton(properties.getProperty("CLEAR"));
		clearButton.setBounds(585, 32, 93, 24);
		clearButton.setFont(new Font(consolas, Font.PLAIN, 16));
		frame.getContentPane().add(clearButton);
		
		clearBox = new JComboBox<String>();
		clearBox.setFont(new Font(consolas, Font.PLAIN, 15));
		clearBox.setBounds(427, 32, 126, 24);
		frame.getContentPane().add(clearBox);
		
	}

}
