package com.djxc.study.web.LearnSpring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class BeforeAdvice {
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * mΪ����ķ�����argsΪ���ݵĲ�����targetΪ��������
	 */
	@Before("execution ( * LearnSpring.ConnectDB.UserDao.*(..))")
	public void before() {
		log.log(Level.INFO, "delete ......");
	}

}
