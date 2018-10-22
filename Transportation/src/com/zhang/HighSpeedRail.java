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
		speed = 300;//����/Сʱ
		price = 0.45;//Ԫ/����
	}
	
	//��������ʱ��ͼ۸�
	public double[] timeAndPrice(double distance)
	{
		double[] timeMoney = new double[2];//0���ʱ��1������Ǯ
		
		timeMoney[0] = distance / speed + arrivalTime + returnTime
				+ takeTicketTime + securityTime + waitingTime;//����ʱ��
		timeMoney[1] = distance * price;//����۸�
		
		return timeMoney;
	}

}
