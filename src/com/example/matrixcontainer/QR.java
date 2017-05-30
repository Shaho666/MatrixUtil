package com.example.matrixcontainer;

public class QR {

	/**
	 * the matrix Q
	 */
	private Matrix Q;

	/**
	 * the matrix R
	 */
	private Matrix R;

	/**
	 * default constructor
	 */
	public QR() {

	}

	/**
	 * complete constructor
	 * 
	 * @param Q
	 * @param R
	 */
	public QR(Matrix Q, Matrix R) {
		this.Q = Q;
		this.R = R;
	}

	/**
	 * get matrix Q
	 * 
	 * @return Q
	 */
	public Matrix Q() {
		return Q;
	}

	/**
	 * set matrix Q
	 * 
	 * @param Q
	 */
	public void setQ(Matrix Q) {
		this.Q = Q;
	}

	/**
	 * get matrix R
	 * 
	 * @return R
	 */
	public Matrix R() {
		return R;
	}

	/**
	 * set matrix R
	 * 
	 * @param R
	 */
	public void setR(Matrix R) {
		this.R = R;
	}

	/**
	 * print the QR
	 */
	public String toString() {
		return "Q:\n" + Q.toString() + "\nR:\n" + R.toString();
	}

}
