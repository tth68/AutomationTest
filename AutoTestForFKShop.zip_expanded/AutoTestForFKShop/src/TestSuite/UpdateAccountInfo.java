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
import Interface.Interface_AccountInfo;
import Interface.Interface_Home;

public class UpdateAccountInfo {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();

	@BeforeClass
	public static void setUp() throws Exception {
		driver = Interface_AccountInfo.openScreen();
	}
			
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.clickItem(driver, Interface_Home.USER_ICON_XPATH);
		CommonFunction.clickItem(driver, Interface_Home.MY_ACCOUNT_LINK_XPATH);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void TC_001() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_002() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, "", Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.NAME_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_003() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, "          ", Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.NAME_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_004() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.SPECIAL_CHARS, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.NAME_TXT_XPATH, Interface_AccountInfo.ALPHABET_MSG);
	}
	
	@Test
	public void TC_005() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.NUMERIC_CHARS, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.NAME_TXT_XPATH, Interface_AccountInfo.ALPHABET_MSG);
	}
	
	@Test
	public void TC_006() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_007() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_008() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, "", Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.EMAIL_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_009() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, "         ", Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.EMAIL_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_010() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.SPECIAL_CHARS, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.EMAIL_TXT_XPATH, Interface_AccountInfo.INVALID_EMAIL_MSG);
	}
	
	@Test
	public void TC_011() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.NUMERIC_CHARS, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.EMAIL_TXT_XPATH, Interface_AccountInfo.INVALID_EMAIL_MSG);
	}
	
	@Test
	public void TC_012() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.INVALID_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, Interface_AccountInfo.EMAIL_TXT_XPATH, Interface_AccountInfo.INVALID_EMAIL_MSG);
	}
	
	@Test
	public void TC_013() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, "", Constant.BASE_ADDRESS, Interface_AccountInfo.PHONE_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_014() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, "         ", Constant.BASE_ADDRESS, Interface_AccountInfo.PHONE_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_015() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.SPECIAL_CHARS, Constant.BASE_ADDRESS, Interface_AccountInfo.PHONE_TXT_XPATH, Interface_AccountInfo.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_016() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, "012345678", Constant.BASE_ADDRESS, Interface_AccountInfo.PHONE_TXT_XPATH, Interface_AccountInfo.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_017() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, "01234567890", Constant.BASE_ADDRESS, Interface_AccountInfo.PHONE_TXT_XPATH, Interface_AccountInfo.INVALID_PHONE_MSG);
	}
	
	@Test
	public void TC_018() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_019() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, Constant.BASE_ADDRESS, "", "");
	}
	
	@Test
	public void TC_020() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, "", Interface_AccountInfo.ADDRESS_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_021() throws Exception {
		Interface_AccountInfo.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_EMAIL, Constant.BASE_PHONE, "         ", Interface_AccountInfo.ADDRESS_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
}
