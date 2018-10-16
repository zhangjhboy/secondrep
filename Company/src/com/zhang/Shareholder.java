package com.zhang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Shareholder extends Person{
	public double shareOutBonus;//分红
	public double shares;//股份
	
	//向文本写入股东信息
	public void writeShareholder()
	{
		Company.shareholder1 = new ArrayList<Shareholder>();
		
		int i;//计数器
		String interval = "--";//间隔
		double sharesSum = 0;//股份和
		String str = System.getProperty("line.separator");//获取当前系统的换行符
		
		String[] name = {"马股东", "李股东", "张股东"};
		String[] birthday = {"19810206", "19821129", "19850609"};
		double[] shares = {0.22, 0.02, 0.06};
		
		//向股东信息表中插入股东信息
		for (i = 0; i < 3; i++)
		{
			Shareholder shareholderBuffer = new Shareholder();
			
			shareholderBuffer.name = name[i];//插入姓名
			shareholderBuffer.birthday = birthday[i];//插入生日
			shareholderBuffer.shares = shares[i];//插入股份
			sharesSum = sharesSum + shares[i];
			
			Company.shareholder1.add(shareholderBuffer);
		}
		
		//判断总股份是否超出
		if (Math.abs(sharesSum - 1) < 1e-6)
		{
			System.out.println("错误：股份总和超过100%");
			return;
		}
		
		//将股东信息表中的内容写入文件
		try
		{
			FileWriter fw = new FileWriter("D:/shareholderInformation.txt");
			
			for (i = 0; i < Company.shareholder1.size(); i++) 
			{
				fw.write(Company.shareholder1.get(i).name);
				fw.write(interval);
				fw.write(String.valueOf(Company.shareholder1.get(i).shares));
				fw.write(interval);
				fw.write(String.valueOf(Company.shareholder1.get(i).shareOutBonus));
				fw.write(interval);
				fw.write(Company.shareholder1.get(i).birthday);
				fw.write(str);
			}
			
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//股东分红
	public void payOffShareholder()
	{
		Scanner sc = new Scanner(System.in);
		int i;//计数器
		String interval = "--";//间隔
		String str = System.getProperty("line.separator");//获取当前系统的换行符
		DecimalFormat twoDigits = new DecimalFormat("0.00");//分红精确度为0.01
		
		double expenditure = Company.expenditure();//工资支出
		
		Company.profit = Company.turnover - expenditure;//计算公司利润
		double money = Company.profit * 0.1;//发给股东的钱
		
		for (i = 0; i < Company.manager1.size(); i++)
		{
			Company.shareholder1.get(i).shareOutBonus = money * Company.shareholder1.get(i).shares;
		}
		
		//将分红后的内容再输入到记事本
		try
		{
			FileWriter fw = new FileWriter("D:/shareholderInformation.txt");
					
			for (i = 0; i < Company.shareholder1.size(); i++)
			{
				fw.write(Company.shareholder1.get(i).name);
				fw.write(interval);
				fw.write(String.valueOf(Company.shareholder1.get(i).shares));
				fw.write(interval);
				fw.write(String.valueOf(twoDigits.format(Company.shareholder1.get(i).shareOutBonus)));
				fw.write(interval);
				fw.write(Company.shareholder1.get(i).birthday);
				fw.write(str);
			}
					
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//输出股东信息
	public void print()
	{
		List<String> list = new ArrayList<String>();//存储从文本读出的数据
		
		try
		{
			FileReader fr = new FileReader("D:/shareholderInformation.txt");
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
		int length = list.size();//股东个数
		int i;//计数器
		String[] shareholderName = new String[length];//临时存储股东姓名
		String[] shareholderShareOutBonus = new String[length];//临时存储股东分红
		
		//将股东姓名存入shareholderName中
		for (i = 0; i < length; i++)
		{
			shareholderName[i] = list.get(i).split("--", 2)[0];
			shareholderShareOutBonus[i]= list.get(i).split("--", 4)[2];
		}
		
		//输出
		for (i = 0; i < length; i++)
		{
			System.out.print("姓名：" + shareholderName[i] + " 的股东的分红为：");
			System.out.println(shareholderShareOutBonus[i]);
		}
	}


}
