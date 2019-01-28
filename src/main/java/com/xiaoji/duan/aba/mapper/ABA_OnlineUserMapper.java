package com.xiaoji.duan.aba.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaoji.duan.aba.entity.ABA_OnlineUser;

@Mapper
public interface ABA_OnlineUserMapper {

	@Select("SELECT ACCESS_TOKEN, EXPIRES_IN, REFRESH_TOKEN, OPENID, SCOPE, UNIONID, CODE, LOGON_TIME, CREATE_TIME FROM ABA_OnlineUser WHERE ACCESS_TOKEN = #{accessToken}")
	@Results({
		@Result(column="ACCESS_TOKEN", property="accessToken"),
		@Result(column="EXPIRES_IN", property="expiresIn"),
		@Result(column="REFRESH_TOKEN", property="refreshToken"),
		@Result(column="OPENID", property="openId"),
		@Result(column="SCOPE", property="scope"),
		@Result(column="UNIONID", property="unionId"),
		@Result(column="CODE", property="code"),
		@Result(column="LOGON_TIME", property="logonTime"),
		@Result(column="CREATE_TIME", property="createTime")
	})
	public ABA_OnlineUser findByAccessToken(@Param("accessToken") String accessToken);
	
	@Select("SELECT ACCESS_TOKEN, EXPIRES_IN, REFRESH_TOKEN, OPENID, SCOPE, UNIONID, CODE, LOGON_TIME, CREATE_TIME FROM ABA_OnlineUser WHERE CODE = #{code}")
	@Results({
		@Result(column="ACCESS_TOKEN", property="accessToken"),
		@Result(column="EXPIRES_IN", property="expiresIn"),
		@Result(column="REFRESH_TOKEN", property="refreshToken"),
		@Result(column="OPENID", property="openId"),
		@Result(column="SCOPE", property="scope"),
		@Result(column="UNIONID", property="unionId"),
		@Result(column="CODE", property="code"),
		@Result(column="LOGON_TIME", property="logonTime"),
		@Result(column="CREATE_TIME", property="createTime")
	})
	public ABA_OnlineUser findByCode(@Param("code") String code);
	
	@Select("SELECT ACCESS_TOKEN, EXPIRES_IN, REFRESH_TOKEN, OPENID, SCOPE, UNIONID, CODE, LOGON_TIME, CREATE_TIME FROM ABA_OnlineUser WHERE UNIONID = #{unionId}")
	@Results({
		@Result(column="ACCESS_TOKEN", property="accessToken"),
		@Result(column="EXPIRES_IN", property="expiresIn"),
		@Result(column="REFRESH_TOKEN", property="refreshToken"),
		@Result(column="OPENID", property="openId"),
		@Result(column="SCOPE", property="scope"),
		@Result(column="UNIONID", property="unionId"),
		@Result(column="CODE", property="code"),
		@Result(column="LOGON_TIME", property="logonTime"),
		@Result(column="CREATE_TIME", property="createTime")
	})
	public ABA_OnlineUser findByPK(@Param("unionId") String unionId);
	
	@Insert("INSERT INTO ABA_OnlineUser (ACCESS_TOKEN, EXPIRES_IN, REFRESH_TOKEN, OPENID, SCOPE, UNIONID, CODE, LOGON_TIME, CREATE_TIME) " +
			"VALUES(#{accessToken}, #{expiresIn}, #{refreshToken}, #{openId}, #{scope}, #{unionId}, #{code}, Now(), Now())")
	public int insert(ABA_OnlineUser ou);
	
	@Update("UPDATE ABA_OnlineUser SET ACCESS_TOKEN = #{accessToken}, EXPIRES_IN = #{expiresIn}, REFRESH_TOKEN = #{refreshToken}, OPENID = #{openId}, SCOPE = #{scope}, LOGON_TIME = Now(), CREATE_TIME = Now() WHERE UNIONID = #{unionId}")
	public int update(ABA_OnlineUser ou);
}
