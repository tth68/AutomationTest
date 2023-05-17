package TestSuite;

import java.util.concurrent.TimeUnit;

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

public class UpdatePassword {
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
		TimeUnit.SECONDS.sleep(3);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void TC_001() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "", "");
	}
	
	@Test
	public void TC_002() throws Exception {
		Interface_AccountInfo.updatePassword(driver, "", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_AccountInfo.OLD_PWD_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_003() throws Exception {
		Interface_AccountInfo.updatePassword(driver, "        ", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_AccountInfo.OLD_PWD_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_004() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, "", Constant.BASE_PASSWORD, Interface_AccountInfo.NEW_PWD_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_005() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, "        ", Constant.BASE_PASSWORD, Interface_AccountInfo.NEW_PWD_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_006() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.SPECIAL_CHARS, Constant.SPECIAL_CHARS, "", "");
		CommonFunction.clickItem(driver, Interface_Home.USER_ICON_XPATH);
		CommonFunction.clickItem(driver, Interface_Home.MY_ACCOUNT_LINK_XPATH);
		TimeUnit.SECONDS.sleep(3);
		Interface_AccountInfo.updatePassword(driver, Constant.SPECIAL_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "", "");
	}
	
	@Test
	public void TC_007() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.NUMERIC_CHARS, Constant.NUMERIC_CHARS, "", "");
		CommonFunction.clickItem(driver, Interface_Home.USER_ICON_XPATH);
		CommonFunction.clickItem(driver, Interface_Home.MY_ACCOUNT_LINK_XPATH);
		TimeUnit.SECONDS.sleep(3);
		Interface_AccountInfo.updatePassword(driver, Constant.NUMERIC_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "", "");
	}
	
	@Test
	public void TC_008() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.ALPHABET_CHARS, Constant.ALPHABET_CHARS, "", "");
		CommonFunction.clickItem(driver, Interface_Home.USER_ICON_XPATH);
		CommonFunction.clickItem(driver, Interface_Home.MY_ACCOUNT_LINK_XPATH);
		TimeUnit.SECONDS.sleep(3);
		Interface_AccountInfo.updatePassword(driver, Constant.ALPHABET_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "", "");
	}
	
	@Test
	public void TC_009() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "", Interface_AccountInfo.PWD_CFM_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_010() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "        ", Interface_AccountInfo.PWD_CFM_TXT_XPATH, Interface_AccountInfo.REQUIRED_MSG);
	}
	
	@Test
	public void TC_011() throws Exception {
		Interface_AccountInfo.updatePassword(driver, Constant.BASE_PASSWORD, Constant.NUMERIC_CHARS, Constant.BASE_PASSWORD, "", Interface_AccountInfo.NOT_MATCH_PWD_MSG);
	}
}
