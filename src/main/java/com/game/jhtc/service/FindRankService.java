package com.game.jhtc.service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.jhtc.entity.User;

public class FindRankService {

	public void queryRank() throws IOException{
		
		String conf = "applicationContext";
		Reader reader = Resources.getResourceAsReader(conf);
		
		//创建SessionFactory对象
		SqlSessionFactoryBuilder sfb  = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		//创建Session
		SqlSession session = sf.openSession();
		
		int offset = 0;//起点，从0开始
		int limit = 50;//查50条
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<User> list = 
			session.selectList("findAll",null,rowBounds);
		for(User user : list){
			System.out.println(user.getGid()+""
					+user.getNick()+""
					+user.getScore());
		}
		session.close();
	}
}
