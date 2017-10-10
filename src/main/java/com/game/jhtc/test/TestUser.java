package com.game.jhtc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * UserDao测试类
 * @author snooker
 *
 */
public class TestUser {

	/**
	 * 测试查询全部
	 */
	@Test
	public void testFindAll(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		List<User> list = dao.findAll();
		for(User user : list){
			System.out.println(
					user.getUid() + " " +
					user.getGid() + " " +
					user.getNick() + " " +
					user.getScore()
			);
		}
	}
	
	/**
	 * 测试查询一个（根据gid）
	 */
	@Test
	public void testById(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		System.out.println(dao.findById(2));
	}
	
	/**
	 * 测试添加方法
	 */
	@Test
	public void testInsert(){
		
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		User user = new User();
		user.setUid("xxs516");
		user.setGid(6);
		user.setNick("乐芙兰");
		user.setScore(110);
		dao.save(user);
		System.out.println(dao.findById(6));
		
	}
	
	/**
	 * 测试修改方法
	 */
	@Test
	public void testUpdate(){
		
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		User user = new User();
		user.setGid(6);
		user.setNick("乐芙兰");
		dao.update(user);
		System.out.println(dao.findById(6));
	}
}