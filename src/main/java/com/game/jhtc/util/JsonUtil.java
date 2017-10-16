package com.game.jhtc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 指定json输出方式，null不做输出
 * @author snooker
 *
 */
public final class JsonUtil {

	public static String beanToJson(Object obj){
		return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue,
				SerializerFeature.UseISO8601DateFormat);
	}
}
