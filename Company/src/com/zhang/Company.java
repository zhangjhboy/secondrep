package com.zhang;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Calendar;

public class Company {
	public static void main(String[] args)
	{
		//获取当前日期
		Calendar now = Calendar.getInstance();
		//获取当前月份
		int month = now.get(Calendar.MONTH) + 1;
		//写入员工信息
		Staff staff = new Staff();
		staff.writeStaff();
		//写入经理信息
		Manager manager = new Manager();
		manager.writeManager();
		//写入股东信息
		Shareholder shareholder = new Shareholder();
		shareholder.writeShareholder();
		//随机生成营业额
		Company.turnover = Math.random() * 200000 + 1000000;
		
		Scanner sc = new Scanner(System.in);
		int choice1;
		
		do
		{
			//菜单
			System.out.println("1、发工资\n2、查询\n3、显示所有工资信息\n4、退出");
			System.out.print("请选择：");
			choice1 = sc.nextInt();
			
			switch (choice1)
			{
			case 1://发工资
				int choice2;
				do
				{
					//二级菜单
					System.out.println("1、员工\n2、经理\n3、退出");
					System.out.print("请选择：");
					choice2 = sc.nextInt();
					
					switch (choice2)
					{
					case 1:
						staff.payOffStaff();//发工资给员工
						break;
					case 2:
						manager.payOffManager();//发工资奖金给经理
						break;
					case 3:
						break;
					default:
						break;
					}
				}while (choice2 != 3);
				
				Company.expenditure();//计算公司工资支出
				
				//股东分红
				if (month == 12)
				{
					shareholder.payOffShareholder();
				}
				break;
			case 2://查询
				int choice3;
				do
				{
					//二级菜单
					System.out.println("1、员工\n2、经理\n3、退出");
					System.out.print("请选择：");
					choice3 = sc.nextInt();
					
					switch (choice3)
					{
					case 1:
						staff.search();//查询员工工资信息
						break;
					case 2:
						manager.search();//查询经理工资奖金信息
						break;
					case 3:
						break;
					default:
						break;
					}
				}while (choice3 != 3);
				break;
			case 3://显示所有工资信息
				System.out.println("员工：");
				staff.print();
				System.out.println("经理：");
				manager.print();
				System.out.println("股东：");
				shareholder.print();
				break;
			case 4://退出
				System.out.println("已退出！");
				break;
			default:
				break;
			}
		}while(choice1 != 4);
	}
	
	//公司工资支出
	public static double expenditure()
	{
		//获取当前日期
		Calendar now = Calendar.getInstance();
		//获取当前月份
		int month = now.get(Calendar.MONTH) + 1;
		int i;//计数器
		double expenditure = 0;//工资支出
		
		//计算工资支出
		for (i = 0; i < Company.staff1.size(); i++)
		{
			expenditure = expenditure + Company.staff1.get(i).wage;
		}
		for (i = 0; i < Company.manager1.size(); i++)
		{
			expenditure = expenditure + Company.manager1.get(i).wage;
			expenditure = expenditure + Company.manager1.get(i).bonus;
		}
		
		//将工资支出存入文件
		try
		{
			FileReader fr = new FileReader("D:/expenditure.txt");
			BufferedReader bf = new BufferedReader(fr);
			String str;
			
			//读出以前的工资支出
			if ((str = bf.readLine()) != null)
			{
				expenditure = expenditure + Double.parseDouble(str);
			}
			
			bf.close();
			fr.close();
			
			
			FileWriter fw = new FileWriter("D:/expenditure.txt");
			fw.write(String.valueOf(expenditure));//写入现在的工资支出
			
			fw.close();
			
			//12月分红后清空工资支出
			if (month == 12)
			{
				FileWriter fw1 = new FileWriter("D:/expenditure.txt");
				fw1.write("");
				
				fw1.close();
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return expenditure;
		
	}
	
	public static double turnover;//营业额
	public static double profit;//利润
	public static List<Staff> staff1;//员工信息表
	public static List<Manager> manager1;//经理信息表
	public static List<Shareholder> shareholder1;//股东信息表
	
}
