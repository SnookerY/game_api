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

	List<User> findAll();
	
	/*void save(User user);
	
	User findById(int id);
	
	void update(User user);
	*/
}
