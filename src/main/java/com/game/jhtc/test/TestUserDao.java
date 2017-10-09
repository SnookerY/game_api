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
public class TestUserDao {

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
}
