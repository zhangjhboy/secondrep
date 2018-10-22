package com.zhang;

import java.util.Scanner;

public class Control {
	public static void main(String[] args)
	{
		Car car = new Car();
		HighSpeedRail highSpeedRail = new HighSpeedRail();
		Aircraft aircraft = new Aircraft();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入出发地：");
		String placeOfDeparture = sc.nextLine();
		System.out.print("请输入目的地：");
		String destination = sc.nextLine();
		System.out.print("请输入距离：");
		double distance = sc.nextDouble();
		
		System.out.println("汽车：");
		car.print(distance);
		System.out.println("高铁：");
		highSpeedRail.print(distance);
		System.out.println("飞机：");
		aircraft.print(distance);
	}

}
