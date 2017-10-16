package com.game.jhtc.web;


import javax.transaction.Transactional;

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
 * 贪吃蛇玩家数据上报接口
 * @author snooker
 * @create 2017-10-11
 */
@Controller
@RequestMapping("/snake")
@Transactional
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
	 * 根据玩家gid修改玩家昵称信息(玩家数据上报)
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/updateUser", method = RequestMethod.GET)
	@ResponseBody
	public String queryUser(@RequestParam(value="gid",required=true) Integer gid,
							@RequestParam(value="nick",required=true) String nick,
							@RequestParam(value="score",required=true) Integer score,
							@RequestParam(value="length",required=true) Integer length){
		//录入数据
		User user = new User();
		user.setGid(gid);
		user.setNick(nick);
		user.setScore(score);
		user.setLength(length);
		
		userDao.update(user);
		return "success";
	}
	
}
