package com.xiaoji.duan.aba.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.xiaoji.duan.aba.entity.ABA_OAuthCache;
import com.xiaoji.duan.aba.entity.ABA_OnlineUser;
import com.xiaoji.duan.aba.entity.ABA_RegistedUser;
import com.xiaoji.duan.aba.mapper.ABA_OAuthCacheMapper;
import com.xiaoji.duan.aba.mapper.ABA_OnlineUserMapper;
import com.xiaoji.duan.aba.mapper.ABA_RegistedUserMapper;

@Service
public class ABAService {

	private final ABA_OAuthCacheMapper oacMapper;
	private final ABA_OnlineUserMapper ouMapper;
	private final ABA_RegistedUserMapper ruMapper;

	public ABAService(ABA_OAuthCacheMapper oacMapper, ABA_OnlineUserMapper ouMapper, ABA_RegistedUserMapper ruMapper) {
		this.oacMapper = oacMapper;
		this.ouMapper = ouMapper;
		this.ruMapper = ruMapper;
	}

	public Map<String, Object> https(String requestUrl) {
		Map<String, Object> httpsResult = null;
		InputStream is = null;

		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoInput(true);
			conn.setDoOutput(false);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			conn.setRequestMethod("GET");

			is = conn.getInputStream();
			String result = getContent(is, "utf-8");
			JSONObject jsonResult = JSON.parseObject(result);
			httpsResult = jsonResult.toJavaObject(Map.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return httpsResult;
	}

	public ABA_RegistedUser getRegistedUserByUnionId(String unionId) {
		return this.ruMapper.findByPK(unionId);
	}

	public ABA_RegistedUser getRegistedUserByOpenId(String openId) {
		return this.ruMapper.findByOpenId(openId);
	}

	public ABA_OnlineUser getOnlineUserByAccessToken(String accessToken) {
		return this.ouMapper.findByAccessToken(accessToken);
	}

	public ABA_OnlineUser getOnlineUser(String code) {
		return this.ouMapper.findByCode(code);
	}

	public ABA_OAuthCache getOAuthCache(String code) {
		return this.oacMapper.findByPK("", code);
	}
	
	public void saveOnlineUser(Map<String, Object> ouMap) {
		String openId = (String) ouMap.get("openid");
		String accessToken = (String) ouMap.get("access_token");

		ABA_OnlineUser ou = this.ouMapper.findByAccessToken(accessToken);

		if (ou == null) {
			// 登录信息记录
			Integer expiresIn = (Integer) ouMap.get("expires_in");
			String refreshToken = (String) ouMap.get("refresh_token");
			String scope = (String) ouMap.get("scope");
			String unionId = (String) ouMap.get("unionid");
			String code = (String) ouMap.get("code");

			ABA_OnlineUser ouNew = new ABA_OnlineUser();

			ouNew.setAccessToken(accessToken);
			ouNew.setExpiresIn(Integer.valueOf(expiresIn));
			ouNew.setRefreshToken(refreshToken);
			ouNew.setOpenId(openId);
			ouNew.setScope(scope);
			ouNew.setUnionId(unionId);
			ouNew.setCode(code);

			ABA_OnlineUser exist = this.ouMapper.findByPK(unionId);

			if (exist == null) {
				this.ouMapper.insert(ouNew);
			} else {
				this.ouMapper.update(ouNew);
			}
		} else {
			// 登录信息已记录
		}
	}

	public void saveRegistedUser(Map<String, Object> ru) {
		String openId = (String) ru.get("openid");
		String nickName = (String) ru.get("nickname");
		String sex = String.valueOf(ru.get("sex"));
		String province = (String) ru.get("province");
		String city = (String) ru.get("city");
		String country = (String) ru.get("country");
		String avatar = (String) ru.get("openid");
		String privilege = "[]";
		if (ru.get("privilege") != null) {
			privilege = Arrays.toString(((JSONArray) ru.get("privilege")).toArray());
		}
		String unionId = (String) ru.get("unionid");

		ABA_RegistedUser ruNew = new ABA_RegistedUser();

		ruNew.setOpenId(openId);
		ruNew.setNickName(nickName);
		ruNew.setSex(sex);
		ruNew.setProvince(province);
		ruNew.setCity(city);
		ruNew.setCountry(country);
		ruNew.setAvatar(avatar);
		ruNew.setPrivilege(privilege);
		ruNew.setUnionId(unionId);

		ABA_RegistedUser exist = this.ruMapper.findByPK(unionId);

		if (exist == null) {
			this.ruMapper.insert(ruNew);
		} else {
			this.ruMapper.update(ruNew);
		}

	}

	public static String getContent(InputStream is, String charset) {
		String pageString = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			pageString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb = null;
		}

		return pageString;
	}

	public String getVerifyType(String state) {
		String verifyType = "WEIXIN";
		
		if (Base64.isBase64(state)) {
			String decode = new String(Base64.decodeBase64(state));
			
			try {
				System.out.println(state + " => " + decode);
				JSONObject decodejson = JSON.parseObject(decode);
	
				verifyType = decodejson.getString("verifyType");
			} catch (JSONException e) {
				verifyType = "WEIXIN";
			}
		}

		return verifyType;
	}
	
	public String initOAuth(String verifyType) {
		String state = UUID.randomUUID().toString();
		
		String encode = new String("{'verifyType':'" + verifyType + "', 'state': '" + state + "'}");
		String encodeState = Base64.encodeBase64URLSafeString(encode.getBytes());
		ABA_OAuthCache oac = new ABA_OAuthCache();

		oac.setState(encodeState);

		int inserted = this.oacMapper.insert(oac);

		System.out.println(encodeState + " inserted " + inserted);
		
		return encodeState;
	}

	public boolean callbackOAuth(String code, String state) {

		ABA_OAuthCache oac = new ABA_OAuthCache();

		oac.setCode(code);
		oac.setState(state);

		int result = this.oacMapper.update(oac);

		return result == 1 ? true : false;
	}

	/**
	 * convert entity to Map
	 * 
	 * @param obj
	 * @param excludeProperties
	 * @param excludeZero
	 *            : 是否过滤zero
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 **/
	public static <T> Map<String, Object> entityToMap(Object model, Class<T> t, Map<String, Object> map) {
		try {
			Field[] fields = t.getDeclaredFields();
			if (fields.length > 0 && map == null)
				map = new HashMap<String, Object>();
			for (Field f : fields) {
				String name = f.getName();
				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法

				try {
					Method m = model.getClass().getMethod("get" + name);
					String value = String.valueOf(m.invoke(model));
					if (map != null && value != null)
						map.put(f.getName().toLowerCase(), value);
					else
						map.put(f.getName().toLowerCase(), "");
				} catch (NoSuchMethodException e) {
					continue;
				}
			}
			if (t.getSuperclass() != null) {
				entityToMap(model, t.getSuperclass(), map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
