package com.example.matrixui.uimplement;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.example.matrixcontainer.Equation;
import com.example.matrixcontainer.EquationDAO;
import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.VArray;

import com.example.matrixui.uiframe.RootAdvanced;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class LinearEquations extends RootAdvanced {

	public LinearEquations() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("EQUATION"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

		JLabel lblNewLabel = new JLabel(properties.getProperty("GENER"));
		lblNewLabel.setFont(new Font(consolas, Font.PLAIN, 18));
		lblNewLabel.setBounds(400, 100, 260, 22);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 120, 260, 100);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setFont(new Font(consolas, Font.PLAIN, 18));

		JLabel label = new JLabel(properties.getProperty("SPE"));
		label.setFont(new Font(consolas, Font.PLAIN, 18));
		label.setBounds(400, 240, 260, 22);
		frame.getContentPane().add(label);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(400, 260, 260, 63);
		frame.getContentPane().add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font(consolas, Font.PLAIN, 18));

		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					EquationDAO dao = new EquationDAO();

					Equation equs = dao.solvefunction(readT.readMatrix(inputArea.getText()));

					textArea.setText(new Matrix(equs.getGener()).toString());

					textArea_1.setText(new VArray(equs.getSpe()).toString());

				} catch (Exception e2) {

					textArea.setText(properties.getProperty("ERROR"));

					textArea_1.setText(properties.getProperty("ERROR"));

				}

			}
		});

		clearBox.addItem(CALL);
		clearBox.addItem(CRESULT);
		clearBox.addItem(INPUT);
		
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (clearBox.getSelectedItem().equals(CALL)) {
					inputArea.setText(null);
					textArea.setText(null);
					textArea_1.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(CRESULT)) {
					textArea.setText(null);
					textArea_1.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(INPUT)) {
					inputArea.setText(null);
				}

			}
		});

	}

}
