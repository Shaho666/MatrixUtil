package com.example.matrixcontainer;

import java.util.Arrays;

import com.example.matrixcontainer.AllException.NotSquareMatrixException;

public class Matrix {

	/**
	 * the row of the matrix
	 */
	private int row;

	/**
	 * the column of the matrix
	 */
	private int col;

	/**
	 * store the matrix
	 */
	private double[][] array;

	/**
	 * default constructor
	 */
	public Matrix() {

	}

	/**
	 * create a diag matrix
	 * 
	 * @param n
	 * @param diag
	 */
	public Matrix(int n, double diag) {

		this.row = n;
		this.col = n;
		this.array = new double[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					this.array[i][j] = diag;
			}
		}

	}

	/**
	 * copy constructor
	 * 
	 * @param matrix
	 */
	public Matrix(Matrix matrix) {
		this.row = matrix.row;
		this.col = matrix.col;
		this.array = matrix.array.clone();
	}

	/**
	 * create a matrix with input array
	 * 
	 * @param array
	 */
	public Matrix(double[][] array) {
		this.row = array.length;

		if (array.length != 0)
			this.col = array[0].length;

		this.array = array;
	}

	/**
	 * access the row outside
	 * 
	 * @return this.row
	 */
	public int Row() {
		return this.row;
	}

	/**
	 * access the column outside
	 * 
	 * @return this.col
	 */
	public int Col() {
		return this.col;
	}

	/**
	 * access the store of matrix outside
	 * 
	 * @return
	 */
	public double[][] Array() {
		return this.array;
	}

	/**
	 * set the row of matrix
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * set the column of matrix
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * set the store of matrix
	 * 
	 * @param array
	 */
	public void setArray(double[][] array) {
		this.array = array;
	}

	/**
	 * introduce the matrix
	 */

	private final DNumber dnum = new DNumber();

	public String toString() {

		StringBuffer strbuf = new StringBuffer();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				strbuf.append(dnum.decimalbit(array[i][j], 3)).append("\t");
			}
			strbuf.append("\n");
		}

		return strbuf.toString();

	}

	/**
	 * calculate the value of sub matrix without row i and column j
	 * 
	 * @param i
	 * @param j
	 * @return double
	 * @throws NotSquareMatrixException
	 */
	public double cofactor(int i, int j) throws NotSquareMatrixException {

		/**
		 * save the sub matrix without row i and column j
		 */
		double[][] temp = new double[this.row - 1][this.col - 1];

		/**
		 * save the determinant of the sub matrix
		 */
		double result = 0.0;

		/**
		 * the process to calculate the determinant of the sub matrix
		 */
		for (int m = 0, m1 = m; m < this.row; m++) {

			if (m == i) {
				continue;
			}

			for (int n = 0, n1 = n; n < this.col; n++) {

				if (n == j) {
					continue;
				}

				temp[m1][n1] = this.array[m][n];
				n1++;
			}

			m1++;

		}

		result = new MatrixDAO().det(new Matrix(temp)) * ((i + j) % 2 == 0 ? 1 : -1);

		/**
		 * return the result
		 */
		return result;
	}

	/**
	 * calculate the adjoint matrix
	 * 
	 * @return Matrix
	 * @throws NotSquareMatrixException
	 */
	public Matrix adjoint() throws NotSquareMatrixException {

		/**
		 * save the adjoint matrix
		 */
		double[][] adj = new double[this.row][this.col];

		/**
		 * claculate every element
		 */
		for (int i = 0; i < this.row; i++) {

			for (int j = 0; j < this.col; j++) {

				adj[i][j] = this.cofactor(j, i);

				if (adj[i][j] == 0)
					adj[i][j] = 0;

			}

		}

		/**
		 * return the result
		 */
		return new Matrix(adj);

	}

	/**
	 * update matrix with vector at row line
	 * 
	 * @param row
	 * @param arr
	 */
	public void update(int row, VArray arr) {

		for (int i = 0; i < arr.Size(); i++) {

			this.array[row][i] = arr.Array()[i];

		}

	}

	/**
	 * a data multiply every element of this matrix
	 * 
	 * @param data
	 * @return Matrix
	 */
	public Matrix mul(double data) {

		double[][] mularr = this.array.clone();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				mularr[i][j] *= data;
			}
		}

		return new Matrix(mularr);
	}

	/**
	 * check this matrix whether a symmetric matrix
	 * 
	 * @return
	 */
	public boolean isSymmetric() {
		return this.equals(new MatrixDAO().transpose(new Matrix(array)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(array);
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(array, other.array))
			return false;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
