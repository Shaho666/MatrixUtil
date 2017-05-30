package testMatrix;

import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;
import com.example.matrixcontainer.QR;

public class TestDecomposeQR {
	
	public static void main(String[] args) {
		
        try {
			
        	Readf readf = new Readf();
    		
    		Matrix m1 = readf.readMatrix("files/matrix6.txt");
    		
    		QR qr = new MatrixDAO().decomposeQR(m1);
    		
    		System.out.println(qr);
        	
		} catch (Exception e) {

			e.printStackTrace();
	
		}
		
	}
	
}
