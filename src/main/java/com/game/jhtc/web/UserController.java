package com.game.jhtc.web;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserDao userDao;
	
	@RequestMapping("/findUser.do")
	public String find(Model model){
		
		List<User> list = userDao.findAll();
		model.addAttribute("users", list);
		return "user/user_list";
	}
}
