package testMatrix;

import com.example.matrixcontainer.VArray;
import com.example.matrixcontainer.VArrayDAO;

public class TestVSub {
	
	public static void main(String[] args) {
		
		try {
			
			Readf readf = new Readf();
			
			VArray v1 = readf.readVarray("files/array4.txt");
			
			VArray v2 = readf.readVarray("files/array5.txt");
			
			VArrayDAO arrayDAO = new VArrayDAO();
			
			System.out.println(v1);
			
			System.out.println(v2);
			
			System.out.println(arrayDAO.sub(v1, v2));
			
		} catch (Exception e) {

            e.printStackTrace();
			
		}
		
	}
	
}
