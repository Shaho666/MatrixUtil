package com.example.matrixui.uimplement;

import java.awt.Font;

import com.example.matrixcontainer.DNumber;
import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

import com.example.matrixui.uiframe.RootAdvanced;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetOfMatrix extends RootAdvanced {

	private final String CALL = properties.getProperty("CALL");
	private final String CRESULT = properties.getProperty("CRESULT");
	private final String INPUT = properties.getProperty("INPUT");

	private JTextField textField;

	public DetOfMatrix() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("DET"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

		clickButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Matrix m = readT.readMatrix(inputArea.getText());

					double det = new MatrixDAO().det(m);

					textField.setText(new DNumber().decimalbit(det, 2) + "");

				} catch (Exception e2) {

					textField.setText(properties.getProperty("ERROR"));

				}

			}
		});

		JLabel lblNewLabel_1 = new JLabel(properties.getProperty("DETE"));
		lblNewLabel_1.setFont(new Font(consolas, Font.PLAIN, 25));
		lblNewLabel_1.setBounds(387, 152, 322, 33);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font(consolas, Font.PLAIN, 35));
		textField.setBounds(398, 220, 311, 75);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		clearBox.addItem(CALL);
		clearBox.addItem(INPUT);
		clearBox.addItem(CRESULT);
		clearBox.setFont(new Font(consolas, Font.PLAIN, 15));
		clearBox.setBounds(427, 32, 126, 24);
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (clearBox.getSelectedItem().equals(CALL)) {
					inputArea.setText(null);
					textField.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(INPUT)) {
					inputArea.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(CRESULT)) {
					textField.setText(null);
				}

			}
		});

	}
}
