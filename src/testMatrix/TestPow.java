package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestPow {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		Matrix m1 = readf.readMatrix("files/matrix2.txt");
		System.out.println(m1);
		
		MatrixDAO dao = new MatrixDAO();
		
		try {
			System.out.println(dao.pow(m1, 3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
