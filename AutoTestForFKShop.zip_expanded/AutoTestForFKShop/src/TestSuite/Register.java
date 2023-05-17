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
import Interface.Interface_Register;

public class Register {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.BASE_URL);
		CommonFunction.clickItem(driver, Interface_Home.LOGIN_LINK_XPATH);
		CommonFunction.clickItem(driver, Interface_Login.REGISTER_LINK_XPATH);
	}
			
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void TC_001() throws Exception {
		Interface_Register.register(driver, "test", "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, ""); 
	}
	
	@Test
	public void TC_002() throws Exception {
		Interface_Register.register(driver, "", "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_003() throws Exception {
		Interface_Register.register(driver, "      ", "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_004() throws Exception {
		Interface_Register.register(driver, Constant.SPECIAL_CHARS, "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.ALPHABET_MSG); 
	}
	
	@Test
	public void TC_005() throws Exception {
		Interface_Register.register(driver, Constant.NUMERIC_CHARS, "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.ALPHABET_MSG); 
	}
	
	@Test
	public void TC_006() throws Exception {
		Interface_Register.register(driver, "test for name", "testforname@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, ""); 
	}
	
	@Test
	public void TC_007() throws Exception {
		Interface_Register.register(driver, "test1", "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.ALPHABET_MSG); 
	}
	
	@Test
	public void TC_008() throws Exception {
		Interface_Register.register(driver, "test^&*(", "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.ALPHABET_MSG); 
	}
	
	@Test
	public void TC_009() throws Exception {
		Interface_Register.register(driver, "1234^&*(", "test@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.NAME_TXT_XPATH, Interface_Register.ALPHABET_MSG); 
	}
	
	@Test
	public void TC_010() throws Exception {
		Interface_Register.register(driver, "test for email", "testforemail@gmail.com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.EMAIL_TXT_XPATH, ""); 
	}
	
	@Test
	public void TC_011() throws Exception {
		Interface_Register.register(driver, "test for email", "", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.EMAIL_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_012() throws Exception {
		Interface_Register.register(driver, "test for email", "          ", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.EMAIL_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_013() throws Exception {
		Interface_Register.register(driver, "test for email", Constant.SPECIAL_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.EMAIL_TXT_XPATH, Interface_Register.INVALID_EMAIL_MSG); 
	}
	
	@Test
	public void TC_014() throws Exception {
		Interface_Register.register(driver, "test for email", Constant.NUMERIC_CHARS, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.EMAIL_TXT_XPATH, Interface_Register.INVALID_EMAIL_MSG); 
	}
	
	@Test
	public void TC_015() throws Exception {
		Interface_Register.register(driver, "test for email", "abc.@com", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Interface_Register.EMAIL_TXT_XPATH, Interface_Register.INVALID_EMAIL_MSG); 
	}
	
	@Test
	public void TC_016() throws Exception {
		Interface_Register.register(driver, "test for password", "testforpassword@gmail.com", "", Constant.BASE_PASSWORD, Interface_Register.PWD_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_017() throws Exception {
		Interface_Register.register(driver, "test for password", "testforpassword@gmail.com", "      ", Constant.BASE_PASSWORD, Interface_Register.PWD_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_018() throws Exception {
		Interface_Register.register(driver, "test for password", "testforpassword@gmail.com", Constant.SPECIAL_CHARS, Constant.SPECIAL_CHARS, Interface_Register.PWD_TXT_XPATH, ""); 
	}
	
	@Test
	public void TC_019() throws Exception {
		Interface_Register.register(driver, "test for password", "testforpassword@gmail.com", Constant.NUMERIC_CHARS, Constant.NUMERIC_CHARS, Interface_Register.PWD_TXT_XPATH, ""); 
	}
	
	@Test
	public void TC_020() throws Exception {
		Interface_Register.register(driver, "test for password", "testforpassword@gmail.com", "test for password", "test for password", Interface_Register.PWD_TXT_XPATH, ""); 
	}
	
	@Test
	public void TC_021() throws Exception {
		Interface_Register.register(driver, "test for password confirm", "testforpasswordconfirm@gmail.com", Constant.BASE_PASSWORD, "", Interface_Register.PWD_CFM_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_022() throws Exception {
		Interface_Register.register(driver, "test for password confirm", "testforpasswordconfirm@gmail.com", Constant.BASE_PASSWORD, "      ", Interface_Register.PWD_CFM_TXT_XPATH, Interface_Register.REQUIRED_MSG); 
	}
	
	@Test
	public void TC_023() throws Exception {
		Interface_Register.register(driver, "test for password confirm", "testforpasswordconfirm@gmail.com", Constant.BASE_PASSWORD, Constant.NUMERIC_CHARS, Interface_Register.PWD_CFM_TXT_XPATH, Interface_Register.NOT_MATCH_PWD_MSG); 
	}
}
