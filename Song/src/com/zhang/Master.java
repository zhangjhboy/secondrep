package com.zhang;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Master {
	public static List<Song> listSong;//歌曲列表
	public Master()//构造函数，初始化list
	{
		listSong = new ArrayList<Song>();
	}
	public boolean play()//播放歌曲
	{
		if (listSong.isEmpty())//判断歌曲列表是否为空
		{
			System.out.println("无歌曲播放...");
			return false;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("是否指定歌曲播放： y/n");
		String s1 = in.next();
		char c = s1.charAt(0);//输入是否指定歌曲播放
		//指定歌曲播放
		if ('y' == c)
		{
			int i;
			for (i = 0; i < listSong.size(); i++)//输出歌曲列表
			{
				System.out.println((i + 1) + " " + listSong.get(i).songName + "  " + listSong.get(i).songer);
			}
			System.out.println("请输入要选择的歌曲：");
			int number = in.nextInt();//选择歌曲
			Song s = listSong.get(number - 1);
			System.out.println("正在播放：\n" + "歌曲：" + s.songName + " 原唱：" + s.songer + " 歌曲时长：" + s.time);
			listSong.remove(number - 1);//播放后删除歌曲
		}
		//按顺序播放歌曲
		if ('n' == c)
		{
			Song s = listSong.get(0);//获取歌曲列表的第一首歌
			System.out.println("正在播放：\n" + "歌曲：" + s.songName + " 原唱：" + s.songer + " 歌曲时长：" + s.time);
			listSong.remove(0);//删除歌曲列表的第一首歌
		}
		return true;
	}

}
