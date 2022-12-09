package com.djxc.study.web.LearnSpring.aop;

import com.djxc.study.LearnSpring.ConnectDB.User;
import com.djxc.study.LearnSpring.ConnectDB.UserDao;

import java.util.logging.Level;
import java.util.logging.Logger;


public class UserProxy implements UserDao {
	private Logger log = Logger.getLogger(this.getClass().getName());	
	private UserDao dao;
	
	public UserProxy(UserDao dao){
		this.dao = dao;
	}

	@Override
	public void register(User u) {

	}

	@Override
	public void delete(String name) {
		log.log(Level.INFO, "before delete");
		dao.delete(name);
		log.log(Level.INFO, "after delete");
	}

}
