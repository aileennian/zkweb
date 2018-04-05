package com.yasenagat.zkweb.util;

public class InitDB {

	
	public static void main(String[] arg){
		ZkCfgManager db = new ZkCfgManagerImpl();
		db.init();
	}
	
}
