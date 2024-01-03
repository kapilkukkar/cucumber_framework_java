package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
		WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver)
		{
			ldriver=rdriver;			
			PageFactory.initElements(rdriver, this);
		}
		@FindBy(id="Email")WebElement email;
		@FindBy(id="Password")WebElement password;
		@FindBy(xpath="//button[@type='submit']")WebElement loginbuton;
		@FindBy(xpath="//a[normalize-space()='Logout']")WebElement logout;
		
		
		public void enter_email(String emailid)
		{
			email.clear();
			email.sendKeys(emailid);
		}
		public void enter_paswrd(String paswrd)
		{
			password.clear();
			password.sendKeys(paswrd);
		}
		public void press_loginbtn()
		{
			loginbuton.click();
		}
		public void press_logout()
		{
			logout.click();
		}
}

