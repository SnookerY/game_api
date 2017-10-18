package com.game.jhtc.web;

import javax.transaction.Transactional;

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
	 * 根据客户端发送的uid自动生成gid
	 * @author snooker
	 * @create 2017-10-11
	 */
	@Controller
	@RequestMapping("/snake")
	@Transactional
	public class CreateGidController {
		
		@Autowired
		private UserDao userDao;
		
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
		 * 通过uid生成gid
		 * @param uid
		 * @return
		 */
		@RequestMapping(value="/createGid", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
		@ResponseBody
		public String createGid(@RequestParam(value="uid", required=true) String uid){
			try {
				
				if (uid!=null && uid!=""){
					
						User user = userDao.findByUid(uid);
						
					if(user != null){
						
						Object json = JSONObject.toJSON(user);  
					    JSONObject objData = new JSONObject();   
					    
					    objData.put("ret", 200);    
					    objData.put("data", json);  
					    objData.put("msg", "success");  
						
						return objData.toString();
						
					} else {
						
						user = new User();
						user.setUid(uid);  
						userDao.createGid(user);
						user = userDao.findByUid(uid);
						
						Object json = JSONObject.toJSON(user);  
					    JSONObject objData = new JSONObject();   
					    
					    objData.put("ret", 200);    
					    objData.put("data", json);  
					    objData.put("msg", "success");  
						
						return objData.toString();
					}
					
				} else {
					
					JSONObject objData = new JSONObject();   
				    objData.put("ret", 400);    
				    objData.put("data", "[]");  
				    objData.put("msg", "fail"); 
					
				    return objData.toString();
				}
				
			} catch (Exception e){
				
				e.printStackTrace();
				
				JSONObject objData = new JSONObject();   
			    objData.put("ret", 400);    
			    objData.put("data", "[]");  
			    objData.put("msg", "fail"); 
			    
			    return objData.toString();
			}
		}
		
	}

