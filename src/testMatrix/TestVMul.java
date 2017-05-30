package testMatrix;

import com.example.matrixcontainer.VArray;
import com.example.matrixcontainer.VArrayDAO;

public class TestVMul {
	
	public static void main(String[] args) {
		
	    try {
			
	    	Readf readf = new Readf();
		    
		    VArray v1 = readf.readVarray("files/array4.txt", false);
		    
		    VArray v2 = readf.readVarray("files/array5.txt", true);
		    
		    System.out.println(v1);
		    
		    System.out.println(v2);
		    
		    VArrayDAO arrayDAO = new VArrayDAO();
		    
		    System.out.println(arrayDAO.mul(v1, v2));
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
