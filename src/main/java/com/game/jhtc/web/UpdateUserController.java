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
 * 用户修改接口
 * @author snooker
 * @create 2017-10-11
 */
@Controller
@RequestMapping("/snake")
public class UpdateUserController {

	@Autowired
	private UserDao userDao;

	/**Spring MVC RESTful JSON**/
	/**
	 * 根据玩家id修改玩家昵称信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/updateUser", produces = "application/text;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String queryUser(@RequestParam(value="id",required=true) Integer id,
							@RequestParam(value="nick",required=true) String nick){
		
		User user = new User();
		user.setId(id);
		user.setNick(nick);
		
		userDao.update(user);
		return "200";
	}
	
}
