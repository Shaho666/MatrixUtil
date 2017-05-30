package com.example.matrixui.uiframe;

import java.awt.Font;
import java.util.Properties;

import javax.swing.JComboBox;

public class ComboboxInterface {
	
	private Properties properties = null;
	
	private JComboBox<String> functions = null;
	
	public JComboBox<String> getFunctions(Object object) {
		
		properties = PropertiesInterface.getProperties();
		
		functions = new JComboBox<String>();
		
		functions.setFont(new Font(properties.getProperty("FONT1"), Font.PLAIN, 16));
		functions.setBounds(75, 46, 245, 24);
		
		functions.addItem(properties.getProperty("WELCOME"));
		functions.addItem(properties.getProperty("BASIC"));
		functions.addItem(properties.getProperty("INVERSE"));
		functions.addItem(properties.getProperty("EQUATION"));
		functions.addItem(properties.getProperty("RANK"));
		functions.addItem(properties.getProperty("DET"));
		functions.addItem(properties.getProperty("POW"));
		functions.addItem(properties.getProperty("SCHMIDT"));
		functions.addItem(properties.getProperty("EIGEN"));
		
		functions.setSelectedItem(object);
		
		return functions;
	}
	
}
