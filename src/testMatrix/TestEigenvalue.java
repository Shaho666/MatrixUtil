package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestEigenvalue {
	
	public static void main(String[] args) {
		
		try {
			
			Readf readf = new Readf();
			
			Matrix matrix = readf.readMatrix("files/matrix6.txt");
			
			System.out.println(matrix);
			
			System.out.println(new MatrixDAO().eigenvalue(matrix));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
