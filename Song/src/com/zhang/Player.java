package com.zhang;

import java.util.Scanner;

public class Player {
	public boolean addSong()//���
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�����������");
		String songName1 = sc.next();//������
		System.out.print("������ԭ����");
		String songer1 = sc.next();//����ԭ��
		System.out.print("���������ʱ����");
		double time1 = sc.nextDouble();//����ʱ��
		Song s = new Song(songName1, songer1, time1);
		Master.listSong.add(s);//������ĸ������뵽�����б�
		return true;
	}

}
