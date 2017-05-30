package com.example.matrixui.uimplement;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

import com.example.matrixui.uiframe.RootAdvanced;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InverseMatrix extends RootAdvanced {

	private final String inverse = properties.getProperty("INVERSEM");
	private final String adjoint = properties.getProperty("ADJOINT");
	
	public InverseMatrix() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("INVERSE"));
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

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font(consolas, Font.PLAIN, 18));
		textArea_1.setEditable(false);
		scrollPane.setViewportView(textArea_1);

		JLabel label_1 = new JLabel(properties.getProperty("RESULT"));
		label_1.setFont(new Font(consolas, Font.PLAIN, 18));
		label_1.setBounds(436, 339, 165, 15);
		frame.getContentPane().add(label_1);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem(inverse);
		comboBox_2.addItem(adjoint);
		comboBox_2.setFont(new Font(consolas, Font.PLAIN, 16));
		comboBox_2.setBounds(500, 70, 178, 24);
		frame.getContentPane().add(comboBox_2);
		
		clickButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					MatrixDAO dao = new MatrixDAO();
					
					Matrix matrix = readT.readMatrix(inputArea.getText());
					
					if(comboBox_2.getSelectedItem().equals(inverse)){
						
						textArea_1.setText(dao.inverse(matrix).toString());
						
					}
					else if(comboBox_2.getSelectedItem().equals(adjoint)){
						
						textArea_1.setText(matrix.adjoint().toString());
						
					}
					
				} catch (Exception e2) {

					textArea_1.setText(properties.getProperty("ERROR"));
					
				}
				
			}
		});
		
		JLabel label_2 = new JLabel(properties.getProperty("CHOOSE"));
		label_2.setFont(new Font(consolas, Font.PLAIN, 18));
		label_2.setBounds(427, 75, 176, 15);
		frame.getContentPane().add(label_2);

		clearBox.addItem(CALL);
		clearBox.addItem(INPUT);
		clearBox.addItem(CRESULT);
		clearBox.setFont(new Font(consolas, Font.PLAIN, 15));
		clearBox.setBounds(427, 32, 126, 24);
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(clearBox.getSelectedItem().equals(CALL)){
					inputArea.setText(null);
					textArea_1.setText(null);
				}
				
				else if(clearBox.getSelectedItem().equals(INPUT)){
					inputArea.setText(null);
				}
				
				else if(clearBox.getSelectedItem().equals(CRESULT)){
					textArea_1.setText(null);
				}
				
			}
		});
		
	}
}
