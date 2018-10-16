package com.zhang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager extends Person{
	public double bonus;//当月奖金
	
	//向文本写入经理信息
	public void writeManager()
	{
		Company.manager1 = new ArrayList<Manager>();
		
		int i;//计数器
		String interval = "--";//间隔
		String str = System.getProperty("line.separator");//获取当前系统的换行符
		
		String[] name = {"王总", "张总", "李总"};
		String[] birthday = {"19810206", "19821129", "19850609"};
		
		//向经理信息表中插入经理信息
		for (i = 0; i < 3; i++)
		{
			Manager managerBuffer = new Manager();
			
			managerBuffer.name = name[i];//插入姓名
			managerBuffer.birthday = birthday[i];//插入生日
			
			Company.manager1.add(managerBuffer);
		}
		
		//将经理信息表中的内容写入文件
		try
		{
			FileWriter fw = new FileWriter("D:/managerInformation.txt");
			
			for (i = 0; i < Company.manager1.size(); i++) 
			{
				fw.write(Company.manager1.get(i).name);
				fw.write(interval);
				fw.write(String.valueOf(Company.manager1.get(i).wage));
				fw.write(interval);
				fw.write(String.valueOf(Company.manager1.get(i).bonus));
				fw.write(interval);
				fw.write(Company.manager1.get(i).birthday);
				fw.write(str);
			}
			
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//发工资给经理
	public void payOffManager()
	{
		Scanner sc = new Scanner(System.in);
		int i;//计数器
		String interval = "--";//间隔
		String str = System.getProperty("line.separator");//获取当前系统的换行符
		
		//输入工资
		for (i = 0; i < Company.manager1.size(); i++)
		{
			System.out.print("姓名: " + Company.manager1.get(i).name + " 的经理的工资为：");
			Company.manager1.get(i).wage = sc.nextDouble();//输入工资
			System.out.print("奖金为：");
			Company.manager1.get(i).bonus = sc.nextDouble();//输入当月奖金
		}
		
		//将发工资后的内容再输入到记事本
		try
		{
			FileWriter fw = new FileWriter("D:/managerInformation.txt");
					
			for (i = 0; i < Company.manager1.size(); i++)
			{
				fw.write(Company.manager1.get(i).name);
				fw.write(interval);
				fw.write(String.valueOf(Company.manager1.get(i).wage));
				fw.write(interval);
				fw.write(String.valueOf(Company.manager1.get(i).bonus));
				fw.write(interval);
				fw.write(Company.manager1.get(i).birthday);
				fw.write(str);
			}
					
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//查询经理工资和奖金
	public void search()
	{
		List<String> list = new ArrayList<String>();//存储从文本读出的数据
		
		try
		{
			FileReader fr = new FileReader("D:/managerInformation.txt");
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
		int length = list.size();//经理个数
		int i;//计数器
		String[] managerName = new String[length];//临时存储经理姓名
		String[] managerWage = new String[length];//临时存储经理工资
		String[] managerBonus = new String[length];//临时存储经理奖金
		
		//将经理姓名存入managerName中
		for (i = 0; i < length; i++)
		{
			managerName[i] = list.get(i).split("--", 2)[0];
			managerWage[i] = list.get(i).split("--", 4)[1];
			managerBonus[i]= list.get(i).split("--", 4)[2];
		}
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入要查询的经理姓名：");
		String name1 = sc.next();//输入要查询的姓名
			
		//输出经理工资奖金
		for (i = 0; i < length; i++)
		{
			if (name1.equals(managerName[i]))
			{
				System.out.print("姓名：" + managerName[i] + " 的经理的工资为：");
				System.out.println(managerWage[i]);
				System.out.print("奖金为：");
				System.out.println(managerBonus[i]);
				break;
			}
		}
		
		if (i == length)
		{
			System.out.println("该经理不存在。");
		}
	}
	
	//输出经理信息
	public void print()
	{
		List<String> list = new ArrayList<String>();//存储从文本读出的数据
		
		try
		{
			FileReader fr = new FileReader("D:/managerInformation.txt");
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
		int length = list.size();//经理个数
		int i;//计数器
		String[] managerName = new String[length];//临时存储经理姓名
		String[] managerWage = new String[length];//临时存储经理工资
		String[] managerBonus = new String[length];//临时存储经理奖金
		
		//将经理姓名存入managerName中
		for (i = 0; i < length; i++)
		{
			managerName[i] = list.get(i).split("--", 2)[0];
			managerWage[i] = list.get(i).split("--", 4)[1];
			managerBonus[i]= list.get(i).split("--", 4)[2];
		}
		
		//输出
		for (i = 0; i < length; i++)
		{
			System.out.print("姓名：" + managerName[i] + " 的经理的工资为：");
			System.out.println(managerWage[i]);
			System.out.print("奖金为：");
			System.out.println(managerBonus[i]);
		}
	}

}
