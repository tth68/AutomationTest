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
import Interface.Interface_Products;

public class SearchProduct {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.BASE_URL);
		CommonFunction.clickItem(driver, Interface_Home.PRODUCTS_LINK_XPATH);
	}
			
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void TC_001() throws Exception {
		 CommonFunction.assertElementDisplayed(driver, Interface_Products.PRODUCT_NAME_XPATH);
	}
	
	@Test
	public void TC_002() throws Exception {
		CommonFunction.sendKeys(driver, Interface_Products.SEARCH_TXT_XPATH, Interface_Products.KEYWORD);
		 CommonFunction.assertElementDisplayed(driver, Interface_Products.PRODUCT_NAME_XPATH);
	}
	
	@Test
	public void TC_003() throws Exception {
		CommonFunction.sendKeys(driver, Interface_Products.SEARCH_TXT_XPATH, "      ");
		 CommonFunction.assertElementDisplayed(driver, Interface_Products.PRODUCT_NAME_XPATH);
	}
	
	@Test
	public void TC_004() throws Exception {
		CommonFunction.sendKeys(driver, Interface_Products.SEARCH_TXT_XPATH, "test");
		 CommonFunction.assertTextValue(driver, Interface_Products.MSG_XPATH, Interface_Products.NO_RESULT_MSG);
	}
	
	@Test
	public void TC_005() throws Exception {
		CommonFunction.sendKeys(driver, Interface_Products.SEARCH_TXT_XPATH, Interface_Products.KEYWORD.toUpperCase());
		 CommonFunction.assertElementDisplayed(driver, Interface_Products.PRODUCT_NAME_XPATH);
	}
}
