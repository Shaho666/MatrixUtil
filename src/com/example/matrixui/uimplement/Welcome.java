package com.example.matrixui.uimplement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.example.matrixui.uiframe.RootPage;

public class Welcome extends RootPage {

	public Welcome() {
		initialize(properties.getProperty("FONT1"));
	}

	private void initialize(String consolas) {

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font(consolas, Font.PLAIN, 90));
		lblNewLabel.setBounds(247, 142, 324, 104);
		lblNewLabel.setText(properties.getProperty("MATRIX"));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblContainer = new JLabel(properties.getProperty("CONTAINER"));
		lblContainer.setFont(new Font(consolas, Font.PLAIN, 90));
		lblContainer.setBounds(201, 280, 493, 104);
		frame.getContentPane().add(lblContainer);

		comboBox.setSelectedItem(properties.getProperty("WELCOME"));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String selected = (String) comboBox.getSelectedItem();

				at = frame.getLocation();
				frame.dispose();

				jump(selected);

			}
		});

	}

}
