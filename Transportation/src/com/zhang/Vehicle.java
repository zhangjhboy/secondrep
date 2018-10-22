package com.zhang;

import java.text.DecimalFormat;

public abstract class Vehicle {
	protected String transportName;//��ͨ��ʽ����
	protected double arrivalTime;//����վ��������ʱ�䣨Сʱ��
	protected double returnTime;//�ӳ�վ������������ʱ�䣨Сʱ��
	protected double takeTicketTime;//ȡƱʱ�䣨Сʱ��
	protected double securityTime;//����ʱ�䣨Сʱ��
	protected double waitingTime;//��ʱ�䣨Сʱ��
	protected double speed;//���٣�����/Сʱ��
	protected double price;//���ۣ�Ԫ/���
	
	public abstract double[] timeAndPrice(double distance);//��������ʱ��͵���
	
	//���ʱ��۸�
	public void print(double distance)
	{
		double[] timeMoney = new double[2];
		
		DecimalFormat twoDigits = new DecimalFormat("0.00");//��ȷ�ȶ�Ϊ0.01
		timeMoney = this.timeAndPrice(distance);
		
		String time = twoDigits.format(timeMoney[0]);
		String money = twoDigits.format(timeMoney[1]);
		
		System.out.println("��ʱ��" + time + "Сʱ" + "\n�۸�" + money + "Ԫ");//���
		
	}
	

}
