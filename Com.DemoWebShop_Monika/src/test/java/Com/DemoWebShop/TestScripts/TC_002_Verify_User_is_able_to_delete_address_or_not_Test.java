package Com.DemoWebShop.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addresses_Page;
import Com.DemoWebShop_POM.addNewPage;

public class TC_002_Verify_User_is_able_to_delete_address_or_not_Test extends BaseTest{
	
	@Test
	public void deleteAddress() throws InterruptedException, EncryptedDocumentException, IOException  {
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
		
		Addresses_Page addressesPage=new Addresses_Page(driver);
		addressesPage.getDeleteBtn().click();
		Thread.sleep(2000);
		webDriverUtility.alertForAccept(driver);
		
		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);
		
	}

}
