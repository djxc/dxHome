package com.djxc.study.web.LearnSpring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DynamicProxy implements InvocationHandler{

	private Logger log = Logger.getLogger(this.getClass().getName());
	private Object ob;
	
	/**
	 * �󶨱��������,���ش������ʵ��
	 * @param ob
	 * @return
	 */
	public Object bind(Object ob){
		this.ob = ob;
		return Proxy.newProxyInstance(ob.getClass().getClassLoader(), 
				ob.getClass().getInterfaces(), this);
	}
	
	/**
	 * �����һЩ�������Լ��趨ҵ���߼������ñ�������ķ���ʱ���Զ����ô˷�����
	 * args�Ǵ������Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		log.log(Level.INFO, "before delete");
		System.out.println(args[0]);
		Object obj = method.invoke(ob, args);
		log.log(Level.INFO, "after delete");
		return obj;
	}
	
}
