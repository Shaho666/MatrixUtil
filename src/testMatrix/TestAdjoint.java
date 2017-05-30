package testMatrix;

import com.example.matrixcontainer.AllException.NotSquareMatrixException;
import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestAdjoint {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		Matrix matrix = readf.readMatrix("files/matrix2.txt");
		
		System.out.println(matrix);
		
		try {
			System.out.println(matrix.adjoint());
		} catch (NotSquareMatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(new MatrixDAO().det(matrix));
		} catch (NotSquareMatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
