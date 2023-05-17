package Interface;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import Common.CommonFunction;

public class Interface_Cart {
	public static String NAME_TXT_XPATH = "//input[@name='firstname']";
	public static String PHONE_TXT_XPATH = "//input[@name='number']";
	public static String ADDRESS_TXT_XPATH = "//input[@name='address']";

	public static String CHECKOUT_BTN_XPATH = "//button[contains(text(),'Check out')]";
	public static String ORDER_BTN_XPATH = "//button[contains(text(),'Đặt hàng')]";
	
	public static String SUCCESS_MSG_XPATH = "//div[@class='alert alert--success']";
	public static String ERROR_MSG_XPATH = "//div[@class='alert alert--error']";
	public static String ORDER_STATUS_TXT_XPATH = "//p[text()='pending']";
	
	public static String SUCCESS_MSG = "Đặt hàng thành công";
	public static String REQUIRED_MSG = "Please fill out this field.";
	public static String ALPHABET_MSG = "Only input alphabetical value.";
	public static String INVALID_PHONE_MSG = "Phone number must be 10 digits";
	
	public static void openScreen(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, Interface_Home.PRODUCTS_LINK_XPATH);
		CommonFunction.clickItem(driver, Interface_Products.DETAIL_BTN_XPATH.replace("INDEX", "1"));
		CommonFunction.clickItem(driver, Interface_ProductDetail.ADD_TO_CART_BTN_XPATH);
		CommonFunction.clickItem(driver, Interface_Home.CART_ICON_XPATH);
		CommonFunction.clickItem(driver, Interface_Cart.CHECKOUT_BTN_XPATH);
		TimeUnit.SECONDS.sleep(3);
	}
	public static void order(WebDriver driver, String name, String phone, String address, String elementXpath, String expectedErrorMsg) throws Exception {
		CommonFunction.sendKeys(driver, NAME_TXT_XPATH, name);
		CommonFunction.sendKeys(driver, PHONE_TXT_XPATH, phone);
		CommonFunction.sendKeys(driver, ADDRESS_TXT_XPATH, address);
		CommonFunction.clickItem(driver, ORDER_BTN_XPATH);
		if (expectedErrorMsg == "") {
			CommonFunction.assertTextValue(driver, SUCCESS_MSG_XPATH, SUCCESS_MSG);
			CommonFunction.assertElementDisplayed(driver, Interface_Home.TOTAL_QTY_ICON_XPATH.replace("QTY", "0"));
			CommonFunction.assertElementDisplayed(driver, ORDER_STATUS_TXT_XPATH);
		}
		else {
			String actualErrorMsg = CommonFunction.getHTML5ValidationMessage(elementXpath);
			assertEquals(expectedErrorMsg, actualErrorMsg);
		}
	}
}
