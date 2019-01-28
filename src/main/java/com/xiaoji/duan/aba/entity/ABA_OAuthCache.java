package com.xiaoji.duan.aba.entity;

import java.io.Serializable;

public class ABA_OAuthCache implements Serializable {

	private static final long serialVersionUID = 8865775051121748740L;

	private String code;
	private String state;
	private String logonTime;
	private String createTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		return "ABA_OAuthCache [code=" + code + ", state=" + state + ", logonTime=" + logonTime + ", createTime="
				+ createTime + "]";
	}

}
