package com.game.jhtc.repository;

import java.util.List;

import com.game.jhtc.annotation.MyBatisRepository;
import com.game.jhtc.entity.User;

/**
 * 用户表的Dao组件
 * 接口的查询方法
 * @author snooker
 *
 */
@MyBatisRepository
public interface UserDao {

	/**
	 * 查询用户全部信息
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 根据请求参数保存用户信息
	 * @param users
	 */
	public void saveUser(User users);
	
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
	
	/**
	 * 根据id修改玩家昵称nick
	 * @param user
	 */
	public void update(User user);
	
}
