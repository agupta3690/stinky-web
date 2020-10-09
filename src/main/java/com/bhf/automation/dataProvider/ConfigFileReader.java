package com.bhf.automation.dataProvider;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bhf.automation.enums.DriverType;
import com.bhf.automation.enums.EnvironmentType;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath= "src/test/resources/configs/configuration.properties";


	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
		}		
	}

	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

	public String getDriverPath(){
		String driverPath = properties.getProperty("chrome.driver");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}

	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitWait.time");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("publish.pro.testpage.qa2");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getTimeStamp() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy hh_mm");
		String Date = sdf.format(date);
		String formattedDate = Date.replaceAll(" ", "_");
		return formattedDate;
	}

		public DriverType getBrowser() {
			String browserName = properties.getProperty("browser");
			if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
			else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
			else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
			else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		}

		public EnvironmentType getEnvironment() {
			String environmentName = properties.getProperty("environment");
			if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
			else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
			else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		}

		public Boolean getBrowserWindowSize() {
			String windowSize = properties.getProperty("windowMaximize");
			if(windowSize != null) return Boolean.valueOf(windowSize);
			return true;
		}

	public String getUserDirectory () {
		String userDirectory = System.getProperty("user.dir");
		return userDirectory;
	}

	public HashMap<String, String> getvaluefromexcel() throws FilloException {
		String excellocation = properties.getProperty("testdata.file.location");
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(excellocation);
		String strquery = "Select * from Sheet1";
		HashMap<String,String> map = new HashMap<String, String>();
		List<String> newlist = new ArrayList<String>();
		Recordset recordset = connection.executeQuery(strquery);
		List<String> recordname = recordset.getFieldNames();
		while(recordset.next()){
			for (String test : recordname) {
				String values = recordset.getField(test);
				newlist.add(values);
			}
		}
		for(int i=0;i<recordname.size();i++){
			map.put(recordname.get(i), newlist.get(i));
		}
		//System.out.println(map);
		recordset.close();
		connection.close();
		return map;
	}
	}
