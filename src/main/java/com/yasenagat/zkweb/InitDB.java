package com.yasenagat.zkweb;

import com.yasenagat.zkweb.util.ZkCfgManager;
import com.yasenagat.zkweb.util.ZkCfgManagerImpl;

public class InitDB {

	
	public static void main(String[] arg){
		ZkCfgManager db = new ZkCfgManagerImpl();
		db.init();
	}
	
}
