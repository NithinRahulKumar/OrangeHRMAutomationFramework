package com.self.constants;

import com.self.enums.ConfigProperties;
import com.self.utils.PropertyUtils;

public class FrameworkConstants {
	private FrameworkConstants() {
	}
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH= RESOURCESPATH+"/config/config.properties";
	private static final long IMPLICITWAITTIME= 10;
	private static final long EXPLICITWAITTIME= 10;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static final String EXCELPATH = RESOURCESPATH+"/excel/testdata.xlsx";
	private static String extentReportFilePath= "";
	private static final String RUNMANAGERDATASHEET= "RUNMANAGER";
	
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	public static long getExplicitWaitTime() {
		return EXPLICITWAITTIME;
	}
	public static long getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}
	
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath() {
		if(PropertyUtils.getProperty(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	public static String getExcelPath() {
		return EXCELPATH;
	}
	public static String getRunManagerDataSheet() {
		return RUNMANAGERDATASHEET;
	}
	

	
	
}
