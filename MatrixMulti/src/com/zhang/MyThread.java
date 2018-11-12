package com.zhang;

public class MyThread extends Thread{
	public void run()
	{
		Matrix.assignment(Matrix.matrix1);
		Matrix.multiplication(Matrix.matrix1, Matrix.matrix2);
	}

}
