package Interface;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import Common.CommonFunction;
import Common.Constant;

public class Interface_AccountInfo {
	public static String NAME_TXT_XPATH = "(//input[@class='form_input'])[1]";
	public static String EMAIL_TXT_XPATH = "(//input[@class='form_input'])[2]";
	public static String PHONE_TXT_XPATH = "(//input[@class='form_input'])[3]";
	public static String ADDRESS_TXT_XPATH = "(//input[@class='form_input'])[4]";
	public static String OLD_PWD_TXT_XPATH = "(//input[@class='form_input'])[5]";
	public static String NEW_PWD_TXT_XPATH = "(//input[@class='form_input'])[6]";
	public static String PWD_CFM_TXT_XPATH = "(//input[@class='form_input'])[7]";
	
	public static String UPDATE_ACCOUNT_INFO_BTN_XPATH = "//button[contains(text(),'Cập nhập thông tin')]";
	public static String UPDATE_PWD_BTN_XPATH = "//button[contains(text(),'Cập nhập mật khẩu')]";
	
	public static String SUCCESS_MSG_XPATH = "//div[@class='alert alert--success']";
	public static String ERROR_MSG_XPATH = "//div[@class='alert alert--error']";
	
	public static String UPDATE_ACCOUNT_INFO_SUCCESS_MSG = "Cập nhật thành công";
	public static String UPDATE_PWD_SUCCESS_MSG = "Update password success";
	public static String REQUIRED_MSG = "Please fill out this field.";
	public static String ALPHABET_MSG = "Only input alphabetical value.";
	public static String INVALID_EMAIL_MSG = "Please include an '@' in the email address.";
	public static String INVALID_PHONE_MSG = "Phone number must be 10 digits";
	public static String RELOGIN_MSG = "Refresh token is not valid,Please login again!";
	public static String NOT_MATCH_PWD_MSG = "Confirm password is not the same as password";
	
	public static WebDriver openScreen() throws Exception {
		WebDriver driver = null;
		driver = CommonFunction.initWebDriver(Constant.BASE_URL);
		CommonFunction.clickItem(driver, Interface_Home.LOGIN_LINK_XPATH);
		Interface_Login.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD, "", "");
		TimeUnit.SECONDS.sleep(5);
		CommonFunction.clickItem(driver, Interface_Home.USER_ICON_XPATH);
		CommonFunction.clickItem(driver, Interface_Home.MY_ACCOUNT_LINK_XPATH);
		return driver;
	}
	
	public static void updateAccountInfo(WebDriver driver, String name, String email, String phone, String address, String elementXpath, String expectedErrorMsg) throws Exception {
		CommonFunction.sendKeys(driver, NAME_TXT_XPATH, name);
		CommonFunction.sendKeys(driver, EMAIL_TXT_XPATH, email);
		CommonFunction.sendKeys(driver, PHONE_TXT_XPATH, phone);
		CommonFunction.sendKeys(driver, ADDRESS_TXT_XPATH, address);
		CommonFunction.clickItem(driver, UPDATE_ACCOUNT_INFO_BTN_XPATH);
		if (expectedErrorMsg == "") {
			CommonFunction.assertTextValue(driver, SUCCESS_MSG_XPATH, UPDATE_ACCOUNT_INFO_SUCCESS_MSG);
		}
		else {
			String actualErrorMsg = CommonFunction.getHTML5ValidationMessage(elementXpath);
			assertEquals(expectedErrorMsg, actualErrorMsg);
		}
	}
	
	public static void updatePassword(WebDriver driver, String oldPwd, String newPwd, String pwdCfm, String elementXpath, String expectedErrorMsg) throws Exception {
		CommonFunction.sendKeys(driver, OLD_PWD_TXT_XPATH, oldPwd);
		CommonFunction.sendKeys(driver, NEW_PWD_TXT_XPATH, newPwd);
		CommonFunction.sendKeys(driver, PWD_CFM_TXT_XPATH, pwdCfm);
		CommonFunction.clickItem(driver, UPDATE_PWD_BTN_XPATH);
		if (expectedErrorMsg == "") {
			CommonFunction.assertTextValue(driver, SUCCESS_MSG_XPATH, UPDATE_PWD_SUCCESS_MSG);
		}
		else if (expectedErrorMsg == NOT_MATCH_PWD_MSG) {
			CommonFunction.assertTextValue(driver, ERROR_MSG_XPATH, NOT_MATCH_PWD_MSG);
		}
		else {
			String actualErrorMsg = CommonFunction.getHTML5ValidationMessage(elementXpath);
			assertEquals(expectedErrorMsg, actualErrorMsg);
		}
	}
}
