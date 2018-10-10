package com.zhang;

import java.util.Scanner;

public class SongDrive {
	public Master master;//主持人
	public Player player;//点歌的
	public SongDrive()//初始化master和player
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
			System.out.println("1 点歌\n2 主持人\n3 退出");
			System.out.print("请选择：");
			i = in.nextInt();
			switch (i)
			{
			case 1://用户点歌
				int i1;
				do
				{
					songDrive.player.addSong();
					System.out.println("1 继续点歌\n2 退出");
					System.out.print("请选择：");
					i1 = in.nextInt();
				}while(i1 != 2);
				break;
			case 2://主持人播放歌曲
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
		System.out.println("已退出！");
	}

}
