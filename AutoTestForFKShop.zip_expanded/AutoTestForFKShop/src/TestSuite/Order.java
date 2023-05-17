package TestSuite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Common.CommonFunction;
import Common.Constant;
import Interface.Interface_Cart;
import Interface.Interface_Home;
import Interface.Interface_Login;

public class Order {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();

	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.BASE_URL);
		CommonFunction.clickItem(driver, Interface_Home.LOGIN_LINK_XPATH);
		Interface_Login.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD, "", "");
		TimeUnit.SECONDS.sleep(5);
	}
	
	@Before
	public void setUp() throws Exception {
		Interface_Cart.openScreen(driver);
	}

	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		TimeUnit.SECONDS.sleep(10);
	}

	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}
	
	@Test
	public void TC_001() throws Exception {
		CommonFunction.assertElementDisplayed(driver, Interface_Cart.ORDER_BTN_XPATH);
	}

	@Test
	public void TC_002() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_003() throws Exception {
		Interface_Cart.order(driver, "", Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_Cart.NAME_TXT_XPATH, Interface_Cart.REQUIRED_MSG);
	}

	@Test
	public void TC_004() throws Exception {
		Interface_Cart.order(driver, "          ", Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_Cart.NAME_TXT_XPATH, Interface_Cart.REQUIRED_MSG);
	}
	
	@Test
	public void TC_005() throws Exception {
		Interface_Cart.order(driver, Constant.SPECIAL_CHARS, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_006() throws Exception {
		Interface_Cart.order(driver, Constant.NUMERIC_CHARS, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_007() throws Exception {
		Interface_Cart.order(driver, Constant.ALPHABET_CHARS, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_008() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, "", Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.REQUIRED_MSG);
	}
	
	@Test
	public void TC_009() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, "          ", Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.REQUIRED_MSG);
	}
	
	@Test
	public void TC_010() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.SPECIAL_CHARS, Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_011() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, "012345678", Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_012() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, "01234567890", Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_013() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_014() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.ALPHABET_CHARS, Constant.BASE_ADDRESS, Interface_Cart.PHONE_TXT_XPATH, Interface_Cart.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_015() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, "", Interface_Cart.ADDRESS_TXT_XPATH, Interface_Cart.REQUIRED_MSG);
	}
	
	@Test
	public void TC_016() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, "          ", Interface_Cart.ADDRESS_TXT_XPATH, Interface_Cart.REQUIRED_MSG);
	}
	
	@Test
	public void TC_017() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, Constant.SPECIAL_CHARS, "", "");
	}
	
	@Test
	public void TC_018() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, Constant.NUMERIC_CHARS, "", "");
	}
	
	@Test
	public void TC_019() throws Exception {
		Interface_Cart.order(driver, Constant.BASE_NAME, Constant.BASE_PHONE, Constant.ALPHABET_CHARS, "", "");
	}
}
