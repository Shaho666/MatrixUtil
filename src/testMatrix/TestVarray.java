package testMatrix;

import com.example.matrixcontainer.VArray;

public class TestVarray {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		VArray v1 = readf.readVarray("files/array1.txt");
		VArray v2 = readf.readVarray("files/array2.txt");
		VArray v3 = readf.readVarray("files/array3.txt");
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		
		System.out.println(v1.isnull());
		System.out.println(v2.isnull());
		System.out.println(v3.isnull());
		
	}
	
}
