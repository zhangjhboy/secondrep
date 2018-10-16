package com.zhang;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Staff extends Person{
	public String number;//Ա�����
	
	//���ļ���д��Ա����Ϣ
	public void writeStaff()
	{
		Company.staff1 = new ArrayList<Staff>();
		
		int i;//������
		String interval = "--";//���
		String str = System.getProperty("line.separator");//��ȡ��ǰϵͳ�Ļ��з�
		
		String[] name = {"С��", "С��", "С��", "С��", "С��", "СǮ", "С��", "С��", "С֣", "С��"}; 
		String[] birthday = {"19940112", "19940221", "19910314", "19900401", 
				"19910511", "19910615", "19920726", "19940812", "19960915", "19971129"};
		String[] number = {"2018001", "2018002", "2018003", "2018004", "2018005", 
				"2018006", "2018007", "2018008", "2015009", "2018010"};
		
		
		//��Ա����Ϣ���в���Ա����Ϣ
		for (i = 0; i < 10; i++)
		{
			Staff staffBuffer = new Staff();
			
			staffBuffer.number = number[i];//������
			staffBuffer.name = name[i];//��������
			staffBuffer.birthday = birthday[i];//��������
			
			Company.staff1.add(staffBuffer);
		}
		
		//��Ա����Ϣ���е�����д���ļ�
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
	
	//�����ʸ�Ա��
	public void payOffStaff()
	{
		Scanner sc = new Scanner(System.in);
		int i;//������
		String interval = "--";//���
		String str = System.getProperty("line.separator");//��ȡ��ǰϵͳ�Ļ��з�
		
		//���빤��
		for (i = 0; i < Company.staff1.size(); i++)
		{
			System.out.print("���: " + Company.staff1.get(i).number + " ����: " 
					+ Company.staff1.get(i).name + " ��Ա���Ĺ���Ϊ��");
			Company.staff1.get(i).wage = sc.nextDouble();//���빤��
		}
		
		//�������ʺ�����������뵽���±�
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
	
	//��ѯԱ������
	public void search()
	{
		List<String> list = new ArrayList<String>();//�洢���ı�����������
		
		try
		{
			FileReader fr = new FileReader("D:/staffInformation.txt");
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
		int length = list.size();//Ա������
		int i;//������
		String[] staffNumber = new String[length];//��ʱ�洢Ա�����
		String[] staffWage = new String[length];//��ʱ�洢Ա������
		
		//��Ա����Ŵ���staffNumber��
		for (i = 0; i < length; i++)
		{
			staffNumber[i] = list.get(i).split("--", 2)[0];
			staffWage[i] = list.get(i).split("--", 4)[2];
		}
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������Ҫ��ѯ��Ա����ţ�");
		String number1 = sc.next();//����Ҫ��ѯ�ı��
			
		//���Ա������
		for (i = 0; i < length; i++)
		{
			if (number1.equals(staffNumber[i]))
			{
				System.out.print("��ţ�" + staffNumber[i] + " ��Ա���Ĺ���Ϊ��");
				System.out.println(staffWage[i]);
				break;
			}
		}
		
		if (i == length)
		{
			System.out.println("��Ա�������ڡ�");
		}
	}
	
	//���Ա����Ϣ
	public void print()
	{
		List<String> list = new ArrayList<String>();//�洢���ı�����������
		
		try
		{
			FileReader fr = new FileReader("D:/staffInformation.txt");
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
		int length = list.size();//Ա������
		int i;//������
		String[] staffNumber = new String[length];//��ʱ�洢Ա�����
		String[] staffWage = new String[length];//��ʱ�洢Ա������
		
		//��Ա����Ŵ���staffNumber��
		for (i = 0; i < length; i++)
		{
			staffNumber[i] = list.get(i).split("--", 2)[0];
			staffWage[i] = list.get(i).split("--", 4)[2];
		}
		
		//���
		for (i = 0; i < length; i++)
		{
			System.out.print("��ţ�" + staffNumber[i] + " ��Ա���Ĺ���Ϊ��");
			System.out.println(staffWage[i]);
		}
	}

}
