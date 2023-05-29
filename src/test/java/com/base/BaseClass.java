package com.base;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author RAMKUMAR
 * @see used to maintains all reusable methods
 * @date 16/feb/23
 *
 */
public class BaseClass {
	public static WebDriver driver;
		/**
	 * @see used to browse the launch
	 */
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
	}


	/**
	 * @see used to getProjectPath return path
	 * @return String
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}
	public byte[] screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	
		//TakeScreenShot screenshot=(TakeScreenshort).driver;
		
	}

	/**
	 * @see used to getPropertyFileValue return url
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		String path = System.getProperty("user.dir");
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object object = properties.get(key);
		String url = (String) object;
		return url;
	}

	/**
	 * @see used to getDriver browser lunch
	 * @param browertype
	 */
	public static void getDriver(String browertype) {
		switch (browertype) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "fireFox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
	}

	

	/**
	 * @see used to enter the url
	 * @param url
	 */
	public static void enterAppInurl(String url) {
		driver.get(url);
	}

	/**
	 * @see used to maximize window
	 */
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @see used to insert value in textbox
	 * @param element
	 * @param data
	 */
	// 3.insert value in textbox
	public void elementsendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * @see used to click button
	 * @param element
	 */
	// 4.click button
	public void elementclick(WebElement element) {
		element.click();

	}

	/**
	 * @see used to click ok in alart
	 */
	// 5.clcick ok in alart
	public void alart() {
		Alert a1 = driver.switchTo().alert();
		a1.accept();
	}

	/**
	 * @see used to click cancel in alart box
	 */
	// 6.click cancel in alert box
	public void dismissalert() {
		Alert a2 = driver.switchTo().alert();
		a2.dismiss();

	}

	/**
	 * @see used to get the text from webpage
	 * @param element
	 * @return String
	 */
	// 7.get the text from webpage
	public String gettext(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see used to get the inserted value from textbox
	 * @param element
	 * @return String
	 */
	// 8.get the inserted value from textbox
	public String getattributevalue(WebElement element,String data) {
		String attribute = element.getAttribute(data);
		return attribute;

	}

	/**
	 * @see used to close all window
	 */
	// 9.close all window
	public void closeallwindow() {
		driver.quit();
	}

	/**
	 * @see used to close current window
	 */
	// 10.close current window
	public void clcurentwindow() {
		driver.close();
	}

	/**
	 * @see used to get the title
	 * @return String
	 */
	// 11.get the title
	public String title() {
		String title = driver.getTitle();
		return title;

	}

	/**
	 * @see used to get the entered url
	 * @return String
	 */
	// 12.get the entered url
	public String enteredurl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see used to select dropdown option by text
	 * @param element
	 * @param value
	 * @return String
	 */
	// 13.select dropdown option by text
	public Select selectByText(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
		return s;

	}

	/**
	 * @see select dropdown option by attribute
	 * @param element
	 * @param value
	 * @return
	 */
	// 14.select dropdown option by attribute
	public Select SelectByAttribute(WebElement element, String value) {
		Select s1 = new Select(element);
		s1.selectByValue(value);
		return s1;

	}

	/**
	 * @see used to select dropdown option by index
	 * @param element
	 * @param num
	 * @return Select
	 */
	// 15.select dropdown option by index
	public Select SelectByIndex(WebElement element, int num) {
		Select s2 = new Select(element);
		s2.selectByIndex(num);
		return s2;
	}

	/**
	 * @see used to insert value in textbox by js
	 * @param element
	 * @param data
	 */
	// 16.insert value in textbox by js
	public void InsertTextBoxjs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setattribute('value','" + data + "')", element);
	}

	/**
	 * @see used to click by js
	 * @param element
	 */
	// 17.click by js
	public void ClickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	/**
	 * @see used to lanuch the chromebrowser
	 */
	// 18.lanuch the chrome browser
	public void ChromeBrowser() {
		WebDriver driver = new ChromeDriver();
	}

	/**
	 * @see used to switch to child window
	 * @param id
	 */
	// 19.switch to child window
	public void ChildWindow(String id) {
		driver.switchTo().window(id);
	}

	/**
	 * @see used to switch to frame by frame id
	 * @param value
	 */
	// 20.switch to frame by frame id
	public void SwitchToFrameId(int value) {
		driver.switchTo().frame(value);
	}

	/**
	 * @see used to switch to frame by index
	 * @param position
	 */
	// 21.switch to frame by index
	public void SwitchToFrameIndex(int position) {
		driver.switchTo().frame(position);
	}

	/**
	 * @see used to find locatore by id
	 * @param id
	 * @return WebElement
	 */
	// 22.find locatore by id
	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	/**
	 * @see used to find locator by name
	 * @param attributevalue
	 * @return WebElemnet
	 */
	// 23.find locator by name
	public WebElement findElementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	/**
	 * @see used to find locatore by classname
	 * @param attributevalue
	 * @return WebElement
	 */
	// 24.find locatore by classname
	public WebElement findElementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	/**
	 * @see used to find locatore by xpath
	 * @param xpathExp
	 * @return WebElement
	 */
	// 25.find locatore by xpath
	public WebElement findElementByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

	/**
	 * @see used to get all options from dropdown as text
	 * @param element
	 * @param text
	 * @return String
	 */
	// 26.get all options from dropdown as text
	public String allOptionsText(WebElement element, String text) {
		Select s1 = new Select(element);
		String text2 = element.getText();
		s1.selectByVisibleText(text2);
		return text2;
	}

	/**
	 * @see used to get all options dropdown as attributvalue
	 * @param element
	 * @param value
	 * @return List<WebElement>
	 */

	// 27.get all options from dropdown as attributevalue
	public List AllOptionsTextAttribute(WebElement element, String value) {
		Select s = new Select(element);
		List<WebElement> option = s.getOptions();
		for (int i = 0; i < option.size(); i++) {
			WebElement element2 = option.get(i);
			String attribute = element2.getAttribute(value);
		}
		return option;
	}

	/**
	 * @see used to get the first select o9ption text in dropdown
	 * @param element
	 * @param value
	 * @return String
	 */
	// 28.get the fist selected option text in dropdown
	public String fistSelectOptionText(WebElement element, String value) {
		Select s2 = new Select(element);
		WebElement option = s2.getFirstSelectedOption();
		String text = option.getText();
		return text;
	}

	/**
	 * @see used to verify in dropdown is multiselect option
	 * @param element
	 * @return boolean
	 */
	// 29.verify in dropdown is multiselect option
	public boolean multiselectOption(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	/**
	 * @see used to coding for implicity wait
	 * @param sec
	 */
	// 30.implicity wait
	public void implicityWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	/**
	 * @see used to explicit wait for visibility
	 * @param seconds
	 * @param value
	 * @return Boolean
	 */
	// 31.explicit wait for visibility
	public Boolean explicitWait(int seconds, String value) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		Boolean until = w.until(ExpectedConditions.invisibilityOfElementLocated(By.id(value)));
		return until;
	}

	/**
	 * @see used to fluentwait
	 */
	// 32.fluentwait
	public void flunt() {
		Wait w = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(Throwable.class);
	}

	/**
	 * @see used to vaerify isdisplayed
	 * @param element
	 * @return boolean
	 */

	// 33.verify isdisplayed
	public boolean isdisplayed(WebElement element) {
		Select s = new Select(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	/**
	 * @see used to verify isenabled
	 * @param element
	 * @return boolean
	 */
	// 34.verify isenabled
	public boolean isenabled(WebElement element) {
		Select s = new Select(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	/**
	 * @see used to verify isselected
	 * @param element
	 * @return boolean
	 */
	// 35.verify isselected
	public boolean isselected(WebElement element) {
		Select s = new Select(element);
		boolean selected = element.isSelected();
		return selected;
	}

	/**
	 * @see used to particular value in deselect by index
	 * @param element
	 * @param value
	 */
	// 36.deselectBy index
	public void deselectByIndex(WebElement element, int value) {
		Select s = new Select(element);
		s.deselectByIndex(value);
	}

	/**
	 * @see used to deselect by attribute value
	 * @param element
	 * @param value
	 */
	// 37.deselectby attribute
	public void deselectByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	/**
	 * @see used to deselect by text
	 * @param element
	 * @param text
	 */
	// 38.deselect by text
	public void deselectByText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	/**
	 * @see used to deselect all value
	 * @param element
	 */
	// 39.deselectall
	public void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	/**
	 * @see used to get the parentwindow
	 * @return String
	 */
	// 40.get the parentwindow
	public String parentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	/**
	 * @see used to get the allwindow
	 * @return String
	 */
	// 41.get the allwindow
	public Set<String> allWindow() {
		Set<String> allwindowHandlesId = driver.getWindowHandles();
		return allwindowHandlesId;
	}

	/**
	 * @see used to clear in textbox
	 * @param element
	 */
	// 42.clear textbox
	public void clearTextBox(WebElement element) {
		element.clear();
	}

	/**
	 * @return 
	 * @see used to code for takescreenshort
	 */
	// 43.takescreenshort
	public byte[] takesScreenshort() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	/**
	 * @see used to takescreen
	 * @param element
	 */
	// 44.Takescreenshort for element
	public void takesScreenshotForElement(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
	}

	/**
	 * @see used to mouseover action sor single option
	 * @param element
	 */
	// 45.mouseover action for single option
	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * @see used to drop and drop action
	 * @param elemenet
	 * @param element1
	 */
	// 46.drag and drop
	public void dragAndDrop(WebElement elemenet, WebElement element1) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elemenet, element1).perform();
	}

	/**
	 * @see used to rightclick action
	 * @param element
	 */
	// 47.rightclick
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * @see used to used to doubleclick action
	 * @param element
	 */
	// 48.double click
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * @see used to insert value intextbox and enter
	 * @param element
	 */
	// 49.insert value intextbox and enter
	public void insertValueIntextBoxEnter(WebElement element) {
		element.sendKeys("value");
	}

	/**
	 * @see used to refresh page in navigate
	 * @return Navigation
	 */
	// 50.refresh page
	public Navigation refreshPage() {
		Navigation navi = driver.navigate();
		navi.refresh();
		return navi;
		// driver.navigate().refresh();
	}

	/**
	 * @see used to code for keydown
	 * @throws AWTException
	 */
	// 51.keydown
	public void keydown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
	}

	/**
	 * @see used to code for keypress
	 * @param keycode
	 * @throws AWTException
	 */
	public void keyPress(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}

	/**
	 * @see used to dropdown by text
	 * @param element
	 * @param data
	 */
	public void dropDownByText(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByVisibleText(data);
	}

	/**
	 * @see used to keyrelease in the code
	 * @param keycode
	 * @throws AWTException
	 */
	public void keyRelease(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(keycode);
	}

	/**
	 * @see used to code for keyup
	 * @throws AWTException
	 */
	// 52.keyup
	public void keyup() throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	/**
	 * @see used to switching the alart
	 * @return Alert
	 */
	// 53.switching the alart
	public Alert switchingAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	/**
	 * @see used to particular value in sendkeys
	 * @param value
	 */
	// 54.sendkeys
	public void sendkeys(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
	}

	/**
	 * @see used to forword the navigatio
	 * @param url
	 * @return Navigation
	 */
	// 55.navigation forword
	public Navigation toNavigationForworad(String url) {
		Navigation navi = driver.navigate();
		navi.to(url);
		return navi;

	}

	/**
	 * @see used to navigate the back
	 * @return Navigation
	 */
	// 56.Navigation back
	public Navigation toNavigationBack() {
		Navigation navi = driver.navigate();
		navi.back();
		return navi;
	}

	/**
	 * @see used to the particular webpage using navigate to
	 * @param url
	 * @return Navigation
	 */
	// 57.it will go to the particular webpage using navigate To
	public Navigation navigationWebPageTo(String url) {
		Navigation navigate = driver.navigate();
		navigate.to(url);
		return navigate;
	}

	/**
	 * @see used to get the attribut value in js
	 */
	// 58.javaScript get the attribute value
	public void getAttributeValue() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].getAttribute('value')", js);
	}

	/**
	 * @see used to paticular webpage in screenshort
	 * @param element
	 * @return File
	 */
	// 59.particular webpage screenshot
	public File webPageScreenshot(WebElement element) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = element.getScreenshotAs(OutputType.FILE);
		return file;

	}
	public void clickAlertOk() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @see used to writecelldata from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param Data
	 * @throws IOException
	 */
	public void writeCellData(String sheetName, int rowNum, int cellNum, String Data) throws IOException {
		File file = new File("C:\\Users\\RAMKUMAR\\eclipse-workspace\\Ram\\Excel Files\\Worksheet1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(Data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	/**
	 * @see used to updatecelldata from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 */

	public void updatecellData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\RAMKUMAR\\eclipse-workspace\\Ram\\Excel Files\\Worksheet1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	/**
	 * @see used to getdatafromcell in excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException
	 */

	private String getDataFromcell(String sheetName, int rowNum, int cellNum) throws IOException {

		String res = null;

		File file = new File("C:\\Users\\RAMKUMAR\\eclipse-workspace\\Ram\\Excel Files\\Worksheet1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(check);

				} else {

					res = String.valueOf(numericCellValue);
				}

			}
			break;
		default:
			break;
		}
		return res;

	}

}