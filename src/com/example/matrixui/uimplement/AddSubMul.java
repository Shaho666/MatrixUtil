package com.example.matrixui.uimplement;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;
import com.example.matrixui.uiframe.RootPage;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSubMul extends RootPage {

	private static final String ADD = "+";
	private static final String SUB = "-";
	private static final String MUL = "*";
	
	private final String INPUT1 = properties.getProperty("INPUT1");
	private final String INPUT2 = properties.getProperty("INPUT2");
	
	public AddSubMul() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		comboBox.setSelectedItem(properties.getProperty("BASIC"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(27, 108, 225, 225);
		frame.getContentPane().add(scrollPane_2);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font(consolas, Font.PLAIN, 20));
		scrollPane_2.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(279, 108, 225, 225);
		frame.getContentPane().add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font(consolas, Font.PLAIN, 20));
		scrollPane_1.setViewportView(textArea_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(537, 108, 225, 225);
		frame.getContentPane().add(scrollPane);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setFont(new Font(consolas, Font.PLAIN, 18));
		scrollPane.setViewportView(textArea_2);

		JLabel lblNewLabel = new JLabel(properties.getProperty("FIRSTMATRIX"));
		lblNewLabel.setFont(new Font(consolas, Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 339, 165, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel(properties.getProperty("SECONDMATRIX"));
		label.setFont(new Font(consolas, Font.PLAIN, 18));
		label.setBounds(279, 339, 165, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel(properties.getProperty("RESULT"));
		label_1.setFont(new Font(consolas, Font.PLAIN, 18));
		label_1.setBounds(536, 339, 165, 15);
		frame.getContentPane().add(label_1);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem(MUL);
		comboBox_2.addItem(ADD);
		comboBox_2.addItem(SUB);
		comboBox_2.setFont(new Font(consolas, Font.PLAIN, 18));
		comboBox_2.setBounds(628, 70, 50, 24);
		frame.getContentPane().add(comboBox_2);

		JButton btnNewButton = new JButton(properties.getProperty("CALCULATE"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Matrix m = null;
				
				try {
					
					Matrix m1 = readT.readMatrix(textArea.getText());

					Matrix m2 = readT.readMatrix(textArea_1.getText());

					MatrixDAO dao = new MatrixDAO();

					String method = (String) comboBox_2.getSelectedItem();

					if (method.equals(ADD))
						m = dao.add(m1, m2);

					else if (method.equals(SUB))
						m = dao.sub(m1, m2);

					else if (method.equals(MUL))
						m = dao.mul(m1, m2);
					
					textArea_2.setText(m.toString());
					
				} catch (Exception e2) {

					textArea_2.setText(properties.getProperty("ERROR"));
					
				} 

			}
		});
		btnNewButton.setFont(new Font(consolas, Font.PLAIN, 18));
		btnNewButton.setBounds(134, 400, 530, 33);
		frame.getContentPane().add(btnNewButton);

		JLabel label_2 = new JLabel(properties.getProperty("METHOD"));
		label_2.setFont(new Font(consolas, Font.PLAIN, 18));
		label_2.setBounds(427, 75, 176, 15);
		frame.getContentPane().add(label_2);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem(properties.getProperty("CRESULT"));
		comboBox_1.addItem(properties.getProperty("CALL"));
		comboBox_1.addItem(properties.getProperty("INPUT1"));
		comboBox_1.addItem(properties.getProperty("INPUT2"));
		comboBox_1.setFont(new Font(consolas, Font.PLAIN, 15));
		comboBox_1.setBounds(427, 32, 126, 24);
		frame.getContentPane().add(comboBox_1);

		JButton btnNewButton_1 = new JButton(properties.getProperty("CLEAR"));
		btnNewButton_1.setFont(new Font(consolas, Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_1.getSelectedItem().equals(CALL)){
					textArea.setText(null);
					textArea_1.setText(null);
					textArea_2.setText(null);
				}
				
				else if(comboBox_1.getSelectedItem().equals(CRESULT)){
					textArea_2.setText(null);
				}
				
				else if(comboBox_1.getSelectedItem().equals(INPUT1)){
					textArea.setText(null);
				}
				
				else if(comboBox_1.getSelectedItem().equals(INPUT2)){
					textArea_1.setText(null);
				}
				
			}
		});
		btnNewButton_1.setBounds(585, 32, 93, 24);
		frame.getContentPane().add(btnNewButton_1);
	}

}
