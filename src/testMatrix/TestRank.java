package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestRank {
	
	public static void main(String[] args) {
		
        Readf readf = new Readf();
		
		Matrix m1 = readf.readMatrix("files/function4.txt");
		
		System.out.println(new MatrixDAO().rank(m1));
		
	}
	
}
