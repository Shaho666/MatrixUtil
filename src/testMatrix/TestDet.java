package testMatrix;

import com.example.matrixcontainer.AllException.NotSquareMatrixException;
import com.example.matrixcontainer.DNumber;
import com.example.matrixcontainer.Matrix;
import com.example.matrixcontainer.MatrixDAO;

public class TestDet {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		Matrix matrix = readf.readMatrix("files/matrix11.txt");
		
		MatrixDAO dao = new MatrixDAO();
		
		try {
			System.out.println(new DNumber().decimalbit(dao.det(matrix), 2));
		} catch (NotSquareMatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
