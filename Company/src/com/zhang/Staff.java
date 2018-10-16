package com.zhang;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Staff extends Person{
	public String number;//员工编号
	
	//向文件中写入员工信息
	public void writeStaff()
	{
		Company.staff1 = new ArrayList<Staff>();
		
		int i;//计数器
		String interval = "--";//间隔
		String str = System.getProperty("line.separator");//获取当前系统的换行符
		
		String[] name = {"小赵", "小王", "小张", "小李", "小何", "小钱", "小周", "小吴", "小郑", "小杨"}; 
		String[] birthday = {"19940112", "19940221", "19910314", "19900401", 
				"19910511", "19910615", "19920726", "19940812", "19960915", "19971129"};
		String[] number = {"2018001", "2018002", "2018003", "2018004", "2018005", 
				"2018006", "2018007", "2018008", "2015009", "2018010"};
		
		
		//向员工信息表中插入员工信息
		for (i = 0; i < 10; i++)
		{
			Staff staffBuffer = new Staff();
			
			staffBuffer.number = number[i];//插入编号
			staffBuffer.name = name[i];//插入姓名
			staffBuffer.birthday = birthday[i];//插入生日
			
			Company.staff1.add(staffBuffer);
		}
		
		//将员工信息表中的内容写入文件
		try
		{
			FileWriter fw = new FileWriter("D:/staffInformation.txt");
			
			for (i = 0; i < Company.staff1.size(); i++) 
			{
				fw.write(Company.staff1.get(i).number);
				fw.write(interval);
				fw.write(Company.staff1.get(i).name);
				fw.write(interval);
				fw.write(String.valueOf(Company.staff1.get(i).wage));
				fw.write(interval);
				fw.write(Company.staff1.get(i).birthday);
				fw.write(str);
			}
			
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//发工资给员工
	public void payOffStaff()
	{
		Scanner sc = new Scanner(System.in);
		int i;//计数器
		String interval = "--";//间隔
		String str = System.getProperty("line.separator");//获取当前系统的换行符
		
		//输入工资
		for (i = 0; i < Company.staff1.size(); i++)
		{
			System.out.print("编号: " + Company.staff1.get(i).number + " 姓名: " 
					+ Company.staff1.get(i).name + " 的员工的工资为：");
			Company.staff1.get(i).wage = sc.nextDouble();//输入工资
		}
		
		//将发工资后的内容再输入到记事本
		try
		{
			FileWriter fw = new FileWriter("D:/staffInformation.txt");
			
			for (i = 0; i < Company.staff1.size(); i++)
			{
				fw.write(Company.staff1.get(i).number);
				fw.write(interval);
				fw.write(Company.staff1.get(i).name);
				fw.write(interval);
				fw.write(String.valueOf(Company.staff1.get(i).wage));
				fw.write(interval);
				fw.write(Company.staff1.get(i).birthday);
				fw.write(str);
			}
			
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//查询员工工资
	public void search()
	{
		List<String> list = new ArrayList<String>();//存储从文本读出的数据
		
		try
		{
			FileReader fr = new FileReader("D:/staffInformation.txt");
			BufferedReader bf = new BufferedReader(fr);
			String str;
			
			//按行读取数据
			while ((str = bf.readLine()) != null)
			{
				list.add(str);
			}
			
			bf.close();
			fr.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//对list中的数据进行处理
		int length = list.size();//员工个数
		int i;//计数器
		String[] staffNumber = new String[length];//临时存储员工编号
		String[] staffWage = new String[length];//临时存储员工工资
		
		//将员工编号存入staffNumber中
		for (i = 0; i < length; i++)
		{
			staffNumber[i] = list.get(i).split("--", 2)[0];
			staffWage[i] = list.get(i).split("--", 4)[2];
		}
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入要查询的员工编号：");
		String number1 = sc.next();//输入要查询的编号
			
		//输出员工工资
		for (i = 0; i < length; i++)
		{
			if (number1.equals(staffNumber[i]))
			{
				System.out.print("编号：" + staffNumber[i] + " 的员工的工资为：");
				System.out.println(staffWage[i]);
				break;
			}
		}
		
		if (i == length)
		{
			System.out.println("该员工不存在。");
		}
	}
	
	//输出员工信息
	public void print()
	{
		List<String> list = new ArrayList<String>();//存储从文本读出的数据
		
		try
		{
			FileReader fr = new FileReader("D:/staffInformation.txt");
			BufferedReader bf = new BufferedReader(fr);
			String str;
			
			//按行读取数据
			while ((str = bf.readLine()) != null)
			{
				list.add(str);
			}
			
			bf.close();
			fr.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//对list中的数据进行处理
		int length = list.size();//员工个数
		int i;//计数器
		String[] staffNumber = new String[length];//临时存储员工编号
		String[] staffWage = new String[length];//临时存储员工工资
		
		//将员工编号存入staffNumber中
		for (i = 0; i < length; i++)
		{
			staffNumber[i] = list.get(i).split("--", 2)[0];
			staffWage[i] = list.get(i).split("--", 4)[2];
		}
		
		//输出
		for (i = 0; i < length; i++)
		{
			System.out.print("编号：" + staffNumber[i] + " 的员工的工资为：");
			System.out.println(staffWage[i]);
		}
	}

}
