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
		speed = 800;//����/Сʱ
		price = 0.75;//Ԫ/����
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
