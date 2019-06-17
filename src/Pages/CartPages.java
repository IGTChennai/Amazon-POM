package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Operations.Action_Methods;

public class CartPages extends Action_Methods
{

	public WebDriver driver;
	
	@FindBy(id="nav-cart")
	public WebElement Cart;
	@FindBy(xpath="//*[@class='sc-list-item-content']")
	public WebElement Itemsaddtocart;
	@FindBy(xpath="//*[@class='a-button-text a-declarative']")
	public WebElement IncreseItem;
	@FindBy(id="dropdown1_2")
	public WebElement items3;
	@FindBy(name="proceedToCheckout")
	public WebElement proceedToCheckout;
	@FindBy(xpath="(//*[contains(text(),'Select a delivery address')])[2]")
	public WebElement deliveryaddress;
	
	
	
	public  CartPages(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void verycart() {
		click(Cart);
		verifyelementispresent(Itemsaddtocart);
		click(IncreseItem);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(items3);
		
		click(proceedToCheckout);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyelementispresent(deliveryaddress);
		
	}
	
	
}
