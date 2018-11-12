package com.zhang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Matrix {
	//matrix1的一维分别为1000，500,125,62,31
	public static int[][] matrix1 = new int[125][1000];
	public static int[][] matrix2 = new int[1000][1000];
	
	public static void assignment(int[][] a)
	{
		int i;
		int j;
		
		for (i = 0; i < a.length; i++)
		{
			for (j = 0; j < a[0].length; j++)
			{
				int b = (int)(Math.random() * 40);
				a[i][j] = b;
			}
		}
	}
	
	public static int[][] multiplication(int[][] a, int[][] b)
	{
		if (a[0].length != b.length)
			return null;
		
		int[][] c = new int[a.length][b[0].length];
		int i;
		int j;
		int k;
		
		long startTime = System.currentTimeMillis();
		
		for (i = 0; i < a.length; i++)
		{
			for (j = 0; j < b[0].length; j++)
			{
				for (k = 0; k < a[0].length; k++)
				{
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		return c;
	}
	
	public static void main(String[] args)
	{
		Matrix.assignment(Matrix.matrix2);
		
		//Matrix.multiplication(Matrix.matrix1, Matrix.matrix2);
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);//2,8,16,32
		for (int i = 0; i < 8; i++)
		{
			MyThread thread = new MyThread();
			fixedThreadPool.execute(thread);
		}
		fixedThreadPool.shutdown();
	}

}
