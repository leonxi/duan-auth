package com.xiaoji.duan.aba.service.db;

public class CreateTable extends AbstractSql {

	public CreateTable() {
		initDdl();
	}

	private void initDdl() {

		ddl.add("" + 
				"CREATE TABLE IF NOT EXISTS `aba_oauthcache` (" +
				"  `CODE` varchar(64) DEFAULT NULL," +
				"  `STATE` varchar(128) NOT NULL," +
				"  `LOGON_TIME` datetime DEFAULT NULL," +
				"  `CREATE_TIME` date DEFAULT NULL," +
				"  PRIMARY KEY (`STATE`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
				"");

		ddl.add("" + 
				"CREATE TABLE IF NOT EXISTS `aba_onlineuser` (" +
				"  `ACCESS_TOKEN` varchar(128) NOT NULL," +
				"  `EXPIRES_IN` int(8) DEFAULT NULL," +
				"  `REFRESH_TOKEN` varchar(128) NOT NULL," +
				"  `OPENID` varchar(64) DEFAULT NULL," +
				"  `SCOPE` varchar(32) NOT NULL," +
				"  `UNIONID` varchar(128) NOT NULL," +
				"  `CODE` varchar(64) NOT NULL," +
				"  `LOGON_TIME` datetime DEFAULT NULL," +
				"  `CREATE_TIME` date DEFAULT NULL," +
				"  PRIMARY KEY (`UNIONID`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
				"");

		ddl.add("" + 
				"CREATE TABLE IF NOT EXISTS `aba_registeduser` (" +
				"  `OPENID` varchar(64) NOT NULL," +
				"  `NICKNAME` varchar(256) DEFAULT NULL," +
				"  `SEX` varchar(8) NOT NULL," +
				"  `PROVINCE` varchar(128) DEFAULT NULL," +
				"  `CITY` varchar(128) NOT NULL," +
				"  `COUNTRY` varchar(64) NOT NULL," +
				"  `AVATAR` varchar(256) NOT NULL," +
				"  `PRIVILEGE` varchar(256) NOT NULL," +
				"  `UNIONID` varchar(128) NOT NULL," +
				"  `CREATE_TIME` date DEFAULT NULL," +
				"  PRIMARY KEY (`UNIONID`)" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
				"");

	}
}
