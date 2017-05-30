package com.example.matrixcontainer;

public class VArrayDAO {

	/**
	 * add 2 vectors
	 * 
	 * @param v1
	 * @param v2
	 * @return VArray
	 * @throws Exception
	 */
	public VArray add(VArray v1, VArray v2) throws Exception {

		/**
		 * if v1.length != v2.length, not permitted
		 */
		if (v1.Size() != v2.Size() || v1.isRow() != v2.isRow())
			throw new AllException.VectorAddException();

		/**
		 * save the added vector
		 */
		double[] varr = new double[v1.Size()];

		/**
		 * adding...
		 */
		for (int i = 0; i < varr.length; i++) {
			varr[i] = v1.Array()[i] + v2.Array()[i];
		}

		/**
		 * return the added vector
		 */
		return new VArray(varr);

	}

	/**
	 * add 2 vectors
	 * 
	 * @param v1
	 * @param v2
	 * @return VArray
	 * @throws Exception
	 */
	public VArray sub(VArray v1, VArray v2) throws Exception {

		/**
		 * if v1.length != v2.length, not permitted
		 */
		if (v1.Size() != v2.Size())
			throw new AllException.VectorSubException();

		/**
		 * save the subed vector
		 */
		double[] varr = new double[v1.Size()];

		/**
		 * subing...
		 */
		for (int i = 0; i < varr.length; i++) {
			varr[i] = v1.Array()[i] - v2.Array()[i];
		}

		/**
		 * return the subed vector
		 */
		return new VArray(varr);

	}

	/**
	 * mul 2 vectors
	 * 
	 * @param v1
	 * @param v2
	 * @return Matrix
	 * @throws Exception
	 */
	public Matrix mul(VArray v1, VArray v2) throws Exception {

		/**
		 * condition1: row*column
		 */
		if (v1.isRow() && !v2.isRow() || v1.isRow() == v2.isRow()) {

			/**
			 * if v1.length != v2.length, not permitted
			 */
			if (v1.Size() != v2.Size())
				throw new AllException.VectorMulException();

			/**
			 * if permitted, multiplying...
			 */
			else {

				double[][] varr = new double[1][1];

				for (int i = 0; i < v1.Size(); i++) {
					varr[0][0] += v1.Array()[i] * v2.Array()[i];
				}

				/**
				 * return the result
				 */
				return new Matrix(varr);

			}

		}

		/**
		 * condition2: column*row
		 */
		else if (!v1.isRow() && v2.isRow()) {

			double[][] varr = new double[v1.Size()][v2.Size()];

			/**
			 * no conditions, multiplying...
			 */
			for (int i = 0; i < varr.length; i++) {
				for (int j = 0; j < varr[0].length; j++) {
					varr[i][j] = v1.Array()[i] * v2.Array()[j];
				}
			}

			/**
			 * return the result
			 */
			return new Matrix(varr);

		}

		else
			throw new AllException.VectorMulException();

	}

}
