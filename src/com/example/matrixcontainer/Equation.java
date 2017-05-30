package com.example.matrixcontainer;

public class Equation {
	/**
	 * the general solve
	 */
	private double[][] gener;

	/**
	 * the special solve
	 */
	private double[] spe;

	/**
	 * get the the general solve outside
	 * 
	 * @return double[][]
	 */
	public double[][] getGener() {
		return gener;
	}

	/**
	 * set the general solve
	 * 
	 * @param gener
	 */
	public void setGener(double[][] gener) {
		this.gener = gener;
	}

	/**
	 * get the special solve outside
	 * 
	 * @return double[]
	 */
	public double[] getSpe() {
		return spe;
	}

	/**
	 * set the special solve
	 * 
	 * @param spe
	 */
	public void setSpe(double[] spe) {
		this.spe = spe;
	}

	/**
	 * print the solution
	 */
	public String toString() {
		return "general solution:\n" + new Matrix(this.gener) + "\nspecial solution:\n" + new VArray(spe) + "\n";
	}
	
}
