package TestSuite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Common.CommonFunction;
import Common.Constant;
import Interface.Interface_Home;
import Interface.Interface_ProductDetail;
import Interface.Interface_Products;

public class AddToCart {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule
	public TestName name = new TestName();

	@BeforeClass
	public static void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.BASE_URL);
	}

	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
	}

	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}
	
	@Test
	public void TC_001() throws Exception {
		CommonFunction.clickItem(driver, Interface_Home.PRODUCTS_LINK_XPATH);
		CommonFunction.clickItem(driver, Interface_Products.DETAIL_BTN_XPATH.replace("INDEX", "1"));
		CommonFunction.clickItem(driver, Interface_ProductDetail.ADD_TO_CART_BTN_XPATH);
		CommonFunction.assertTextValue(driver, Interface_ProductDetail.SUCCESS_MSG_XPATH,
				Interface_ProductDetail.SUCCESS_MSG);
		CommonFunction.assertElementDisplayed(driver, Interface_Home.TOTAL_QTY_ICON_XPATH.replace("QTY", "1"));
	}

	@Test
	public void TC_002() throws Exception {
		CommonFunction.clickItem(driver, Interface_Home.PRODUCTS_LINK_XPATH);
		CommonFunction.clickItem(driver, Interface_Products.DETAIL_BTN_XPATH.replace("INDEX", "1"));
		CommonFunction.clickItem(driver, Interface_ProductDetail.ADD_TO_CART_BTN_XPATH);
		CommonFunction.assertTextValue(driver, Interface_ProductDetail.SUCCESS_MSG_XPATH,
				Interface_ProductDetail.SUCCESS_MSG);
		CommonFunction.assertElementDisplayed(driver, Interface_Home.TOTAL_QTY_ICON_XPATH.replace("QTY", "2"));
	}
	
	@Test
	public void TC_003() throws Exception {
		CommonFunction.clickItem(driver, Interface_Home.PRODUCTS_LINK_XPATH);
		CommonFunction.clickItem(driver, Interface_Products.DETAIL_BTN_XPATH.replace("INDEX", "2"));
		CommonFunction.clickItem(driver, Interface_ProductDetail.ADD_TO_CART_BTN_XPATH);
		CommonFunction.assertTextValue(driver, Interface_ProductDetail.SUCCESS_MSG_XPATH,
				Interface_ProductDetail.SUCCESS_MSG);
		CommonFunction.assertElementDisplayed(driver, Interface_Home.TOTAL_QTY_ICON_XPATH.replace("QTY", "3"));
	}

}
