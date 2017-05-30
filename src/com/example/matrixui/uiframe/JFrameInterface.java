package com.example.matrixui.uiframe;

import java.awt.Font;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JFrameInterface {
	
	private JFrame frame = null;
	
	private JComboBox<String> functions = null;
	
	private static Properties properties = PropertiesInterface.getProperties();
	
	public JFrame getFrame(Object object) {
		
		frame = new JFrame();
		
		functions = new ComboboxInterface().getFunctions(object);
		frame.getContentPane().add(functions);
		
		frame.getContentPane().setFont(new Font(properties.getProperty("FONT1"), Font.PLAIN, 16));
		frame.setBounds(100, 100, 800, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle(properties.getProperty("COME"));
		
		return frame;
		
	}
	
	public JComboBox<String> getFunctions() {
		return functions;
	}
	
}
