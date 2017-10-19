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
 * 玩家信息查询接口
 * @author snooker
 * @create 2017-10-10
 */
@Controller
@RequestMapping("/snake")
@Transactional
public class QueryScoreController {

	@Autowired
	private UserDao userDao;
	
	private static Logger logger = Logger.getLogger(QueryScoreController.class);
	
	/**Spring MVC RESTful JSON**/
	/**
	 * 根据玩家gid查询玩家rank信息
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/queryScore", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String queryScore(@RequestParam(value="gid",required=true) Integer gid){
		
		try{
			if(!(gid.equals(null))){
				
				logger.info(gid);
				
				User user = new User();
				user = userDao.findByGid(gid);
				
				Object json = JSONObject.toJSON(user);  
			    JSONObject objData = new JSONObject();   
			    
			    objData.put("ret", 200);    
			    objData.put("data", json);  
			    objData.put("msg", "success");  
			    
			    logger.info(json);
				
				return objData.toString();
			} else {
				
				JSONObject objData = new JSONObject();   
			    objData.put("ret", 400);    
			    objData.put("data", "[]");  
			    objData.put("msg", "fail"); 
				
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
