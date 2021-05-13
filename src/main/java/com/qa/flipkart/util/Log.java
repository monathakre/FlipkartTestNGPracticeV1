package com.qa.flipkart.util;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void startTest(String tcName) {
		log.info("*************************************************");
		log.info("*************************************************");
		log.info("$$$$$$$$$  "+tcName+"   $$$$$$$$$$");
		log.info("*************************************************");
		log.info("*************************************************");
	}
	
	public static void endTest(String tcName) {
		log.info("***********      -E-N-D-     ************");
		log.info("*************************************************");
	}
	
	public static void info(String msg) {
		log.info(msg);
	}
	
	public static void warn(String msg) {
		log.warn(msg);
	}
	
	public static void error(String msg) {
		log.error(msg);
	}
	
	public static void debug(String msg) {
		log.debug(msg);
	}
	
}
