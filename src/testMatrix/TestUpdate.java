package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.VArray;

public class TestUpdate {

	public static void main(String[] args) {
		
		Readf readf = new Readf();
	    
	    Matrix m1 = readf.readMatrix("files/matrix2.txt");
	    
	    VArray v1 = readf.readVarray("files/array6.txt");
	    
	    System.out.println(m1);
	    
	    m1.update(1, v1);
	    
	    System.out.println(m1);
		
	}
	
}
