package com.zhang;

import java.util.Scanner;

public class Player {
	public boolean addSong()//点歌
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入歌名：");
		String songName1 = sc.next();//歌曲名
		System.out.print("请输入原唱：");
		String songer1 = sc.next();//歌曲原唱
		System.out.print("请输入歌曲时长：");
		double time1 = sc.nextDouble();//歌曲时长
		Song s = new Song(songName1, songer1, time1);
		Master.listSong.add(s);//将输入的歌曲加入到歌曲列表
		return true;
	}

}
