package Common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonFunction {
	private static WebDriver driver = null;

	public static WebDriver initWebDriver(String url) {
		System.setProperty(Constant.DRIVER_KEY, Constant.DRIVER_KEY_LOCATION);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public static void shutDownDriver(WebDriver driver) throws InterruptedException {
		driver.close();
		TimeUnit.SECONDS.sleep(3);
	}

	public static void clickItem(WebDriver driver, String elementXpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		element.click();
		TimeUnit.SECONDS.sleep(1);
	}

	public static WebElement getWebElementByXpath(WebDriver driver, String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	public static void clearText(WebElement element) {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	public static void sendKeys(WebDriver driver, String elementXpath, String inputData) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		if (!inputData.isEmpty()) {
			element.sendKeys(inputData);
		}
	}
	
	public static void selectListBox(WebDriver driver, String elementXpath, String selectedItem) throws InterruptedException {
		if (selectedItem != null) {
			WebElement listbox = driver.findElement(By.xpath(elementXpath));
			// Select item
			Select select = new Select(listbox);
			select.selectByVisibleText(selectedItem);
			TimeUnit.SECONDS.sleep(3);
		}
	}
		
	public static void assertTextValue(WebDriver driver, String elementXpath, String expectedText) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		String actualText = element.getText();
		assertEquals(expectedText, actualText);
	}
	
	public static void assertContainTextValue(WebDriver driver, String elementXpath, String expectErrMsg) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		String textValue = element.getText();
		assertTrue(textValue.contains(expectErrMsg));
	}
	
	public static void assertElementDisplayed(WebDriver driver, String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		assertTrue(element.isDisplayed(), element.toString() + " is not displayed");	
	}
	
	public static String getHTML5ValidationMessage(String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}
	
	public static void refreshScreen(WebDriver driver) throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void captureScreen(WebDriver driver, String folderName, String testcase) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folderPath = "./result/" + folderName + "/";
		String filePath = folderPath + testcase + ".jpg";
		File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
		Files.copy(scrFile.toPath(), new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
}
