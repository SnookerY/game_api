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
	 * 根据gid查询用户信息
	 * @param gid
	 * @return
	 */
	User findByGid(int gid);
	
	/**
	 * 根据uid查询用户信息
	 * @param uid
	 * @return
	 */
	User findByUid(String uid);
	
	/**
	 * 根据客户端传来的uid自动生成gid，
	 * 其余数据默认生成，再由客户端通过修改接口上报玩家数据
	 * @param users
	 */
	void createGid(User user);
	
	/**
	 * 根据gid修改玩家rank数据信息
	 * @param user
	 */
	void update(User user);
	
	/**
	 * 查询用户全部信息（前50名）
	 * @return
	 */
	List<User> findAll();
	
}
