package com.game.jhtc.web;


import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * 根据玩家gid查询玩家rank信息
	 * 传统形式
	 * @param gid
	 * @return
	 */
	/*@RequestMapping(value="/queryScore", method = RequestMethod.GET)
	@ResponseBody
	public User queryUser(@RequestParam(value="gid",required=true) Integer gid){
		
		System.out.println("gid:" + gid);
		return userDao.findByGid(gid);
	}*/
	
	/**
	 * 根据玩家gid查询玩家rank信息
	 * 解析json字符串
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/queryScore", method = RequestMethod.GET)
	@ResponseBody
	@SuppressWarnings({ "static-access" })
	public User queryUser(HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		String str = URLDecoder.decode(req.getParameter("gidJson"),"UTF-8");
		JSONObject jsonObject = new JSONObject();
		//将json格式的字符串转换为json对象，并取得该对象“gid”的属性值
		Integer gid = (Integer)jsonObject.fromObject(str).get("gid");
		return userDao.findByGid(gid);
	}
	
	/**
	 * 根据玩家uid查询玩家gid
	 * @param uid
	 * @return
	 */
	/*@RequestMapping(value="/queryUid", method = RequestMethod.POST)
	@ResponseBody
	public User queryGid(@RequestParam(value="uid",required=true) String uid){
		
		System.out.println("uid:" + uid);
		return userDao.findByUid(uid);
	}*/
	
}
