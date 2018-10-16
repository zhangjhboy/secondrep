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
	public double shareOutBonus;//�ֺ�
	public double shares;//�ɷ�
	
	//���ı�д��ɶ���Ϣ
	public void writeShareholder()
	{
		Company.shareholder1 = new ArrayList<Shareholder>();
		
		int i;//������
		String interval = "--";//���
		double sharesSum = 0;//�ɷݺ�
		String str = System.getProperty("line.separator");//��ȡ��ǰϵͳ�Ļ��з�
		
		String[] name = {"��ɶ�", "��ɶ�", "�Źɶ�"};
		String[] birthday = {"19810206", "19821129", "19850609"};
		double[] shares = {0.22, 0.02, 0.06};
		
		//��ɶ���Ϣ���в���ɶ���Ϣ
		for (i = 0; i < 3; i++)
		{
			Shareholder shareholderBuffer = new Shareholder();
			
			shareholderBuffer.name = name[i];//��������
			shareholderBuffer.birthday = birthday[i];//��������
			shareholderBuffer.shares = shares[i];//����ɷ�
			sharesSum = sharesSum + shares[i];
			
			Company.shareholder1.add(shareholderBuffer);
		}
		
		//�ж��ܹɷ��Ƿ񳬳�
		if (Math.abs(sharesSum - 1) < 1e-6)
		{
			System.out.println("���󣺹ɷ��ܺͳ���100%");
			return;
		}
		
		//���ɶ���Ϣ���е�����д���ļ�
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
	
	//�ɶ��ֺ�
	public void payOffShareholder()
	{
		Scanner sc = new Scanner(System.in);
		int i;//������
		String interval = "--";//���
		String str = System.getProperty("line.separator");//��ȡ��ǰϵͳ�Ļ��з�
		DecimalFormat twoDigits = new DecimalFormat("0.00");//�ֺ쾫ȷ��Ϊ0.01
		
		double expenditure = Company.expenditure();//����֧��
		
		Company.profit = Company.turnover - expenditure;//���㹫˾����
		double money = Company.profit * 0.1;//�����ɶ���Ǯ
		
		for (i = 0; i < Company.manager1.size(); i++)
		{
			Company.shareholder1.get(i).shareOutBonus = money * Company.shareholder1.get(i).shares;
		}
		
		//���ֺ������������뵽���±�
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
	
	//����ɶ���Ϣ
	public void print()
	{
		List<String> list = new ArrayList<String>();//�洢���ı�����������
		
		try
		{
			FileReader fr = new FileReader("D:/shareholderInformation.txt");
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
		int length = list.size();//�ɶ�����
		int i;//������
		String[] shareholderName = new String[length];//��ʱ�洢�ɶ�����
		String[] shareholderShareOutBonus = new String[length];//��ʱ�洢�ɶ��ֺ�
		
		//���ɶ���������shareholderName��
		for (i = 0; i < length; i++)
		{
			shareholderName[i] = list.get(i).split("--", 2)[0];
			shareholderShareOutBonus[i]= list.get(i).split("--", 4)[2];
		}
		
		//���
		for (i = 0; i < length; i++)
		{
			System.out.print("������" + shareholderName[i] + " �Ĺɶ��ķֺ�Ϊ��");
			System.out.println(shareholderShareOutBonus[i]);
		}
	}


}
