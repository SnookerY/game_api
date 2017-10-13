package com.game.jhtc.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;
import com.game.jhtc.util.Base64Util;

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

	/**
	 * base64编码
	 * @param str
	 * @return
	 */
	private String decodeBase64(String str){
		
		try {
			byte[] bytes = Base64Util.decode(str.getBytes("utf-8"));
			return new String(bytes, "utf-8").replaceAll("\0", "");
		} catch (Exception e) {
		}
	    	return str;
	}
	
	/**Spring MVC RESTful JSON**/
	/**
	 * 根据玩家id修改玩家昵称信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public String queryUser(@RequestParam(value="id",required=true) Integer id,
							@RequestParam(value="nick",required=true) String nick){
		
		User user = new User();
		//user.setId(id);
		user.setNick(decodeBase64(nick));
		
		userDao.update(user);
		return "success";
	}
	
}
