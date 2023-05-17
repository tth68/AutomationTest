package TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Common.CommonFunction;
import Common.Constant;
import Interface.Interface_Home;
import Interface.Interface_Login;

public class Login {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.BASE_URL);
		CommonFunction.clickItem(driver, Interface_Home.LOGIN_LINK_XPATH);
	}
			
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void TC_002() throws Exception {
		 Interface_Login.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD, "", "");
	}
	
	@Test
	public void TC_003() throws Exception {
		 Interface_Login.login(driver, "", Constant.BASE_PASSWORD, Interface_Login.EMAIL_TXT_XPATH, Interface_Login.REQUIRED_MSG);
	}
	
	@Test
	public void TC_004() throws Exception {
		 Interface_Login.login(driver, "      ", Constant.BASE_PASSWORD, Interface_Login.EMAIL_TXT_XPATH, Interface_Login.REQUIRED_MSG);
	}
	
	@Test
	public void TC_005() throws Exception {
		 Interface_Login.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD, "", "");
	}
	
	@Test
	public void TC_006() throws Exception {
		 Interface_Login.login(driver, Constant.INVALID_EMAIL, Constant.BASE_PASSWORD, Interface_Login.EMAIL_TXT_XPATH, Interface_Login.INVALID_EMAIL_MSG);
	}
	
	@Test
	public void TC_007() throws Exception {
		Interface_Login.login(driver, Constant.BASE_EMAIL, "", Interface_Login.PWD_TXT_XPATH, Interface_Login.REQUIRED_MSG);
	}
	
	@Test
	public void TC_008() throws Exception {
		Interface_Login.login(driver, Constant.BASE_EMAIL, "      ", Interface_Login.PWD_TXT_XPATH, Interface_Login.REQUIRED_MSG);
	}
	
	@Test
	public void TC_009() throws Exception {
		Interface_Login.login(driver, Constant.BASE_EMAIL, "@#$%", "", Interface_Login.INCORRECT_PWD_MSG);
	}
	
	@Test
	public void TC_010() throws Exception {
		Interface_Login.login(driver, Constant.BASE_EMAIL, "12345678", "", "");
	}
	
	@Test
	public void TC_011() throws Exception {
		Interface_Login.login(driver, Constant.BASE_EMAIL, "test for password", "", Interface_Login.INCORRECT_PWD_MSG);
	}
}
