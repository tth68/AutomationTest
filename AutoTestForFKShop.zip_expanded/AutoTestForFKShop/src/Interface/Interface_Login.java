package Interface;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import Common.CommonFunction;

public class Interface_Login {
	public static String EMAIL_TXT_XPATH = "//input[@placeholder='Email']";
	public static String PWD_TXT_XPATH = "//input[@placeholder='Password']";
	
	public static String LOGIN_BTN_XPATH = "//*[@class='login_form']//button";
	public static String REGISTER_LINK_XPATH = "(//*[@class='login_form']//p)[1]";
	
	public static String SUCCESS_MSG_XPATH = "//div[@class='alert alert--success']";
	public static String ERROR_MSG_XPATH = "//div[@class='alert alert--error']";
	
	public static String SUCCESS_MSG = "Login success";
	public static String REQUIRED_MSG = "Please fill out this field.";
	public static String INVALID_EMAIL_MSG = "Please include an '@' in the email address.";
	public static String INCORRECT_PWD_MSG = "Incorrect password";
	
	public static void login(WebDriver driver, String email, String password, String elementXpath, String expectedErrorMsg) throws Exception {
		CommonFunction.sendKeys(driver, EMAIL_TXT_XPATH, email);
		CommonFunction.sendKeys(driver, PWD_TXT_XPATH, password);
		CommonFunction.clickItem(driver, LOGIN_BTN_XPATH);
		if (elementXpath == "" && expectedErrorMsg == "") {
			CommonFunction.assertTextValue(driver, SUCCESS_MSG_XPATH, SUCCESS_MSG);
		}
		else if (elementXpath == "") {
			CommonFunction.assertTextValue(driver, ERROR_MSG_XPATH, INCORRECT_PWD_MSG);
		}
		else {
			String actualErrorMsg = CommonFunction.getHTML5ValidationMessage(elementXpath);
			assertEquals(expectedErrorMsg, actualErrorMsg);
		}
	}
}
