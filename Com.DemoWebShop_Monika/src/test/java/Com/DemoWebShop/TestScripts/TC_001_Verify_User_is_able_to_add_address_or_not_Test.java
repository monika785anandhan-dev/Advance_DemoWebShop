package Com.DemoWebShop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addresses_Page;
import Com.DemoWebShop_POM.addNewPage;

public class TC_001_Verify_User_is_able_to_add_address_or_not_Test extends BaseTest{
	
	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException  {
		
		System.out.println("Started executing addAddress");
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
		
		Addresses_Page addressesPage=new Addresses_Page(driver);
		webDriverUtility.javaScriptScrollToElement(driver, addressesPage.getAddnewBtn());
		addressesPage.getAddnewBtn().click();
		
		addNewPage addnewpage=new addNewPage(driver);
		addnewpage.getFirstNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 0));
		addnewpage.getLastNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 1));
		addnewpage.getEmailTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 2));
		
		webDriverUtility.selectByVisibleText(addnewpage.getCountryTextField(), fileutility.readDataFromExcelFile("Sheet1", 1, 3));
		
		addnewpage.getCityTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 4));
		addnewpage.getAddress1TextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 5));
		addnewpage.getZipCodeTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 6));
		addnewpage.getPhoneNumberTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 7));
		addnewpage.getSaveBtn().click();
		
		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);
		
	}

}
