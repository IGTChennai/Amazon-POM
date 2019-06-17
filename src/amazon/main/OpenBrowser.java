package amazon.main;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.ResourceService.WelcomeFactory;


import Pages.CartPages;
import Pages.CreateUserPage;
import Pages.LoginUserPage;
import Pages.SearchItemsAddcart;

import Report.JUnitHTMLReporter;

public class OpenBrowser extends JUnitHTMLReporter {
	public static WebDriver driver;

	@BeforeClass
	public static void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void verifycreateaccount() {
		CreateUserPage createuser = PageFactory.initElements(driver,
				CreateUserPage.class);
		createuser.openCreateUserPage();
		createuser.blankValueVerification();
		createuser.textverifcationinMobileTextbox();

	}

	@Test
	public void loginverify() {
		LoginUserPage login = PageFactory.initElements(driver,
				LoginUserPage.class);
		login.verifyloginemptyValue();
		login.verifyinvaliedusername();
		login.verifylogincorrectly_Or_not();

	}

	@Test
	public void verifyCart() {
		CartPages cart = PageFactory.initElements(driver, CartPages.class);
		cart.verycart();
		driver.navigate().back();
	}

	@Test
	public void SearchItems() throws InterruptedException {
		SearchItemsAddcart search = PageFactory.initElements(driver,
				SearchItemsAddcart.class);
		search.Search_5th_item();
		search.FindItem();
        Thread.sleep(3000);
        
        search.logout();
        

	}

	@AfterClass
	public static void quit() {
		//driver.quit();
	
	}

}
