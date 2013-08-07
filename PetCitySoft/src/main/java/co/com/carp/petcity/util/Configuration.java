package co.com.carp.petcity.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * This class is attempt to control all necessary configuration that will be load from config.property file
 * 
 * @author Carlos Rodriguez
 *
 */
public class Configuration {
	
	private static Configuration configuration = new Configuration();
	
	public static final String JDBC_USER_NAME = "jdbc.username";
	
	public static final String JDBC_PASSWORD = "jdbc.password";
	
	public static final String JDBC_DRIVER = "jdbc.driver";
	
	public static final String JDBC_HOSTNAME = "jdbc.hostname";
	
	public static final String JDBC_PORT = "jdbc.port";
	
	public static final String JDBC_SCHEMA = "jdbc.schema";

	  private Configuration() {
		  super();
	  }

	  public static Configuration getInstance() {
	    return configuration;
	  }
	  
	  public Map<String, String> readConfiguration() {
		  Properties prop = new Properties();
		  Map<String, String> configMap = new TreeMap<>();
		  try {
			  prop.load(Configuration.class.getResourceAsStream("/co/com/carp/petcity/configuration/config.properties"));
			  configMap.put(JDBC_USER_NAME, prop.getProperty(JDBC_USER_NAME));
			  configMap.put(JDBC_PASSWORD, prop.getProperty(JDBC_PASSWORD));
			  configMap.put(JDBC_DRIVER, prop.getProperty(JDBC_DRIVER));
			  configMap.put(JDBC_HOSTNAME, prop.getProperty(JDBC_HOSTNAME));
			  configMap.put(JDBC_PORT, prop.getProperty(JDBC_PORT));
			  configMap.put(JDBC_SCHEMA, prop.getProperty(JDBC_SCHEMA));
		  } catch (IOException ex) {
			  ex.printStackTrace();
		  }
		  return configMap;
	  }

}
