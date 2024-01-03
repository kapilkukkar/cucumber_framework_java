package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCutomerPage 
{

	WebDriver ldriver;
	
	public SearchCutomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;			
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@id='SearchEmail']")WebElement emailid;
	@FindBy(xpath="//button[@id='search-customers']")WebElement searchbutton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement table;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")List<WebElement>rows;	
	@FindBy(id="SearchFirstName")WebElement fname;
	@FindBy(id="SearchLastName")WebElement lname;
	
	public void enter_email(String email)
	{
		emailid.sendKeys(email);
	}
	public void press_searchbotton()
	{
		searchbutton.click();
	}
	
	public boolean searchbyemail(String email)
	{
		boolean found= false;
		int ttlrows=rows.size();
		//int ttlclmns=column.size();
		
		for(int i=1;i<=ttlrows;i++)
		{
			WebElement obj=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[\" + i  + \"]/td[2]"));
			String actualemailaddress=obj.getText();
			System.out.println(actualemailaddress);
			if(actualemailaddress.equals(email))
			{
				found=true;
			}
			
		}
		return found;
	}
	
	public void enter_firstname(String name)
	{
		fname.sendKeys(name);
	}
	public void enter_lastname(String lstname)
	{
		lname.sendKeys(lstname);
	}
	public boolean searchbyname(String fullname)
	{
		boolean found= false;
		int ttlrows=rows.size();		
		for(int i=1;i<=ttlrows;i++)
		{
			WebElement obj=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[\" + i  + \"]/td[3]"));
			String actualname=obj.getText();
			System.out.println(actualname);
			if(actualname.equals(fullname))
			{
				found=true;
			}			
		}
		return found;
	}
	

	
}
