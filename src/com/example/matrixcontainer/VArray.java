package com.example.matrixcontainer;

public class VArray {

	/**
	 * the size of this vector
	 */
	private int size;

	/**
	 * store an array
	 */
	private double[] array;

	/**
	 * if the vector is a row vector
	 */
	private boolean row;

	/**
	 * default constructor
	 */
	public VArray() {

	}

	/**
	 * create vector with input array
	 * 
	 * @param array
	 */
	public VArray(double[] array) {
		this.size = array.length;
		this.array = array;
	}

	/**
	 * non_default constructor
	 * 
	 * @param array
	 * @param row
	 */
	public VArray(double[] array, boolean row) {
		this.row = row;
		this.size = array.length;
		this.array = array;
	}

	/**
	 * non_default constructor
	 * 
	 * @param matrix
	 * @param index
	 */
	public VArray(Matrix matrix, int index) {

		/**
		 * get the array of matrix
		 */
		double[][] tpmatrix = matrix.Array();

		/**
		 * set parameters
		 */
		this.size = tpmatrix[index].length;
		this.array = tpmatrix[index].clone();

	}

	/**
	 * non_default constructor
	 * 
	 * @param matrix
	 * @param index
	 */
	public VArray(boolean change, Matrix matrix, int index) {

		/**
		 * get the array of matrix
		 */
		double[][] tpmatrix = matrix.Array();

		/**
		 * set parameters
		 */
		this.size = tpmatrix[index].length;
		this.array = tpmatrix[index];

	}
	
	/**
	 * non_default constructor
	 * 
	 * @param matrix
	 * @param index
	 */
	public VArray(Matrix matrix, int index, boolean row) {

		/**
		 * get the array of matrix
		 */
		double[][] tpmatrix = matrix.Array();

		/**
		 * set parameters
		 */
		this.size = tpmatrix[index].length;
		this.array = tpmatrix[index].clone();
		this.row = row;

	}
	
	/**
	 * access the size of vector outside
	 * 
	 * @return size
	 */
	public int Size() {
		return this.size;
	}

	/**
	 * access the vector outside
	 * 
	 * @return array
	 */
	public double[] Array() {
		return this.array;
	}

	/**
	 * set the size of this vector
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * set the array of this vector
	 * 
	 * @param array
	 */
	public void setArray(double[] array) {
		this.array = array;
	}

	/**
	 * if the vector is a row vector
	 * 
	 * @return
	 */
	public boolean isRow() {
		return row;
	}

	/**
	 * set the vector is row or not
	 * 
	 * @param row
	 */
	public void setRow(boolean row) {
		this.row = row;
	}

	private final DNumber dnum = new DNumber();

	/**
	 * to introduce the vector
	 */
	public String toString() {
		StringBuffer strbuf = new StringBuffer();

		for (double dele : array) {
			strbuf.append(dnum.decimalbit(dele, 2)).append("\t");
		}

		strbuf.append("\n");

		return strbuf.toString();
	}

	/**
	 * check the vector whether null
	 * 
	 * @return boolean
	 */
	public boolean isnull() {

		for (double dele : array) {
			if (dnum.decimalbit(dele, 2) != 0)
				return false;
		}

		return true;

	}

	/**
	 * calculate the 2 norm of a vector
	 * 
	 * @return double
	 */
	public double norm_2() {

		double sumofsquare = 0.0;

		for (int i = 0; i < array.length; i++) {
			sumofsquare += array[i] * array[i];
		}

		return Math.sqrt(sumofsquare);

	}

	/**
	 * a sdata multiply every element of vector
	 * 
	 * @param data
	 */
	public VArray mul(double data) {

		double[] muled = array.clone();
		
		for (int i = 0; i < array.length; i++) {
			muled[i] *= data;
		}

		return new VArray(muled);
		
	}

	/**
	 * unit of the vector own
	 */
	public void unitofitsown(){
		
		double base = this.norm_2();
		
		for (int i = 0; i < array.length; i++) {
			array[i] /= base;
		}
		
	}
	
}
