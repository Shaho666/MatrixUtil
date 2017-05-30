package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.QR;

public class TestQR {

	public static void main(String[] args) {
		
		Readf readf = new Readf();
	    
	    Matrix m1 = readf.readMatrix("files/matrix1.txt");
	    Matrix m2 = readf.readMatrix("files/matrix2.txt");
	    
	    QR qr = new QR(m1, m2);
	    
	    System.out.println(qr.R());
	    
	}
	
}
