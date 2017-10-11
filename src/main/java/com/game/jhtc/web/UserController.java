package com.game.jhtc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * 查询用户表的全部信息
 * 解析到视图（jsp）与接口无关
 * @author snooker
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserDao userDao;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String find(Model model){
		
		List<User> list = userDao.findAll();
		model.addAttribute("users", list);
		return "user_list";
	}
}