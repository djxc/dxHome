package com.djxc.study.web.LearnSpring.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BeforeAdvice implements MethodBeforeAdvice{
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * mΪ����ķ�����argsΪ���ݵĲ�����targetΪ��������
	 */
	@Override
	public void before(Method m, Object[] args, Object target) throws Throwable {
		System.out.println(m.getName());
		System.out.println(args[0]);
		System.out.println(target.getClass().getName());
		log.log(Level.INFO, "delete ......");
	}

}
