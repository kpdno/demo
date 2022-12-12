package lesson11;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework2 {

	String url = "https://www.flightcentre.ca/flights";
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get(url);

		// from
		WebElement fromBox = driver.findElement(By.id("js-fc-input-origin"));
		fromBox.click();
		fromBox.sendKeys("new");
		for (int i = 0; i < 2; i++) {
			fromBox.sendKeys(Keys.ARROW_DOWN);
		}
		fromBox.sendKeys(Keys.ENTER);

//		driver.findElement(By.id("awesomplete_list_1_item_1")).click();

		// to
		WebElement toBox = driver.findElement(By.id("js-fc-input-destination"));
		toBox.click();
		toBox.sendKeys("tokyo");
		for (int i = 0; i < 3; i++) {
			toBox.sendKeys(Keys.ARROW_DOWN);
		}
		toBox.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		// open calendar
		WebElement leaveDate = driver.findElement(By.className("js-fc-input-departure-date"));
		leaveDate.click();

		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");

		// select leave date
		driver.findElement(By.xpath("//button [@data-date='1671080400000']")).click();

		// return
		WebElement returnBox = driver.findElement(By.id("js-fc-input-return-date"));
		returnBox.click();

		// select return date
		driver.findElement(By.xpath("//button [@data-date='1672462800000']")).click();

		Thread.sleep(2000);

		// passengers/Ticket class
		WebElement pasTic = driver.findElement(By.id("js-fc-input-passengers-result"));
		pasTic.click();

		Select adults = new Select(driver.findElement(
				By.cssSelector(".mdc-select__native-control[data-test='fc-flight-search__select--adults']")));
		adults.selectByIndex(2);

		Select children = new Select(driver.findElement(
				By.cssSelector(".mdc-select__native-control[data-test='fc-flight-search__select--children']")));
		children.selectByValue("2");

		Select infant = new Select(driver.findElement(
				By.cssSelector(".mdc-select__native-control[data-test='fc-flight-search__select--infants']")));
		infant.selectByVisibleText("1 Infant");

		Select fareType = new Select(driver.findElement(
				By.cssSelector(".mdc-select__native-control[data-test='fc-flight-search__select--faretype']")));
		fareType.selectByIndex(3);

		driver.findElement(By.xpath("//button [@id='onetrust-accept-btn-handler']")).click();

		Thread.sleep(2000);

		// click confirm
		driver.findElement(By.xpath("//button [@data-test='fc-flight-search__select--confirm']")).click();

		// search
		driver.findElement(By.xpath("//button [@data-test='fc-flight-search__button--search-flights']")).click();

		
		//switch tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(15000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
