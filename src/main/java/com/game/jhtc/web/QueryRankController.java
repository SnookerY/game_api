package com.game.jhtc.web;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.game.jhtc.entity.User;
import com.game.jhtc.repository.UserDao;

/**
 * 玩家排行榜查询接口
 * @author snooker
 * @create 2017-10-10
 */
@Controller
@RequestMapping("/snake")
@Transactional
public class QueryRankController {
	
	@Autowired
	private UserDao userDao;
	
	private static Logger logger = Logger.getLogger(CreateGidController.class);

	/**

	 * 查询玩家rank排名（前50名）

	 */
	@RequestMapping(value="/queryRank/{str}", method=RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String queryRank(@PathVariable String str){
		try{
				
				List<User> list = new ArrayList<User>();
				list = userDao.findAll();
				//JSONArray jsonArray = JSONArray.fromObject(list);
				
				JSONObject objData = new JSONObject(); 
				objData.put("ret", 200);    
			    objData.put("data", list);  
			    objData.put("msg", "success");
			    
			    logger.info(objData);
				
				return objData.toJSONString();	
				
		} catch (Exception e){
			
			e.getMessage();
			
			JSONObject objData = new JSONObject();   
		    objData.put("ret", 400);    
		    objData.put("data", "[]");  
		    objData.put("msg", "Invalid request param !"); 
		    
		    logger.info(objData);
			
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
