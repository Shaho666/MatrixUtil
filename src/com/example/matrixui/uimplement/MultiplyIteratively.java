package com.example.matrixui.uimplement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

import com.example.matrixui.uiframe.RootAdvanced;

import javax.swing.JScrollPane;

public class MultiplyIteratively extends RootAdvanced {

	private JTextField textField;

	public MultiplyIteratively() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("POW"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(436, 108, 225, 225);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font(consolas, Font.PLAIN, 18));
		textArea.setEditable(false);

		textField = new JTextField();
		textField.setBounds(325, 78, 32, 32);
		frame.getContentPane().add(textField);
		textField.setFont(new Font(consolas, Font.PLAIN, 22));
		textField.setColumns(10);

		clickButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					MatrixDAO dao = new MatrixDAO();
					
					Matrix base = readT.readMatrix(inputArea.getText());
					
					int exponent = Integer.parseInt(textField.getText());
					
					Matrix result = dao.pow(base, exponent);
					
					textArea.setText(result.toString());
						
				} catch (Exception e1) {

					textArea.setText(properties.getProperty("ERROR"));
					
				} 
				
			}
		});
		
		clearBox.addItem(CALL);
		clearBox.addItem(CRESULT);
		clearBox.addItem(INPUT);
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(clearBox.getSelectedItem().equals(CALL)){
					inputArea.setText(null);
					textField.setText(null);
					textArea.setText(null);
				}
				
				else if(clearBox.getSelectedItem().equals(CRESULT)){
					textArea.setText(null);
				}
				
				else if(clearBox.getSelectedItem().equals(INPUT)){
					inputArea.setText(null);
					textField.setText(null);
				}
				
			}
		});
		
	}

}
