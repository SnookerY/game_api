package com.game.jhtc.web;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * 用户查询接口
 * @author snooker
 * @create 2017-10-10
 */
@Controller
@RequestMapping("/snake")
@Transactional
public class FindUserController {

	@Autowired
	private UserDao userDao;
	
	/**Spring MVC RESTful JSON**/
	/**
	 * 根据玩家gid查询玩家rank信息
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/queryScore", method = RequestMethod.GET)
	@ResponseBody
	public String queryScore(@RequestParam(value="gid",required=true) Integer gid){
		
		try{
			if(!(gid.equals(null))){
				
				User user = new User();
				user = userDao.findByGid(gid);
				
				Object json = JSONObject.toJSON(user);  
			    JSONObject objData = new JSONObject();   
			    
			    objData.put("ret", 200);    
			    objData.put("data", json);  
			    objData.put("msg", "success");  
				
				return objData.toString();
			}else{
				
				JSONObject objData = new JSONObject();   
			    objData.put("ret", 400);    
			    objData.put("data", "[]");  
			    objData.put("msg", "fail"); 
				
			    return objData.toString();
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
			JSONObject objData = new JSONObject();   
		    objData.put("ret", 400);    
		    objData.put("data", "[]");  
		    objData.put("msg", "fail"); 
			
		    return objData.toString();
		}
	}
	
	/**
	 * 查询玩家rank排名（前50名）
	 */
	@RequestMapping(value="/queryRank/{rank}", method=RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String queryRank(@PathVariable String rank){
		try{
			List<User> list = new ArrayList<User>();
			list = userDao.findAll();
			JSONArray jsonArray = JSONArray.fromObject(list);
			return jsonArray.toString();
		}catch(Exception e){
			e.printStackTrace();
			
			JSONObject objData = new JSONObject();   
		    objData.put("ret", 400);    
		    objData.put("data", "[]");  
		    objData.put("msg", "fail"); 
			
		    return objData.toString();
		}
	}
	
	/**
	 * 根据玩家gid查询玩家rank信息
	 * 解析json字符串（需求变更不再使用）
	 * @param gid
	 * @return
	 */
	/*@RequestMapping(value="/queryScore", method = RequestMethod.GET)
	@ResponseBody
	@SuppressWarnings({ "static-access" })
	public User queryUser(HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		String str = URLDecoder.decode(req.getParameter("gidJson"),"UTF-8");
		JSONObject jsonObject = new JSONObject();
		//将json格式的字符串转换为json对象，并取得该对象“gid”的属性值
		Integer gid = (Integer)jsonObject.fromObject(str).get("gid");
		return userDao.findByGid(gid);
	}*/
}
