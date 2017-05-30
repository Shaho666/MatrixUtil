package testMatrix;

import com.example.matrixcontainer.VArray;

public class TestNorm_2 {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		VArray array = readf.readVarray("files/array1.txt");
		
		System.out.println(array);
		
		System.out.println(array.norm_2());
		
	}
	
}
