package lesson11;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class homework {

	String url = "https://finviz.com/screener.ashx";
	WebDriver driver;
	String username = "standard_user";
	String password = "secret_sauce";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void test1() throws InterruptedException {
		driver.get(url);

		// CSS
//		driver.findElement(By.cssSelector("input[placeholder=Username]")).sendKeys(username);
//		driver.findElement(By.cssSelector("#password")).sendKeys(password);
//		driver.findElement(By.cssSelector("#login-button")).click();

		//index
		Select sortDrp = new Select(driver.findElement(By.cssSelector("#fs_exch")));
		sortDrp.selectByIndex(2);
		Thread.sleep(500);
		Select sortDrp2 = new Select(driver.findElement(By.cssSelector("#fs_cap")));
		sortDrp2.selectByIndex(3);
		Thread.sleep(500);
		Select sortDrp3 = new Select(driver.findElement(By.cssSelector("#fs_earningsdate")));
		sortDrp3.selectByIndex(7);
		Thread.sleep(500);
		Select sortDrp4 = new Select(driver.findElement(By.cssSelector("#fs_targetprice")));
		sortDrp4.selectByIndex(4);
		Thread.sleep(500);
		
		//value
		Select sortDrp5 = new Select(driver.findElement(By.cssSelector("#fs_idx")));
		sortDrp5.selectByValue("sp500");
		Thread.sleep(500);
		Select sortDrp6 = new Select(driver.findElement(By.cssSelector("#fs_fa_div")));
		sortDrp6.selectByValue("pos");
		Thread.sleep(500);
		Select sortDrp7 = new Select(driver.findElement(By.cssSelector("#fs_sh_avgvol")));
		sortDrp7.selectByValue("u500");
		Thread.sleep(500);
		Select sortDrp8 = new Select(driver.findElement(By.cssSelector("#fs_ipodate")));
		sortDrp8.selectByValue("prev5yrs");
		Thread.sleep(500);
		
		//with text
		Select sortDrp9 = new Select(driver.findElement(By.cssSelector("#fs_sec")));
		sortDrp9.selectByVisibleText("Technology");
		Thread.sleep(500);
		Select sortDrp10 = new Select(driver.findElement(By.cssSelector("#fs_sh_short")));
		sortDrp10.selectByVisibleText("Under 30%");
		Thread.sleep(500);
		Select sortDrp11 = new Select(driver.findElement(By.cssSelector("#fs_sh_relvol")));
		sortDrp11.selectByVisibleText("Under 2");
		Thread.sleep(500);
		Select sortDrp12 = new Select(driver.findElement(By.cssSelector("#fs_sh_outstanding")));
		sortDrp12.selectByVisibleText("Over 100M");
		Thread.sleep(500);
		
		
		
		//with x_path
		Select sortDrp13 = new Select(driver.findElement(By.xpath("//select[@id='fs_ind']")));
		sortDrp13.selectByIndex(8);
		Thread.sleep(500);
		Select sortDrp14 = new Select(driver.findElement(By.xpath("//select[contains(@data-url-selected, 'v=111&f=a')]")));
		sortDrp14.selectByValue("strongbuy");
		Thread.sleep(500);
		Select sortDrp15 = new Select(driver.findElement(By.xpath("(//select[@data-filter='sh_curvol'])[1]")));
		sortDrp15.selectByVisibleText("Under 750K");
		Thread.sleep(500);
		Select sortDrp16 = new Select(driver.findElement(By.xpath("//select[@id='fs_sh_float' or @fs_sh_float='sh_float']")));
		sortDrp16.selectByIndex(9);
		Thread.sleep(500);
		
		
		Select sortDrp17 = new Select(driver.findElement(By.cssSelector("select[data-filter='geo']:nth-of-type(1)")));
		sortDrp17.selectByIndex(1);
		Thread.sleep(500);
		Select sortDrp18 = new Select(driver.findElement(By.cssSelector("select[id^='fs_sh_opt'")));
		sortDrp18.selectByValue("optionshort");
		Thread.sleep(500);
		Select sortDrp19 = new Select(driver.findElement(By.cssSelector("#fs_sh_price.screener-combo-text")));
		sortDrp19.selectByVisibleText("Under $50");
		Thread.sleep(500);
		
		
		Select sortDrp20 = new Select(driver.findElement(By.cssSelector("#orderSelect")));
		sortDrp20.selectByIndex(4);
		Thread.sleep(500);
		Select sortDrp21 = new Select(driver.findElement(By.cssSelector("#orderDirSelect")));
		sortDrp21.selectByVisibleText("Desc");
		Thread.sleep(500);
		Select sortDrp22 = new Select(driver.findElement(By.cssSelector("#signalSelect")));
		sortDrp22.selectByVisibleText("Most Active");
		Thread.sleep(500);
		WebElement toBox = driver.findElement(By.id("tickersInput"));
		toBox.click();
		toBox.sendKeys("example text");
		
		driver.findElement(By.xpath("div[onclick^='ic_uat5_adhesion_collapse(this)'] ")).click();
	
		
	//	sortDrp.isMultiple();
	}
}
