package com.game.jhtc.web;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

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
	
	private Logger logger = Logger.getLogger(UpdateUserController.class);

	/**
	 * base64编码
	 * @param str
	 * @return
	 */
	/*private String decodeBase64(String str){
		
		try {
			byte[] bytes = Base64Util.decode(str.getBytes("utf-8"));
			return new String(bytes, "utf-8").replaceAll("\0", "");
		} catch (Exception e) {
		}
	    	return str;
	}*/
	
	/**Spring MVC RESTful JSON**/
	/**
	 * 根据玩家gid修改玩家昵称信息(玩家数据上报)
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/updateUser", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String queryUser(@RequestParam(value="gid",required=true) Integer gid,
							@RequestParam(value="nick",required=true) String nick,
							@RequestParam(value="score",required=true) Integer score,
							@RequestParam(value="length",required=true) Integer length){
		try{
			if(!(gid.equals(null))){
				
				logger.info(gid);
				
				//录入数据
				User user = new User();
				user.setGid(gid);
				user.setNick(nick);
				user.setScore(score);
				user.setLength(length);
				
				userDao.update(user);
				
				logger.info(user);
				
				JSONObject objData = new JSONObject();   
			    objData.put("ret", 200);    
			    objData.put("data", "[]");  
			    objData.put("msg", "success"); 
				
			    return objData.toString();
			    
			} else {
				
				JSONObject objData = new JSONObject();   
			    objData.put("ret", 400);    
			    objData.put("data", "[]");  
			    objData.put("msg", "fail"); 
				
			    logger.info(objData.toString());
			    
			    return objData.toString();
			}
			
		} catch (Exception e){
			
			e.getMessage();
			
			JSONObject objData = new JSONObject();   
		    objData.put("ret", 400);    
		    objData.put("data", "[]");  
		    objData.put("msg", "fail"); 
			
		    return objData.toString();
		}
	}
	
}
