package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Operations.Action_Methods;

public class SearchItemsAddcart extends Action_Methods {
	public static WebDriver driver;
	
	
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	public WebElement SearchTextbox;
	
	
	@FindBy(xpath="//*[@id='nav-link-yourAccount']")
	public WebElement menuitem;
	
	@FindBy(xpath="//*[@id='nav-item-signout']")
	public WebElement signout;
	
	/*@FindBy(xpath="//*[@id='issDiv4']")
	public WebElement Androidcharger;*/
	
	
	public  SearchItemsAddcart(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void Search_5th_item() throws InterruptedException {
		KeyboardAction(SearchTextbox,"Android");
	
		
		
	}
	
	
	public void FindItem() throws InterruptedException {
		Thread.sleep(25000);
		/*WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-section a-spacing-medium']")));
		*/
		try {
			int i = 1;
			List<WebElement> WebElement = driver.findElements(By
					.xpath("//div[@class='a-section a-spacing-medium']"));
			int count=WebElement.size();
			for (WebElement element : WebElement) {
				String text = driver
						.findElement(
								By.xpath("(//div[@class='a-section a-spacing-medium']//span[1][@class='a-price']//span[@class='a-price-whole'])["
										+ i + "]")).getText();

				String clean = text.replaceAll("[,]", "");
				int number = Integer.parseInt(clean);

				if (number >= 500) {
					// System.out.println(number +"its from integer");
					String product = driver
							.findElement(
									By.xpath("(//div[@class='a-section a-spacing-medium']//span[@class='a-size-base-plus a-color-base a-text-normal'])["
											+ i + "]")).getText();

					System.out.println("Amount is  " + number);
					System.out.println("Product name is   " + product);

				}

				i++;
				if(i==count-1){
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void logout() {
		System.out.println("print");
		
		
			WebElement menuitem=driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
			WebElement singout=driver.findElement(By.xpath("//*[@id='nav-item-signout']"));
			menuitem.click();
			singout.click();
			Actions ac =new Actions(driver);
			ac.moveToElement(menuitem).moveToElement(singout).click().build().perform();
			System.out.println("print");
		
		
	
		
	}
	
}
