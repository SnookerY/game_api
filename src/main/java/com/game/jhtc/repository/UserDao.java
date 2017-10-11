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
	
	/**
	 * 根据gid查询用户信息
	 * @param id
	 * @return
	 */
	public User findById(int id);
	
	/**
	 * 根据uid查询用户的gid
	 * @param uid
	 * @return
	 */
	public User findByUid(String uid);
	
	public void update(User user);
	
}
