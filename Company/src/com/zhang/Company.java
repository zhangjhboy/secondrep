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
		//��ȡ��ǰ����
		Calendar now = Calendar.getInstance();
		//��ȡ��ǰ�·�
		int month = now.get(Calendar.MONTH) + 1;
		//д��Ա����Ϣ
		Staff staff = new Staff();
		staff.writeStaff();
		//д�뾭����Ϣ
		Manager manager = new Manager();
		manager.writeManager();
		//д��ɶ���Ϣ
		Shareholder shareholder = new Shareholder();
		shareholder.writeShareholder();
		//�������Ӫҵ��
		Company.turnover = Math.random() * 200000 + 1000000;
		
		Scanner sc = new Scanner(System.in);
		int choice1;
		
		do
		{
			//�˵�
			System.out.println("1��������\n2����ѯ\n3����ʾ���й�����Ϣ\n4���˳�");
			System.out.print("��ѡ��");
			choice1 = sc.nextInt();
			
			switch (choice1)
			{
			case 1://������
				int choice2;
				do
				{
					//�����˵�
					System.out.println("1��Ա��\n2������\n3���˳�");
					System.out.print("��ѡ��");
					choice2 = sc.nextInt();
					
					switch (choice2)
					{
					case 1:
						staff.payOffStaff();//�����ʸ�Ա��
						break;
					case 2:
						manager.payOffManager();//�����ʽ��������
						break;
					case 3:
						break;
					default:
						break;
					}
				}while (choice2 != 3);
				
				Company.expenditure();//���㹫˾����֧��
				
				//�ɶ��ֺ�
				if (month == 12)
				{
					shareholder.payOffShareholder();
				}
				break;
			case 2://��ѯ
				int choice3;
				do
				{
					//�����˵�
					System.out.println("1��Ա��\n2������\n3���˳�");
					System.out.print("��ѡ��");
					choice3 = sc.nextInt();
					
					switch (choice3)
					{
					case 1:
						staff.search();//��ѯԱ��������Ϣ
						break;
					case 2:
						manager.search();//��ѯ�����ʽ�����Ϣ
						break;
					case 3:
						break;
					default:
						break;
					}
				}while (choice3 != 3);
				break;
			case 3://��ʾ���й�����Ϣ
				System.out.println("Ա����");
				staff.print();
				System.out.println("����");
				manager.print();
				System.out.println("�ɶ���");
				shareholder.print();
				break;
			case 4://�˳�
				System.out.println("���˳���");
				break;
			default:
				break;
			}
		}while(choice1 != 4);
	}
	
	//��˾����֧��
	public static double expenditure()
	{
		//��ȡ��ǰ����
		Calendar now = Calendar.getInstance();
		//��ȡ��ǰ�·�
		int month = now.get(Calendar.MONTH) + 1;
		int i;//������
		double expenditure = 0;//����֧��
		
		//���㹤��֧��
		for (i = 0; i < Company.staff1.size(); i++)
		{
			expenditure = expenditure + Company.staff1.get(i).wage;
		}
		for (i = 0; i < Company.manager1.size(); i++)
		{
			expenditure = expenditure + Company.manager1.get(i).wage;
			expenditure = expenditure + Company.manager1.get(i).bonus;
		}
		
		//������֧�������ļ�
		try
		{
			FileReader fr = new FileReader("D:/expenditure.txt");
			BufferedReader bf = new BufferedReader(fr);
			String str;
			
			//������ǰ�Ĺ���֧��
			if ((str = bf.readLine()) != null)
			{
				expenditure = expenditure + Double.parseDouble(str);
			}
			
			bf.close();
			fr.close();
			
			
			FileWriter fw = new FileWriter("D:/expenditure.txt");
			fw.write(String.valueOf(expenditure));//д�����ڵĹ���֧��
			
			fw.close();
			
			//12�·ֺ����չ���֧��
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
	
	public static double turnover;//Ӫҵ��
	public static double profit;//����
	public static List<Staff> staff1;//Ա����Ϣ��
	public static List<Manager> manager1;//������Ϣ��
	public static List<Shareholder> shareholder1;//�ɶ���Ϣ��
	
}
