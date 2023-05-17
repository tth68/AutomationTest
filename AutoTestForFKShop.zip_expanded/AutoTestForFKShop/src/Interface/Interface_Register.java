package Interface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import Common.CommonFunction;

public class Interface_Register {
	public static String NAME_TXT_XPATH = "//input[@placeholder='Name']";
	public static String EMAIL_TXT_XPATH = "//input[@placeholder='Email']";
	public static String PWD_TXT_XPATH = "//input[@placeholder='Password']";
	public static String PWD_CFM_TXT_XPATH = "//input[@placeholder='Password Confirm']";
	
	public static String REGISTER_BTN_XPATH = "//*[@class='register_form']//button";
	
	public static String SUCCESS_MSG_XPATH = "//div[@class='alert alert--success']";
	
	public static String SUCCESS_MSG = "Please check your email!";
	public static String REQUIRED_MSG = "Please fill out this field.";
	public static String ALPHABET_MSG = "Only input alphabetical value.";
	public static String INVALID_EMAIL_MSG = "Please include an '@' in the email address.";
	public static String NOT_MATCH_PWD_MSG = "Confirm password is not the same as password.";
	
	public static void register(WebDriver driver, String name, String email, String password, String passwordConfirm, String elementXpath, String expectedErrorMsg) throws Exception {
		CommonFunction.sendKeys(driver, NAME_TXT_XPATH, name);
		CommonFunction.sendKeys(driver, EMAIL_TXT_XPATH, email);
		CommonFunction.sendKeys(driver, PWD_TXT_XPATH, password);
		CommonFunction.sendKeys(driver, PWD_CFM_TXT_XPATH, passwordConfirm);
		CommonFunction.clickItem(driver, REGISTER_BTN_XPATH);
		if (expectedErrorMsg == "") {
			CommonFunction.assertTextValue(driver, SUCCESS_MSG_XPATH, SUCCESS_MSG);
		}
		else {
			String actualErrorMsg = CommonFunction.getHTML5ValidationMessage(elementXpath);
			assertEquals(expectedErrorMsg, actualErrorMsg);
		}
	}
}
