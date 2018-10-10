package com.text;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SpeedText {
	public static void main(String[] args)
	{
		final int N = 1000000;
		//ArrayList����
		List<String> list = new ArrayList<String>();
		int i;
		long startTime = System.nanoTime();
		for (i = 1; i <= N; i++)
		{
			list.add("*");//�����ݽṹ���������
			if (i % 50000 == 0)
			{
				long endTime = System.nanoTime();
				System.out.println((i / 50000) + "  " + (endTime - startTime));
			}
		}
		//HashSet����
/*		Set<String> set = new HashSet<String>();
		int i;
		long startTime = System.currentTimeMillis();
		for (i = 0; i < N; i++)
		{
			set.add("*");
			if (i % 50000 == 0)
			{
				long endTime = System.nanoTime();
				System.out.println((i / 50000) + "  " + (endTime - startTime));
			}
		}*/
		
		//TreeSet����
/*		Set<String> set = new TreeSet<String>();
		int i;
		long startTime = System.nanoTime();
		for (i = 1; i <= N; i++)
		{
			list.add("*");
			if (i % 50000 == 0)
			{
				long endTime = System.nanoTime();
				System.out.println((i / 50000) + "  " + (endTime - startTime));
			}
		}*/
	}

}
