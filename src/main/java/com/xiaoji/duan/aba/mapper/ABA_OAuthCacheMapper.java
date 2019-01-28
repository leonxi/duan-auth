package com.xiaoji.duan.aba.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaoji.duan.aba.entity.ABA_OAuthCache;

@Mapper
public interface ABA_OAuthCacheMapper {

	@Select("SELECT CODE, STATE, LOGON_TIME, CREATE_TIME FROM ABA_OAuthCache WHERE STATE = #{state} OR CODE = #{code}")
	@Results({
		@Result(column="CODE", property="code"),
		@Result(column="STATE", property="state"),
		@Result(column="LOGON_TIME", property="logonTime"),
		@Result(column="CREATE_TIME", property="createTime")
	})
	public ABA_OAuthCache findByPK(@Param("state") String state, @Param("code") String code);
	
	@Insert("INSERT INTO ABA_OAuthCache (CODE, STATE, LOGON_TIME, CREATE_TIME) " +
			"VALUES(#{code}, #{state}, Now(), Now())")
	public int insert(ABA_OAuthCache oac);
	
	@Update("UPDATE ABA_OAuthCache SET CODE = #{code}, LOGON_TIME = Now() WHERE STATE = #{state} AND CODE IS NULL")
	public int update(ABA_OAuthCache oac);
}
