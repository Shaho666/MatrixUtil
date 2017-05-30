package testMatrix;

import com.example.matrixcontainer.AllException.NotSquareMatrixException;
import com.example.matrixcontainer.Matrix;

public class TestCofactor {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		Matrix matrix = readf.readMatrix("files/matrix1.txt");
		
		System.out.println(matrix);
		
		try {
			System.out.println(matrix.cofactor(2, 2));
		} catch (NotSquareMatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
