package com.example.matrixcontainer;

public class EquationDAO {

	/**
	 * solve the liner functions
	 * 
	 * @param matrix
	 * @return function
	 */
	public Equation solvefunction(Matrix matrix) {

		/**
		 * create a function to return
		 */
		Equation function = new Equation();

		/**
		 * get the array of the matrix input
		 */
		double[][] tpmatrix = matrix.Array();

		/**
		 * get the rank of the matrix
		 */
		int r = new MatrixDAO().rank(matrix);
        
		/**
		 * create the general and special solve
		 */
		double[][] gener = new double[tpmatrix[0].length - 1 - r][tpmatrix[0].length - 1];
		double[] spe = new double[tpmatrix[0].length - 1];
        
		for (int i = 0; i < gener.length; i++) {

			for (int j = 0; j < r; j++) {
				gener[i][j] = -tpmatrix[j][r + i];
			}

			for (int k = r; k < gener[0].length; k++) {
				if (i + r == k)
					gener[i][k] = 1;
			}

		}

		for (int i = 0; i < r; i++) {
			spe[i] = tpmatrix[i][tpmatrix[0].length - 1];
		}
        
		/**
		 * fill the general and special solve
		 */
		function.setGener(gener);
		function.setSpe(spe);

		/**
		 * return the result
		 */
		return function;
	}

}
