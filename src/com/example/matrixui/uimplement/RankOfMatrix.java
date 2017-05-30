package com.example.matrixui.uimplement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.example.matrixcontainer.MatrixDAO;

import com.example.matrixui.uiframe.RootAdvanced;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class RankOfMatrix extends RootAdvanced {

	private JTextField textField;

	public RankOfMatrix() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("RANK"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

		textField = new JTextField();
		textField.setFont(new Font(consolas, Font.PLAIN, 40));
		textField.setBounds(490, 220, 58, 58);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel(properties.getProperty("RANKL"));
		lblNewLabel.setFont(new Font(consolas, Font.PLAIN, 20));
		lblNewLabel.setBounds(430, 140, 192, 50);
		frame.getContentPane().add(lblNewLabel);

		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MatrixDAO dao = new MatrixDAO();

				int rank = dao.rank(readT.readMatrix(inputArea.getText()));

				textField.setText(rank + "");

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
				}
				
				else if(clearBox.getSelectedItem().equals(CRESULT)){
					textField.setText(null);
				}
				
				else if(clearBox.getSelectedItem().equals(INPUT)){
					inputArea.setText(null);
				}
				
			}
		});

	}

}
