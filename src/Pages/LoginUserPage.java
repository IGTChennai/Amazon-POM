package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.ContiguousSet;

import Operations.Action_Methods;

public class LoginUserPage extends Action_Methods{

	public WebDriver driver;
	
	
	@FindBy(xpath="//*[contains(text(),'Sign in')]")
	public WebElement SignIn;
	@FindBy(id="continue")
	public WebElement continueButton;
	@FindBy(xpath="//*[contains(text(),'Enter your email or mobile phone number')]")
	public WebElement entermobilenoText;
	
	@FindBy(id="auth-error-message-box")
	public WebElement Errormessage;
	@FindBy(id="ap_email")
	public WebElement Emailtextbox;
	
	@FindBy(xpath="//*[contains(text(),'Hello, prabakaran.G')]")
	public WebElement username;
	@FindBy(id="ap_password")
	public WebElement password;
	@FindBy(id="signInSubmit")
	public WebElement Loginbutton;
	
	
	public  LoginUserPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void verifyloginemptyValue() {
		
		click(SignIn);
		click(continueButton);
		verifyelementispresent(entermobilenoText);
		
		
		
	}
	
	
	public void verifyinvaliedusername() {
		Sendtext(Emailtextbox, "354646");
		click(continueButton);
		verifyelementispresent(Errormessage);
	}
	
	public void verifylogincorrectly_Or_not() {
		Sendtext(Emailtextbox, "9884646333");
		click(continueButton);
		Sendtext(password, "prabha#123");
		click(Loginbutton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    verifytext(username, "Hello, prabakaran.G");
	}
	
	
	
	
}
