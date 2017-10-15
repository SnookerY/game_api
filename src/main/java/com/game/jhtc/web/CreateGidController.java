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
	 * 根据客户端发送的uid自动生成gid
	 * @author snooker
	 * @create 2017-10-11
	 */
	@Controller
	@RequestMapping("/snake")
	public class CreateGidController {
		
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
		 * 通过uid生成gid
		 * @param uid
		 * @return
		 */
		@RequestMapping(value="/createGid", method = RequestMethod.POST)
		@ResponseBody
		public String insertUid(@RequestParam(value="uid", required=true) String uid){
			
			User user = new User();
			
			user.setUid(uid);
			
			/**
			 * 调用添加方法，将数据存入数据库
			 */
			userDao.createGid(user);
			
			return "success";
		}
	}

