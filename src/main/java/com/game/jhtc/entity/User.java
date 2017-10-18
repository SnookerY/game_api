package com.game.jhtc.entity;

/**
 * 用户表实体类
 * @author snooker
 *
 */
public class User {

	private String uid;//唯一码
	private Integer gid;//游戏id
	private String nick;//玩家昵称
	private Integer score;//玩家分数
	private Integer length;//贪吃蛇长度
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", gid=" + gid + ", nick=" + nick
				+ ", score=" + score + ", length=" + length + "]";
	}
}
