package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addNewPage {
	public addNewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id = "Address_LastName")
	private WebElement lastNameTextField;
	
	@FindBy(id = "Address_Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Address_CountryId")
	private WebElement countryTextField;
	
	@FindBy(id = "Address_City")
	private WebElement cityTextField;
	
	@FindBy(id = "Address_Address1")
	private WebElement address1TextField;
	
	
	@FindBy(name = "Address.ZipPostalCode")
	private WebElement zipCodeTextField;
	
	@FindBy(xpath = "//input[@data-val-required='Phone is required']")
	private WebElement phoneNumberTextField;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveBtn;

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddress1TextField() {
		return address1TextField;
	}


	public WebElement getZipCodeTextField() {
		return zipCodeTextField;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
