package com.game.jhtc.repository;

import java.util.List;

import com.game.jhtc.annotation.MyBatisRepository;
import com.game.jhtc.entity.User;

/**
 * 用户表的Dao组件
 * @author snooker
 *
 */
@MyBatisRepository
public interface UserDao {

	public List<User> findAll();
	
	public void save(User user);
	
	public User findById(int id);
	
	public void update(User user);
	
}
