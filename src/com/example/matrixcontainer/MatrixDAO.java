package com.example.matrixcontainer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.example.matrixcontainer.AllException.ExponentErrorExcption;
import com.example.matrixcontainer.AllException.MatrixAddException;
import com.example.matrixcontainer.AllException.MatrixMulException;
import com.example.matrixcontainer.AllException.MatrixSubException;
import com.example.matrixcontainer.AllException.NotSquareMatrixException;

public class MatrixDAO {

	/**
	 * add 2 matrixes
	 * 
	 * @param m1
	 * @param m2
	 * @return Matrix
	 * @throws MatrixAddException
	 * @throws Exception
	 * @throws Exception
	 */
	public Matrix add(Matrix m1, Matrix m2) throws MatrixAddException {

		Matrix matrix = null;

		/**
		 * if m1.row||column does not equals m2's, throws MatrixAddException
		 */
		if (m1.Row() != m2.Row() || m1.Col() != m2.Col())
			throw new AllException.MatrixAddException();

		/**
		 * if not, get the array of m1 and m2
		 */
		double[][] arrm1 = m1.Array();
		double[][] arrm2 = m2.Array();

		/**
		 * create a new array to return
		 */
		double[][] arr = new double[arrm1.length][arrm1[0].length];

		/**
		 * add operations
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = arrm1[i][j] + arrm2[i][j];
			}
		}

		/**
		 * create a new matrix
		 */
		matrix = new Matrix(arr);

		/**
		 * return the result
		 */
		return matrix;
	}

	/**
	 * sub 2 matrixes
	 * 
	 * @param m1
	 * @param m2
	 * @return Matrix
	 * @throws MatrixSubException
	 * @throws Exception
	 */
	public Matrix sub(Matrix m1, Matrix m2) throws MatrixSubException {

		Matrix matrix = null;

		/**
		 * if m1.row||column does not equals m2's, throws MatrixSubException
		 */
		if (m1.Row() != m2.Row() || m1.Col() != m2.Col())
			throw new AllException.MatrixSubException();

		/**
		 * if not, get the array of m1 and m2
		 */
		double[][] arrm1 = m1.Array();
		double[][] arrm2 = m2.Array();

		/**
		 * create a new array to return
		 */
		double[][] arr = new double[arrm1.length][arrm1[0].length];

		/**
		 * sub operations
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = arrm1[i][j] - arrm2[i][j];
			}
		}

		/**
		 * create a new matrix
		 */
		matrix = new Matrix(arr);

		/**
		 * return the result
		 */
		return matrix;
	}

	/**
	 * multiply 2 matrixes
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 * @throws MatrixMulException
	 * @throws Exception
	 */
	public Matrix mul(Matrix m1, Matrix m2) throws MatrixMulException {

		Matrix matrix = null;

		/**
		 * if m1.column does not equals m2.row, throws MatrixMulException
		 */
		if (m1.Col() != m2.Row())
			throw new AllException.MatrixMulException();

		/**
		 * if not, get the array of m1 and m2
		 */
		double[][] arr1 = m1.Array();
		double[][] arr2 = m2.Array();

		/**
		 * create a new array to return
		 */
		double[][] arr = new double[m1.Row()][m2.Col()];

		/**
		 * multiply operation
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				double ele = 0.0;
				for (int m = 0; m < arr1[0].length; m++) {
					ele += arr1[i][m] * arr2[m][j];
				}
				arr[i][j] = ele;
			}
		}

		/**
		 * create a new Matrix
		 */
		matrix = new Matrix(arr);

		/**
		 * return the result
		 */
		return matrix;
	}

	/**
	 * inverse a matrix
	 * 
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public Matrix inverse(Matrix m) throws Exception {

		Matrix matrix = null;

		/**
		 * if the matrix can not inverse, throws MatrixInverseException
		 */
		if (m.Row() != m.Col())
			throw new AllException.MatrixInverseException();

		double[][] matarr = m.Array().clone();

		/**
		 * add an unit matrix to m
		 */
		for (int i = 0; i < matarr.length; i++) {
			matarr[i] = Arrays.copyOf(matarr[i], 2 * matarr[i].length);
			matarr[i][matarr.length + i] = 1;
		}

		/**
		 * Elimination the matrix
		 */
		for (int i = 0; i < matarr.length; i++) {

			int main_index = i;

			for (int index = i; index < matarr.length - 1; index++) {
				if (Math.abs(matarr[index][i]) <= Math.abs(matarr[index + 1][i])
						&& Math.abs(matarr[index + 1][i]) > Math.abs(matarr[main_index][i])) {
					main_index = index + 1;
				}
			}

			/**
			 * swap the main element to first line
			 */
			for (int exchange = 0; exchange < matarr[0].length; exchange++) {
				double temp_ch = matarr[i][exchange];
				matarr[i][exchange] = matarr[main_index][exchange];
				matarr[main_index][exchange] = temp_ch;
			}

			/**
			 * Eliminating...
			 */
			for (int j = i + 1; j < matarr.length; j++) {
				double first = matarr[j][i];
				for (int k = i; k < matarr[i].length; k++) {
					matarr[j][k] = matarr[j][k] - first * matarr[i][k] / matarr[i][i];
				}
			}
		}

		/**
		 * unit of the left
		 */
		for (int i = matarr.length - 1; i >= 0; i--) {
			double first = matarr[i][i];
			for (int simp = 0; simp < matarr[0].length; simp++) {
				matarr[i][simp] = matarr[i][simp] / first;
			}
		}

		/**
		 * simplify the left
		 */
		for (int i = matarr.length - 1; i >= 0; i--) {
			for (int to_zero = i - 1; to_zero >= 0; to_zero--) {
				double first = matarr[to_zero][i];
				for (int j = 0; j < matarr[0].length; j++) {
					matarr[to_zero][j] = matarr[to_zero][j] - matarr[i][j] * first;
				}
			}
		}

		/**
		 * get the inverse matrix from right side
		 */
		double[][] arr = new double[matarr.length][matarr.length];

		for (int copy_1 = 0; copy_1 < arr.length; copy_1++) {
			for (int copy_2 = 0; copy_2 < arr[0].length; copy_2++) {
				arr[copy_1][copy_2] = matarr[copy_1][copy_2 + matarr.length];
			}
		}

		/**
		 * create a new matrix
		 */
		matrix = new Matrix(arr);

		return matrix;
	}

	/**
	 * simplify the matrix to 0
	 * 
	 * @param matrix
	 */
	private void mtozero(Matrix matrix) {

		double[][] tpmatrix = matrix.Array();

		for (int i = 0; i < matrix.Row(); i++) {

			int main_index = i;

			for (int index = i; index < matrix.Row() - 1; index++) {
				if (Math.abs(tpmatrix[index][i]) <= Math.abs(tpmatrix[index + 1][i])
						&& Math.abs(tpmatrix[index + 1][i]) > Math.abs(tpmatrix[main_index][i])) {
					main_index = index + 1;
				}
			}

			/**
			 * swap the main element to first line
			 */

			for (int exchange = 0; exchange < matrix.Col(); exchange++) {

				double temp_ch = tpmatrix[i][exchange];

				tpmatrix[i][exchange] = tpmatrix[main_index][exchange];

				tpmatrix[main_index][exchange] = temp_ch;

			}

			if (tpmatrix[i][i] == 0)
				break;
			/**
			 * Eliminating...
			 */
			for (int j = i + 1; j < matrix.Row(); j++) {

				VArray tpvarray = new VArray(matrix, i);

				if (tpvarray.isnull())
					break;

				double first = tpmatrix[j][i];

				for (int k = i; k < matrix.Col(); k++) {
					tpmatrix[j][k] = tpmatrix[j][k] - first * tpmatrix[i][k] / tpmatrix[i][i];
				}
			}

		}

		/**
		 * unit of the left
		 */

		DNumber dnum = new DNumber();

		for (int i = tpmatrix.length - 1; i >= 0; i--) {

			double first = dnum.decimalbit(tpmatrix[i][i], 2);

			for (int simp = 0; simp < matrix.Col(); simp++) {
				if (first != 0) {
					tpmatrix[i][simp] = tpmatrix[i][simp] / first;
				}
			}

		}

		/**
		 * simplify the left
		 */
		for (int i = tpmatrix.length - 1; i >= 0; i--) {

			for (int to_zero = i - 1; to_zero >= 0; to_zero--) {

				double first = tpmatrix[to_zero][i];

				for (int j = 0; j < matrix.Col(); j++) {
					tpmatrix[to_zero][j] = tpmatrix[to_zero][j] - tpmatrix[i][j] * first;
				}

			}

		}

		// System.out.println(new Matrix(tpmatrix));
	}

	/**
	 * get the rank of a matrix
	 * 
	 * @param matrix
	 * @return rank
	 */
	public int rank(Matrix matrix) {

		int rank = new DNumber().minof(matrix.Row(), matrix.Col());

		this.mtozero(matrix);

		for (int i = 0; i < matrix.Row(); i++) {
			if (new VArray(matrix, i).isnull())
				rank--;
		}

		return rank;
	}

	/**
	 * get the value of a determinant
	 * 
	 * @param matrix
	 * @return determinant of matrix
	 * @throws NotSquareMatrixException
	 */
	public double det(Matrix matrix) throws NotSquareMatrixException {

		if (matrix.Row() != matrix.Col())
			throw new AllException.NotSquareMatrixException();

		/**
		 * save the value of determinant
		 */
		double value = 1.0;

		/**
		 * save the time of row change
		 */
		int row_change = 0;

		/**
		 * get the array of matrix
		 */
		double[][] tpmatrix = matrix.Array();

		for (int i = 0; i < matrix.Row(); i++) {

			int main_index = i;

			for (int index = i; index < matrix.Row() - 1; index++) {

				if (Math.abs(tpmatrix[index][i]) <= Math.abs(tpmatrix[index + 1][i])
						&& Math.abs(tpmatrix[index + 1][i]) > Math.abs(tpmatrix[main_index][i])) {
					main_index = index + 1;
					row_change++;
					break;
				}
			}

			/**
			 * swap the main element to first line
			 */
			for (int exchange = 0; exchange < matrix.Col(); exchange++) {

				double temp_ch = tpmatrix[i][exchange];

				tpmatrix[i][exchange] = tpmatrix[main_index][exchange];

				tpmatrix[main_index][exchange] = temp_ch;

			}

			if (tpmatrix[i][i] == 0)
				break;

			/**
			 * Eliminating...
			 */
			for (int j = i + 1; j < matrix.Row(); j++) {

				double first = tpmatrix[j][i];

				for (int k = i; k < matrix.Col(); k++) {
					tpmatrix[j][k] = tpmatrix[j][k] - first * tpmatrix[i][k] / tpmatrix[i][i];
				}
			}

		}

		/**
		 * calculate the absolute value of the determinant
		 */
		for (int i = 0; i < matrix.Row(); i++) {
			value *= tpmatrix[i][i];
		}

		/**
		 * check the value is positive or negative
		 */
		if (row_change % 2 == 1)
			value = -value;

		if (value == 0.0)
			return 0;

		/**
		 * return the result
		 */
		return value;
	}

	/**
	 * calculate the matrix with exponent
	 * 
	 * @param matrix
	 * @param n
	 * @return Matrix
	 * @throws MatrixMulException
	 * @throws ExponentErrorExcption
	 */
	public Matrix pow(Matrix matrix, int n) throws MatrixMulException, ExponentErrorExcption {

		/**
		 * a result matrix to return
		 */
		Matrix result = null;

		/**
		 * if the row dose not equals column, not permitted
		 */
		if (matrix.Col() != matrix.Row())
			throw new AllException.MatrixMulException();

		/**
		 * if n not more than 0, not permitted
		 */
		if (n <= 0)
			throw new AllException.ExponentErrorExcption();

		/**
		 * if n equals 1, return the matrix input
		 */
		else if (n == 1)
			return matrix;

		/**
		 * if n equals 2, return the multiply of the matrix input
		 */
		else if (n == 2) {
			result = this.mul(matrix, matrix);
			return result;
		}

		/**
		 * if n more than 2, multiply until end
		 */
		else {

			result = this.mul(matrix, matrix);

			for (int i = 2; i < n; i++) {
				result = this.mul(result, matrix);
			}
		}

		/**
		 * return the result
		 */
		return result;
	}

	/**
	 * transpose a matrix
	 * 
	 * @param matrix
	 * @return Matrix
	 */
	public Matrix transpose(Matrix matrix) {

		double[][] tran = new double[matrix.Col()][matrix.Row()];

		for (int i = 0; i < tran.length; i++) {
			for (int j = 0; j < tran[0].length; j++) {
				tran[i][j] = matrix.Array()[j][i];
			}
		}

		return new Matrix(tran);
	}

	/**
	 * schmidt orthogonal of a matrix
	 * 
	 * @param matrix
	 * @return Matrix
	 * @throws Exception
	 * @throws MatrixMulException
	 */
	public Matrix schmidtorthogonal(Matrix matrix) throws Exception {

		/**
		 * the matrix to be schmidt orthogonal
		 */
		Matrix sched = null;

		/**
		 * transpose the matrix input
		 */
		Matrix trans = matrix;

		/**
		 * an new array to create matrix sched
		 */
		double[][] scharr = new double[matrix.Row()][matrix.Col()];
		sched = new Matrix(scharr);

		/**
		 * 1st step to orthogonal
		 */
		sched.update(0, new VArray(trans, 0).mul(1 / new VArray(trans, 0).norm_2()));

		VArrayDAO arrdao = new VArrayDAO();

		/**
		 * the process of schmidt orthogonal
		 */
		for (int i = 1; i < sched.Row(); i++) {

			/**
			 * a new vector to save the result
			 */
			VArray sumarr = new VArray(new double[sched.Col()]);

			/**
			 * the product of x and y
			 */
			VArray arrxy = new VArray(trans, i, true);

			for (int j = 0; j < i; j++) {

				/**
				 * the product of y
				 */
				VArray arryy = new VArray(sched, j, false);

				/**
				 * calculate every element of orthogonal polynomial
				 */
				double xy = arrdao.mul(arrxy, arryy).Array()[0][0];
				double yy = arrdao.mul(arryy, arryy).Array()[0][0];
				sumarr = arrdao.add(sumarr, arryy.mul(xy / yy));

			}

			/**
			 * xn sub the latter elements of orthogonal polynomial
			 */
			sumarr = arrdao.sub(arrxy, sumarr);

			/**
			 * unit...
			 */
			sumarr = sumarr.mul(1 / sumarr.norm_2());

			/**
			 * add the sched vector to matrix
			 */
			sched.update(i, sumarr);

		}

		/**
		 * return the result
		 */
		return this.transpose(sched);
	}

	/**
	 * schmidt orthogonal of a matrix
	 * 
	 * @param matrix
	 * @return Matrix
	 * @throws Exception
	 * @throws MatrixMulException
	 */
	public Matrix schmidtorthogonal(Matrix matrix, boolean q) throws Exception {

		/**
		 * the matrix to be schmidt orthogonal
		 */
		Matrix sched = null;

		/**
		 * transpose the matrix input
		 */
		Matrix trans = matrix;

		/**
		 * an new array to create matrix sched
		 */
		double[][] scharr = new double[matrix.Row()][matrix.Col()];
		sched = new Matrix(scharr);

		/**
		 * 1st step to orthogonal
		 */
		sched.update(0, new VArray(trans, 0));

		VArrayDAO arrdao = new VArrayDAO();

		/**
		 * the process of schmidt orthogonal
		 */
		for (int i = 1; i < sched.Row(); i++) {

			/**
			 * a new vector to save the result
			 */
			VArray sumarr = new VArray(new double[sched.Col()]);

			/**
			 * the product of x and y
			 */
			VArray arrxy = new VArray(trans, i, true);

			for (int j = 0; j < i; j++) {

				/**
				 * the product of y
				 */
				VArray arryy = new VArray(sched, j, false);

				/**
				 * calculate every element of orthogonal polynomial
				 */
				double xy = arrdao.mul(arrxy, arryy).Array()[0][0];
				double yy = arrdao.mul(arryy, arryy).Array()[0][0];
				sumarr = arrdao.add(sumarr, arryy.mul(xy / yy));

			}

			/**
			 * xn sub the latter elements of orthogonal polynomial
			 */
			sumarr = arrdao.sub(arrxy, sumarr);

			/**
			 * add the sched vector to matrix
			 */
			sched.update(i, sumarr);

		}

		/**
		 * return the result
		 */
		return this.transpose(sched);
	}

	/**
	 * decompose a matrix to A = QR
	 * 
	 * @param matrix
	 * @return QR
	 * @throws Exception
	 */
	public QR decomposeQR(Matrix matrix) throws Exception {

		Matrix Q = this.schmidtorthogonal(matrix);

		Matrix R = this.mul(this.inverse(Q), matrix);

		return new QR(Q, R);
	}

	/**
	 * get all eigen values of a matrix
	 * 
	 * @param matrix
	 * @return VArray
	 * @throws Exception
	 */
	public VArray eigenvalue(Matrix matrix) throws Exception {

		/**
		 * decompose matrix input to A = QR
		 */
		QR qr = this.decomposeQR(matrix);
		MatrixDAO dao = new MatrixDAO();

		/**
		 * get matrix Q and R
		 */
		Matrix Q = qr.Q();

		Matrix R = qr.R();

		Matrix A = null;

		/**
		 * iterate to get Qi and Ri
		 */
		for (int i = 0; i < 100; i++) {

			A = dao.mul(R, Q);
			qr = this.decomposeQR(A);

			Q = qr.Q();
			R = qr.R();

		}

		/**
		 * create an array to store the eigen values
		 */
		double[] eigen = new double[matrix.Col()];

		for (int i = 0; i < eigen.length; i++) {
			eigen[i] = new DNumber().decimalbit(A.Array()[i][i], 3);
		}

		/**
		 * return the result
		 */
		return new VArray(eigen);
	}

	/**
	 * calculate the eigenvector of each eigenvalue in a matrix
	 * 
	 * @param matrix
	 * @return Map
	 * @throws Exception
	 */
	public Map<Double, Matrix> eigenvector(Matrix matrix) throws Exception {

		/**
		 * ready for calculating
		 */
		MatrixDAO dao = new MatrixDAO();
		EquationDAO equationDAO = new EquationDAO();

		/**
		 * save the result
		 */
		Map<Double, Matrix> eigenvectors = new HashMap<Double, Matrix>();

		/**
		 * get the eigenvalues of this matrix
		 */
		VArray eigenvalues = this.eigenvalue(matrix);

		/**
		 * calculate the eigenvector of each eigenvalue iteratively
		 */
		for (int i = 0; i < eigenvalues.Size(); i++) {

			/**
			 * create the equations for every eigenvalue
			 */
			Matrix eigenfun = dao.sub(new Matrix(matrix.Row(), eigenvalues.Array()[i]), matrix);

			for (int j = 0; j < eigenfun.Row(); j++) {
				eigenfun.Array()[j] = Arrays.copyOf(eigenfun.Array()[j], eigenfun.Col() + 1);
				eigenfun.Array()[j][eigenfun.Col()] = 0;
			}

			/**
			 * get the solution
			 */
			Equation equation = equationDAO.solvefunction(eigenfun);

			/**
			 * add the result to this hashmap
			 */
			eigenvectors.put(eigenvalues.Array()[i], new Matrix(equation.getGener()));

		}

		/**
		 * return the eigenvectors with their own eigenvalues
		 */
		return eigenvectors;
	}

	/**
	 * calculate the eigen vector of real symmetric matrix
	 * 
	 * @param matrix
	 * @return Map
	 * @throws Exception
	 */
	public Map<Double, Matrix> realsymmetricmatrixeigenvector(Matrix matrix) throws Exception {

		/**
		 * get all the eigenvalues of this real symmetric matrix
		 */
		Map<Double, Matrix> eigenvectors = this.eigenvector(matrix);

		/**
		 * let every eigrn vector unit of its own
		 */
		for (Map.Entry<Double, Matrix> entry : eigenvectors.entrySet()) {

			Matrix vectors = entry.getValue();

			for (int i = 0; i < vectors.Row(); i++) {

				VArray vector = new VArray(true, vectors, i);

				vector.unitofitsown();

			}

		}

		/**
		 * return the result
		 */
		return eigenvectors;
	}

}
