package com.zhang;

public class Car extends Vehicle{
	public Car()
	{
		transportName = "Car";
		arrivalTime = 0.25;
		returnTime = 0.41;
		takeTicketTime = 0.1;
		securityTime = 0.03;
		waitingTime = 0.17;
		speed = 80;//����/Сʱ
		price = 0.32;//Ԫ/����
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
