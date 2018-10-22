package com.zhang;

import java.text.DecimalFormat;

public abstract class Vehicle {
	protected String transportName;//交通方式名称
	protected double arrivalTime;//到车站（机场）时间（小时）
	protected double returnTime;//从车站（机场）返回时间（小时）
	protected double takeTicketTime;//取票时间（小时）
	protected double securityTime;//安检时间（小时）
	protected double waitingTime;//候车时间（小时）
	protected double speed;//车速（公里/小时）
	protected double price;//单价（元/公里）
	
	public abstract double[] timeAndPrice(double distance);//计算消耗时间和单价
	
	//输出时间价格
	public void print(double distance)
	{
		double[] timeMoney = new double[2];
		
		DecimalFormat twoDigits = new DecimalFormat("0.00");//精确度定为0.01
		timeMoney = this.timeAndPrice(distance);
		
		String time = twoDigits.format(timeMoney[0]);
		String money = twoDigits.format(timeMoney[1]);
		
		System.out.println("耗时：" + time + "小时" + "\n价格：" + money + "元");//输出
		
	}
	

}
