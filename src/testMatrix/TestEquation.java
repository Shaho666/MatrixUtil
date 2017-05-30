package testMatrix;

import com.example.matrixcontainer.Equation;
import com.example.matrixcontainer.EquationDAO;
import com.example.matrixcontainer.Matrix;

public class TestEquation {
	
	public static void main(String[] args) {
		
		Readf readf = new Readf();
		
		Matrix m1 = readf.readMatrix("files/function4.txt");
		
		Equation function = new EquationDAO().solvefunction(m1);
		
		System.out.println(function);
		
	}
	
}
