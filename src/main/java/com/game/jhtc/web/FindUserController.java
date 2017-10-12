package com.game.jhtc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * 用户查询接口
 * @author snooker
 * @create 2017-10-10
 */
@Controller
@RequestMapping("/snake")
public class FindUserController {

	@Autowired
	private UserDao userDao;

	/**Spring MVC RESTful JSON**/
	/**
	 * 根据玩家id查询玩家rank信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/queryScore", method = RequestMethod.GET)
	@ResponseBody
	public User queryUser(@RequestParam(value="id",required=true) Integer id){
		
		System.out.println("id:" + id);
		return userDao.findById(id);
	}
	
	/**
	 * 根据玩家uid查询玩家gid
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/queryUid", method = RequestMethod.POST)
	@ResponseBody
	public User queryGid(@RequestParam(value="uid",required=true) String uid){
		
		System.out.println("uid:" + uid);
		return userDao.findByUid(uid);
	}
	
}
