package com.zhang;

import java.util.Scanner;

public class SongDrive {
	public Master master;//������
	public Player player;//����
	public SongDrive()//��ʼ��master��player
	{
		master = new Master();
		player = new Player();
	}
	
	public static void main(String[] args)
	{
		SongDrive songDrive = new SongDrive();
		Scanner in = new Scanner(System.in);
		int i;
		do
		{
			System.out.println("1 ���\n2 ������\n3 �˳�");
			System.out.print("��ѡ��");
			i = in.nextInt();
			switch (i)
			{
			case 1://�û����
				int i1;
				do
				{
					songDrive.player.addSong();
					System.out.println("1 �������\n2 �˳�");
					System.out.print("��ѡ��");
					i1 = in.nextInt();
				}while(i1 != 2);
				break;
			case 2://�����˲��Ÿ���
				while (songDrive.master.play())
				{
					
				}
				
				break;
			case 3:
				break;
			default:
				break;
			}
				
		}while(i != 3);
		System.out.println("���˳���");
	}

}
