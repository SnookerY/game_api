package com.game.jhtc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * 查询用户信息接口
 * 请求方式：localthost:8080/snake_api/snake/query?gid=?
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
	 * 根据玩家id查询玩家信息
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/view/{gid}", method = RequestMethod.GET)
	@ResponseBody
	public User view(@PathVariable Integer gid){
		
		System.out.println("gid:" + gid);
		return userDao.findById(gid);
	}
	
	@RequestMapping(value="/query", method = RequestMethod.GET)
	@ResponseBody
	public User queryUser(@RequestParam(value="gid",required=true) Integer gid){
		
		System.out.println("gid:" + gid);
		return userDao.findById(gid);
	}
	
}
