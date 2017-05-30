package testMatrix;

import com.example.matrixcontainer.AllException.MatrixMulException;
import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestSchemidt {
	
	public static void main(String[] args) throws Exception {
		
		Readf readf = new Readf();
		
		Matrix m1 = readf.readMatrix("files/matrix9.txt");
		
		System.out.println(m1);
		
		try {
			System.out.println(new MatrixDAO().schmidtorthogonal(m1,true));
		} catch (MatrixMulException e) {
			e.printStackTrace();
		}
		
	}
	
}
