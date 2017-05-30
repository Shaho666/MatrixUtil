package testMatrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.VArray;

public class Readf {

	/**
	 * read a matrix from a file
	 * 
	 * @param fin
	 * @return Matrix
	 */
	public Matrix readMatrix(String fin) {

		Matrix matrix = null;

		try {
			/**
			 * the file will be read
			 */
			File inf = new File(fin);

			/**
			 * fileReader to read the file
			 */
			FileReader infr = new FileReader(inf);
			BufferedReader infbuf = new BufferedReader(infr);

			/**
			 * store every line of the file
			 */
			Queue<String> qs = new LinkedList<String>();

			/**
			 * extract every line
			 */
			String temp = null;

			/**
			 * put every line into queue
			 */
			while ((temp = infbuf.readLine()) != null) {
				qs.add(temp);
			}

			infbuf.close();
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return matrix;
	}

	/**
	 * read a vector from a file
	 * 
	 * @param fin
	 * @return array
	 */
	public VArray readVarray(String fin) {

		VArray varray = null;

		try {

			/**
			 * the file will be read
			 */
			File inf = new File(fin);

			/**
			 * fileReader to read the file
			 */
			FileReader infr = new FileReader(inf);
			BufferedReader infbuf = new BufferedReader(infr);

			/**
			 * get the vector
			 */
			String vastr = infbuf.readLine();
			String[] vaele = vastr.split(" ");

			/**
			 * create a new array to store vector
			 */
			double[] arr = new double[vaele.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Double.parseDouble(vaele[i]);
			}

			infbuf.close();

			/**
			 * create a new array
			 */
			varray = new VArray(arr);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return varray;
	}

	public VArray readVarray(String fin, boolean row){
		
		VArray varray = null;
		
		try {
			
			varray = this.readVarray(fin);
			
			varray.setRow(row);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return varray;
		
	}
	
}
