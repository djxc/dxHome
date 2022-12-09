package com.djxc.study.web.LearnSpring.aop.xml;

import java.util.logging.Level;
import java.util.logging.Logger;


public class BeforeAdvice {
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * mΪ����ķ�����argsΪ���ݵĲ�����targetΪ��������
	 */
	public void before() {
		
		log.log(Level.INFO, "delete ......");
	}

}
