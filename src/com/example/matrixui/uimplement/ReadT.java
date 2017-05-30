package com.example.matrixui.uimplement;

import java.util.LinkedList;
import java.util.Queue;

import com.example.matrixcontainer.Matrix;

public class ReadT {

	/**
	 * read a matrix from a text area
	 * 
	 * @param fin
	 * @return Matrix
	 */
	public Matrix readMatrix(String fin) throws NumberFormatException{

		Matrix matrix = null;

		/**
		 * store every line of the file
		 */
		Queue<String> qs = new LinkedList<String>();

		/**
		 * put every line into queue
		 */

		String[] mas = fin.split("\n");

		for (String string : mas) {
			qs.add(string);
		}

		/**
		 * store the matrix
		 */

		double[][] marr = new double[qs.size()][qs.peek().split(" ").length];

		for (int i = 0; i < marr.length; i++) {

			String mtp = qs.peek();
			String[] line = mtp.split(" ");

			for (int j = 0; j < line.length; j++) {
				marr[i][j] = Double.parseDouble(line[j]);
			}

			qs.poll();
		}

		/**
		 * make the matrix to return
		 */
		matrix = new Matrix(marr);
		
		return matrix;
	}

}
