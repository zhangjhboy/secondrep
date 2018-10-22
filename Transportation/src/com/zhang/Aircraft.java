package com.zhang;

public class Aircraft extends Vehicle{
	public Aircraft()
	{
		transportName = "Aircraft";
		arrivalTime = 0.43;
		returnTime = 0.41;
		takeTicketTime = 0.33;
		securityTime = 0.08;
		waitingTime = 0.67;
		speed = 800;//公里/小时
		price = 0.75;//元/公里
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
