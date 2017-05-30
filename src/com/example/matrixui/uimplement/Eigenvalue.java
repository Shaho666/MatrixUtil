package com.example.matrixui.uimplement;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;
import com.example.matrixcontainer.VArray;

import com.example.matrixui.uiframe.RootAdvanced;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Eigenvalue extends RootAdvanced {

	private JTextField textField;

	public Eigenvalue() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("EIGEN"));
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
		textField.setFont(new Font(consolas, Font.PLAIN, 20));
		textField.setBounds(392, 134, 283, 41);
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(392, 214, 283, 119);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font(consolas, Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel(properties.getProperty("EIGENVA"));
		lblNewLabel.setFont(new Font(consolas, Font.PLAIN, 18));
		lblNewLabel.setBounds(392, 113, 283, 22);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel(properties.getProperty("EIGENVE"));
		label.setFont(new Font(consolas, Font.PLAIN, 18));
		label.setBounds(392, 194, 283, 22);
		frame.getContentPane().add(label);

		clearBox.addItem(CRESULT);
		clearBox.addItem(CALL);
		clearBox.addItem(INPUT);

		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					Matrix m = readT.readMatrix(inputArea.getText());

					MatrixDAO dao = new MatrixDAO();

					VArray values = null;

					Map<Double, Matrix> vectors = null;

					values = dao.eigenvalue(m);

					if (m.isSymmetric())
						vectors = dao.eigenvector(m);
					else
						vectors = dao.eigenvector(m);

					textField.setText(values.toString());

					boolean append = true;
					for (Map.Entry<Double, Matrix> entry : vectors.entrySet()) {

						double va = entry.getKey();
						Matrix ve = entry.getValue();

						if (append) {
							textArea_1.setText(va + ":\n");
							append = false;
						} else
							textArea_1.append(va + ":\n");

						textArea_1.append(ve.toString() + "\n");

					}

				} catch (Exception e2) {

					textField.setText(properties.getProperty("ERROR"));

				}

			}
		});

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (clearBox.getSelectedItem().equals(CALL)) {
					inputArea.setText(null);
					textField.setText(null);
					textArea_1.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(CRESULT)) {
					textField.setText(null);
					textArea_1.setText(null);
				}

				else if (clearBox.getSelectedItem().equals(INPUT)) {
					inputArea.setText(null);
				}

			}
		});

	}

}
