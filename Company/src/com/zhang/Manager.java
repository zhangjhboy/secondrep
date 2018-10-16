package com.zhang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager extends Person{
	public double bonus;//���½���
	
	//���ı�д�뾭����Ϣ
	public void writeManager()
	{
		Company.manager1 = new ArrayList<Manager>();
		
		int i;//������
		String interval = "--";//���
		String str = System.getProperty("line.separator");//��ȡ��ǰϵͳ�Ļ��з�
		
		String[] name = {"����", "����", "����"};
		String[] birthday = {"19810206", "19821129", "19850609"};
		
		//������Ϣ���в��뾭����Ϣ
		for (i = 0; i < 3; i++)
		{
			Manager managerBuffer = new Manager();
			
			managerBuffer.name = name[i];//��������
			managerBuffer.birthday = birthday[i];//��������
			
			Company.manager1.add(managerBuffer);
		}
		
		//��������Ϣ���е�����д���ļ�
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
	
	//�����ʸ�����
	public void payOffManager()
	{
		Scanner sc = new Scanner(System.in);
		int i;//������
		String interval = "--";//���
		String str = System.getProperty("line.separator");//��ȡ��ǰϵͳ�Ļ��з�
		
		//���빤��
		for (i = 0; i < Company.manager1.size(); i++)
		{
			System.out.print("����: " + Company.manager1.get(i).name + " �ľ���Ĺ���Ϊ��");
			Company.manager1.get(i).wage = sc.nextDouble();//���빤��
			System.out.print("����Ϊ��");
			Company.manager1.get(i).bonus = sc.nextDouble();//���뵱�½���
		}
		
		//�������ʺ�����������뵽���±�
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
	
	
	//��ѯ�����ʺͽ���
	public void search()
	{
		List<String> list = new ArrayList<String>();//�洢���ı�����������
		
		try
		{
			FileReader fr = new FileReader("D:/managerInformation.txt");
			BufferedReader bf = new BufferedReader(fr);
			String str;
			
			//���ж�ȡ����
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
		
		//��list�е����ݽ��д���
		int length = list.size();//�������
		int i;//������
		String[] managerName = new String[length];//��ʱ�洢��������
		String[] managerWage = new String[length];//��ʱ�洢������
		String[] managerBonus = new String[length];//��ʱ�洢������
		
		//��������������managerName��
		for (i = 0; i < length; i++)
		{
			managerName[i] = list.get(i).split("--", 2)[0];
			managerWage[i] = list.get(i).split("--", 4)[1];
			managerBonus[i]= list.get(i).split("--", 4)[2];
		}
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������Ҫ��ѯ�ľ���������");
		String name1 = sc.next();//����Ҫ��ѯ������
			
		//��������ʽ���
		for (i = 0; i < length; i++)
		{
			if (name1.equals(managerName[i]))
			{
				System.out.print("������" + managerName[i] + " �ľ���Ĺ���Ϊ��");
				System.out.println(managerWage[i]);
				System.out.print("����Ϊ��");
				System.out.println(managerBonus[i]);
				break;
			}
		}
		
		if (i == length)
		{
			System.out.println("�þ������ڡ�");
		}
	}
	
	//���������Ϣ
	public void print()
	{
		List<String> list = new ArrayList<String>();//�洢���ı�����������
		
		try
		{
			FileReader fr = new FileReader("D:/managerInformation.txt");
			BufferedReader bf = new BufferedReader(fr);
			String str;
			
			//���ж�ȡ����
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
		
		//��list�е����ݽ��д���
		int length = list.size();//�������
		int i;//������
		String[] managerName = new String[length];//��ʱ�洢��������
		String[] managerWage = new String[length];//��ʱ�洢������
		String[] managerBonus = new String[length];//��ʱ�洢������
		
		//��������������managerName��
		for (i = 0; i < length; i++)
		{
			managerName[i] = list.get(i).split("--", 2)[0];
			managerWage[i] = list.get(i).split("--", 4)[1];
			managerBonus[i]= list.get(i).split("--", 4)[2];
		}
		
		//���
		for (i = 0; i < length; i++)
		{
			System.out.print("������" + managerName[i] + " �ľ���Ĺ���Ϊ��");
			System.out.println(managerWage[i]);
			System.out.print("����Ϊ��");
			System.out.println(managerBonus[i]);
		}
	}

}
