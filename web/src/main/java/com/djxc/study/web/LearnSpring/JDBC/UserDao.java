package com.djxc.study.web.LearnSpring.JDBC;

public interface UserDao {
	void save(User u);
	void delete(int id);
	void update(User u);
	User getUsr(int id);
}
