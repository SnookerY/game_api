package com.game.jhtc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

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

	/**
	 * 打开新增页面
	 */
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(){
		return "add_user";
	}
	
	/**
	 * 新增保存
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user){
		userDao.save(user);
		return "redirect:find";
	}
	
	
	/**
	 * 打开修改页面
	 */
	@RequestMapping(value="/toUpdate/{gid}",method=RequestMethod.GET)
	public String toUpdate(
			@PathVariable("gid") Integer gid, 
			Model model){
		User user = userDao.findById(gid);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	/**
	 * 修改保存
	 */
	@RequestMapping(value="/upadte",method=RequestMethod.PUT)
	@ResponseBody
	public boolean update(@RequestBody User user){
		userDao.update(user);
		return true;
	}
}
