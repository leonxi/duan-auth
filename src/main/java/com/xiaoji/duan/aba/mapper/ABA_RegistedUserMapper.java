package com.xiaoji.duan.aba.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaoji.duan.aba.entity.ABA_RegistedUser;

@Mapper
public interface ABA_RegistedUserMapper {

	@Select("SELECT OPENID, NICKNAME, SEX, PROVINCE, CITY, COUNTRY, AVATAR, PRIVILEGE, UNIONID, CREATE_TIME FROM ABA_RegistedUser WHERE UNIONID = #{unionId}")
	@Results({
		@Result(column="OPENID", property="openId"),
		@Result(column="NICKNAME", property="nickName"),
		@Result(column="SEX", property="sex"),
		@Result(column="PROVINCE", property="province"),
		@Result(column="CITY", property="city"),
		@Result(column="COUNTRY", property="country"),
		@Result(column="AVATAR", property="avatar"),
		@Result(column="PRIVILEGE", property="privilege"),
		@Result(column="UNIONID", property="unionId"),
		@Result(column="CREATE_TIME", property="createTime")
	})
	public ABA_RegistedUser findByPK(@Param("unionId") String unionId);
	
	@Select("SELECT OPENID, NICKNAME, SEX, PROVINCE, CITY, COUNTRY, AVATAR, PRIVILEGE, UNIONID, CREATE_TIME FROM ABA_RegistedUser WHERE OPENID = #{openId}")
	@Results({
		@Result(column="OPENID", property="openId"),
		@Result(column="NICKNAME", property="nickName"),
		@Result(column="SEX", property="sex"),
		@Result(column="PROVINCE", property="province"),
		@Result(column="CITY", property="city"),
		@Result(column="COUNTRY", property="country"),
		@Result(column="AVATAR", property="avatar"),
		@Result(column="PRIVILEGE", property="privilege"),
		@Result(column="UNIONID", property="unionId"),
		@Result(column="CREATE_TIME", property="createTime")
	})
	public ABA_RegistedUser findByOpenId(@Param("openId") String openId);
	
	@Insert("INSERT INTO ABA_RegistedUser (OPENID, NICKNAME, SEX, PROVINCE, CITY, COUNTRY, AVATAR, PRIVILEGE, UNIONID, CREATE_TIME) " +
			"VALUES(#{openId}, #{nickName}, #{sex}, #{province}, #{city}, #{country}, #{avatar}, #{privilege}, #{unionId}, Now())")
	public int insert(ABA_RegistedUser ru);

	@Update("UPDATE ABA_RegistedUser SET OPENID = #{openId}, NICKNAME = #{nickName}, SEX = #{sex}, PROVINCE = #{province}, CITY = #{city}, COUNTRY = #{country}, AVATAR = #{avatar}, PRIVILEGE = #{privilege} WHERE UNIONID = #{unionId}")
	public int update(ABA_RegistedUser ru);
}
