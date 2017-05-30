package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestInverse {
	
	public static void main(String[] args) {
		
        try {
	    	
	    	Readf readf = new Readf();
		    MatrixDAO matrixDAO = new MatrixDAO();
		    
		    Matrix m1 = readf.readMatrix("files/matrix5.txt");
		    
		    System.out.println(m1);
		    
		    System.out.println(matrixDAO.inverse(m1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
