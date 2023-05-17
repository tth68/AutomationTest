package Interface;

import org.openqa.selenium.WebDriver;

import Common.CommonFunction;

public class Interface_Home {
	public static String LOGIN_LINK_XPATH = "(//div[@class='header_user']//a)[2]";
	public static String CART_ICON_XPATH = "//div[@class='header_icon header_cart']";
	public static String TOTAL_QTY_ICON_XPATH = "(//div[@class='header_icon header_cart' and @totalqty='QTY'])[1]";
	public static String USER_ICON_XPATH = "//*[@class='header_icons']";
	public static String MY_ACCOUNT_LINK_XPATH = "//a[contains(text(),'My account')]";
	public static String LOGOUT_LINK_XPATH = "//div[@class='user']//div[@class='container']";
	public static String PRODUCTS_LINK_XPATH = "(//a[text()='Products'])[1]";
	
	public static String SUCCESS_MSG_XPATH = "//div[@class='alert alert--success']";
	
	public static String LOGOUT_SUCCESS_MSG = "You are loggedout";
	
	public static void logout(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, USER_ICON_XPATH);
		CommonFunction.clickItem(driver, LOGOUT_LINK_XPATH);
		CommonFunction.assertTextValue(driver, SUCCESS_MSG_XPATH, LOGOUT_SUCCESS_MSG);
	}
	
}
