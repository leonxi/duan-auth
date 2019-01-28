package com.xiaoji.duan.aba.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class ABA_OnlineUser implements Serializable {

	@JSONField(serialize = false)
	private static final long serialVersionUID = -5097950212778004148L;

	@JSONField(name = "access_token")
	private String accessToken;
	@JSONField(name = "expires_in")
	private Integer expiresIn;
	@JSONField(name = "refresh_token")
	private String refreshToken;
	@JSONField(name = "openid")
	private String openId;
	@JSONField(name = "scope")
	private String scope;
	@JSONField(name = "unionId")
	private String unionId;
	@JSONField(name = "code")
	private String code;
	@JSONField(serialize = false)
	private String logonTime;
	@JSONField(serialize = false)
	private String createTime;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLogonTime() {
		return logonTime;
	}

	public void setLogonTime(String logonTime) {
		this.logonTime = logonTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ABA_OnlineUser [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", refreshToken="
				+ refreshToken + ", openId=" + openId + ", scope=" + scope + ", unionId=" + unionId + ", logonTime="
				+ logonTime + ", createTime=" + createTime + "]";
	}

}
