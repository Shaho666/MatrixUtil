package com.example.matrixui.uimplement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

import com.example.matrixui.uiframe.RootAdvanced;

public class SchmidtOrthogonal extends RootAdvanced {

	public SchmidtOrthogonal() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("SCHMIDT"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

		inputLabel.setText(properties.getProperty("SCHED"));

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

		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					MatrixDAO dao = new MatrixDAO();

					Matrix sched = dao.schmidtorthogonal(readT.readMatrix(inputArea.getText()), true);
					
					textArea_1.setText(dao.transpose(sched).toString());

				} catch (Exception e2) {

					textArea_1.setText(properties.getProperty("UERROR"));

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
					textArea_1.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(CRESULT)) {
					textArea_1.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(INPUT)) {
					inputArea.setText(null);
				}

			}
		});

	}

}
