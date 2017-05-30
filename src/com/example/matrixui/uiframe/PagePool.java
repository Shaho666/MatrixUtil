package com.example.matrixui.uiframe;

import com.example.matrixui.uimplement.AddSubMul;
import com.example.matrixui.uimplement.DetOfMatrix;
import com.example.matrixui.uimplement.Eigenvalue;
import com.example.matrixui.uimplement.InverseMatrix;
import com.example.matrixui.uimplement.LinearEquations;
import com.example.matrixui.uimplement.MultiplyIteratively;
import com.example.matrixui.uimplement.RankOfMatrix;
import com.example.matrixui.uimplement.SchmidtOrthogonal;
import com.example.matrixui.uimplement.Welcome;

public class PagePool {

	public static AddSubMul basics = new AddSubMul();

	public static RootPage rootPage = null;
	
	public static Welcome welcome = new Welcome();

	public static InverseMatrix inverse = new InverseMatrix();

	public static LinearEquations leq = new LinearEquations();

	public static RankOfMatrix rank = new RankOfMatrix();

	public static DetOfMatrix det = new DetOfMatrix();

	public static MultiplyIteratively muliter = new MultiplyIteratively();

	public static SchmidtOrthogonal sched = new SchmidtOrthogonal();

	public static Eigenvalue eigen = new Eigenvalue();

}
