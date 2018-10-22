package com.zhang;

public class HighSpeedRail extends Vehicle{
	public HighSpeedRail()
	{
		transportName = "High-speed rail";
		arrivalTime = 0.42;
		returnTime = 0.41;
		takeTicketTime = 0.33;
		securityTime = 0.03;
		waitingTime = 0.5;
		speed = 300;//公里/小时
		price = 0.45;//元/公里
	}
	
	//计算消耗时间和价格
	public double[] timeAndPrice(double distance)
	{
		double[] timeMoney = new double[2];//0存耗时、1存所需钱
		
		timeMoney[0] = distance / speed + arrivalTime + returnTime
				+ takeTicketTime + securityTime + waitingTime;//计算时间
		timeMoney[1] = distance * price;//计算价格
		
		return timeMoney;
	}

}
