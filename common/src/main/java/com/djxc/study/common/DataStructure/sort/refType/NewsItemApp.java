package com.djxc.study.common.DataStructure.sort.refType;


import com.djxc.study.common.DataStructure.sort.innerType.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * ʹ��Collections
 * @author Administrator
 *
 */
public class NewsItemApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<NewsItem> news=new ArrayList<NewsItem>();
		news.add(new NewsItem("���������ˣ������˱�����",50,new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("�й����ϵ��㵺�ˣ�ȫ��������",100,new Date()));
		news.add(new NewsItem("С�ձ����������ˣ���������Ц��",60,new Date(System.currentTimeMillis()-1000*60*60)));
		System.out.println("����ǰ:"+news);		
		//����
		//Collections.sort(news);	
		Utils.sort(news);
		System.out.println("�����"+news);
		
		
		
	}

}
