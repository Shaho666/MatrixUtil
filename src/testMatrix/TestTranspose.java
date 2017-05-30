package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestTranspose {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		Matrix matrix = readf.readMatrix("files/matrix2.txt");
		
		System.out.println(matrix);
		
		System.out.println(new MatrixDAO().transpose(matrix));
		
	}
	
}
