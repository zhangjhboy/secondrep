package com.zhang;

import java.util.Scanner;

public class Control {
	public static void main(String[] args)
	{
		Car car = new Car();
		HighSpeedRail highSpeedRail = new HighSpeedRail();
		Aircraft aircraft = new Aircraft();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����������أ�");
		String placeOfDeparture = sc.nextLine();
		System.out.print("������Ŀ�ĵأ�");
		String destination = sc.nextLine();
		System.out.print("��������룺");
		double distance = sc.nextDouble();
		
		System.out.println("������");
		car.print(distance);
		System.out.println("������");
		highSpeedRail.print(distance);
		System.out.println("�ɻ���");
		aircraft.print(distance);
	}

}
