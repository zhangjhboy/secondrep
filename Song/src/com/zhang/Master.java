package com.zhang;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Master {
	public static List<Song> listSong;//�����б�
	public Master()//���캯������ʼ��list
	{
		listSong = new ArrayList<Song>();
	}
	public boolean play()//���Ÿ���
	{
		if (listSong.isEmpty())//�жϸ����б��Ƿ�Ϊ��
		{
			System.out.println("�޸�������...");
			return false;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("�Ƿ�ָ���������ţ� y/n");
		String s1 = in.next();
		char c = s1.charAt(0);//�����Ƿ�ָ����������
		//ָ����������
		if ('y' == c)
		{
			int i;
			for (i = 0; i < listSong.size(); i++)//��������б�
			{
				System.out.println((i + 1) + " " + listSong.get(i).songName + "  " + listSong.get(i).songer);
			}
			System.out.println("������Ҫѡ��ĸ�����");
			int number = in.nextInt();//ѡ�����
			Song s = listSong.get(number - 1);
			System.out.println("���ڲ��ţ�\n" + "������" + s.songName + " ԭ����" + s.songer + " ����ʱ����" + s.time);
			listSong.remove(number - 1);//���ź�ɾ������
		}
		//��˳�򲥷Ÿ���
		if ('n' == c)
		{
			Song s = listSong.get(0);//��ȡ�����б�ĵ�һ�׸�
			System.out.println("���ڲ��ţ�\n" + "������" + s.songName + " ԭ����" + s.songer + " ����ʱ����" + s.time);
			listSong.remove(0);//ɾ�������б�ĵ�һ�׸�
		}
		return true;
	}

}
