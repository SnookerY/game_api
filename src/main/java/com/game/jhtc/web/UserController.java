package com.game.jhtc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@RequestMapping("/findUser.do")
	public String find(Model model){
		
		List<User> list = userDao.findAll();
		model.addAttribute("users", list);
		return "user_list";
	}

	/**
	 * 打开新增页面
	 */
	@RequestMapping("addUser.do")
	public String toAdd(){
		return "add_user";
	}
	
	/**
	 * 新增保存
	 */
	@RequestMapping("/addUser.do")
	public String add(User user){
		userDao.save(user);
		return "redirect:findUser.do";
	}
	
	/**
	 * 打开修改页面
	 */
	@RequestMapping("updateUser.do")
	public String toUpdate(
			@RequestParam("gid") int gid, Model model){
		User user = userDao.findById(gid);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	/**
	 * 修改保存
	 */
	@RequestMapping("updateUser.do")
	public String update(User user){
		userDao.update(user);
		return "redirect:findUser.do";
	}
}
