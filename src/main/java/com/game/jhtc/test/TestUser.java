package com.game.jhtc.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * UserDao中的方法测试类
 * @author snooker
 *
 */
public class TestUser {
	
	private static Logger logger = Logger.getLogger(TestUser.class);
	

	/**
	 * 测试查询全部
	 */
	@Test
	@SuppressWarnings("resource")
	public void testFindAll(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		List<User> list = dao.findAll();
		for(User user : list){
			logger.info(
					user.getUid() + " " +
					user.getGid() + " " +
					user.getNick() + " " +
					user.getScore()
			);
		}
	}
	
	/**
	 * 测试查询玩家rank分数（根据gid）
	 */
	@Test
	@SuppressWarnings("resource")
	public void testByGid(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		logger.info(dao.findByGid(1));
	}
	
	/**
	 * 测试根据uid查询玩家gid
	 */
	@Test
	@SuppressWarnings("resource")
	public void testFindByUid(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		User user = dao.findByUid("jieac");
		logger.info(JSON.toJSONString(user));
	}
	
	
	/**
	 * 测试添加方法
	 */
	@Test
	@SuppressWarnings("resource")
	public void testInsert(){
		
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		User user = new User();
		user.setUid("xsdsda6");
		user.setNick("霞");
		user.setScore(98);
		user.setLength(1500000);
		dao.createGid(user);
		//logger.info(dao.findById(6));
		
	}
	
	/**
	 * 测试修改方法
	 */
	@Test
	@SuppressWarnings("resource")
	public void testUpdate(){
		
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		User user = new User();
		user.setGid(6);
		user.setNick("乐芙兰");
		dao.update(user);
		logger.info(dao.findByGid(6));
	}
	
	/**
	 * 测试json转化
	 */
	@Test
	@SuppressWarnings("resource")
	public void testFindByGid(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		User user = dao.findByGid(1);
		logger.info(JSON.toJSONString(user));
	}
	
	/**
	 * 将list集合转化为json集合对象
	 */
	@Test
    public void testCreateJsonArray() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(UserDao.class);
		List<User> list = new ArrayList<User>();
		list = dao.findAll();
        //创建json集合
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
    }
	
}
