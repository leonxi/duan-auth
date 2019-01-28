package com.xiaoji.duan.aba.entity;

import java.io.Serializable;

public class ABA_RegistedUser implements Serializable {

	private static final long serialVersionUID = -7635517031798378407L;

	private String openId;
	private String nickName;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String avatar;
	private String privilege;
	private String unionId;
	private String createTime;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ABA_RegistedUser [openId=" + openId + ", nickName=" + nickName + ", sex=" + sex + ", province="
				+ province + ", city=" + city + ", country=" + country + ", avatar=" + avatar + ", privilege="
				+ privilege + ", unionId=" + unionId + ", createTime=" + createTime + "]";
	}

}
