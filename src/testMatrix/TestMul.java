package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestMul {
	
	public static void main(String[] args) {
		
		try {
	    	
	    	Readf readf = new Readf();
		    MatrixDAO matrixDAO = new MatrixDAO();
		    
		    Matrix m1 = readf.readMatrix("files/matrix3.txt");
		    Matrix m2 = readf.readMatrix("files/matrix4.txt");
		    
		    System.out.println(m1);
		    System.out.println(m2);
		    
			System.out.println(matrixDAO.mul(m1, m2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
