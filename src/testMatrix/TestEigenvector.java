package testMatrix;

import java.util.Map;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestEigenvector {
	
	public static void main(String[] args) {
		
		try {
			
			Readf readf = new Readf();
			
			Matrix matrix = readf.readMatrix("files/matrix6.txt");
			
			Matrix m1 = new MatrixDAO().transpose(matrix);
			
			System.out.println(m1);
			
			Map<Double, Matrix> eigenvectors = new MatrixDAO().eigenvector(m1);
			
			for (Map.Entry<Double, Matrix> entry : eigenvectors.entrySet()) {
				
				System.out.println(entry.getKey()+":");
				
				System.out.println(entry.getValue());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
