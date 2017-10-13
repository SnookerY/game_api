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
	 * 玩家数据上报接口
	 * @author snooker
	 * @create 2017-10-11
	 */
	@Controller
	@RequestMapping("/snake")
	public class InserUserController {
		
		@Autowired
		private UserDao userDao;
		
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
		 * 将客户端请求的用户数据存入数据库
		 * @param gid
		 * @return
		 */
		@RequestMapping(value="/addUser", method = RequestMethod.POST)
		@ResponseBody
		public String insertUser(@RequestParam(value="uid", required=true) String uid,
							     @RequestParam(value="nick", required=true) String nick,
							     @RequestParam(value="score", required=true) Integer score,
							     @RequestParam(value="length", required=true) Integer length){
			
			User user = new User();
			
			user.setUid(uid);
			user.setNick(decodeBase64(nick));
			user.setScore(score);
			user.setLength(length);
			
			/**
			 * 调用添加方法，将数据存入数据库
			 */
			userDao.saveUser(user);
			
			return "success";
		}
	}

