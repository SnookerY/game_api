package com.game.jhtc.annotation;

import org.springframework.stereotype.Repository;

/**
 * MyBatis使用该注解表示Dao
 * @author snooker
 *
 */
@Repository
public @interface MyBatisRepository {
	String value() default "";
}
