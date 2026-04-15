package Com.DemoWebShop_GenericUtility;

public interface frameWorkConstants {
	
	JavaUtility jUtil = new JavaUtility();
	
	static final String excelFilePath="./src/test/resources/TestData/dataexcel.xlsx";
	
	static final String propertyFilePath="./src/test/resources/TestData/data.properties";
	
	static final String screenshotsPath="./ScreenShots/"+jUtil.localDateAndTime()+".png";
	
	static final String listenersScreenshotPath="./listenersScreenShots/"+jUtil.localDateAndTime()+".png";
	
	static final String reportsPath="./Reports/"+jUtil.localDateAndTime()+".html";
	

}
