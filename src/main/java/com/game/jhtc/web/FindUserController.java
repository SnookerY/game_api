package com.game.jhtc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * 查询用户信息
 * @author snooker
 * @create 2017-10-10
 */
@Controller
@RequestMapping("/snake")
public class FindUserController {

	@Resource
	private UserDao userDao;

	/**Spring MVC RESTful JSON**/
	@RequestMapping(value="/queryUser", method = RequestMethod.GET)
	@ResponseBody
	public User queryUser(@RequestParam(value="gid",required=true) Integer gid){
		
		System.out.println("gid:" + gid);
		return userDao.findById(gid);
	}
	
}
