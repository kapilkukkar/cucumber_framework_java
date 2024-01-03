package StepDefination;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddCustomer;
import PageObject.LoginPage;
import PageObject.SearchCutomerPage;
import Utilites.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class StepDef extends BaseClass
{
	
	@Before("@sanity")
	public void setup() throws IOException,FileNotFoundException
	{
		
		readconfig= new ReadConfig();
		//log= LogManager.getLogger("StepDef");
		String browser=readconfig.getbrowser();
		switch(browser.toLowerCase())
		{
		case"chrome":

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			break;
		case"firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;	
		case"msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
			break;
		default:

			driver=null;
			break;
		}

		
		//log.info("setup2 is executed");
	}
	

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		
		lgpage= new LoginPage(driver);
		cstmer= new AddCustomer(driver);
		cstmrpage= new SearchCutomerPage(driver);
		
	}


	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) 
	{
		lgpage.enter_email(Email);
		lgpage.enter_paswrd(Password);
		//log.info("email and passwrod entered");
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		lgpage.press_loginbtn();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedtitle) 
	{

		String actualtitle=driver.getTitle();
		if(actualtitle.equals(expectedtitle))
		{
			//log.warn("page title matched");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException 
	{
		Thread.sleep(2000);
		lgpage.press_logout();
		//log.info("logout from WebPage");
	}


	@Then("close browser")
	public void close_browser() 
	{
		//driver.close();
	}
	
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() throws InterruptedException 
	{
		String actualtitle=cstmer.getPageTitle();
		String expectedtitle="Dashboard / nopCommerce administration";
		if(actualtitle.equals(expectedtitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException 
	{

		Thread.sleep(3000);
		cstmer.clickOnCustomersMenu();
		Thread.sleep(2000);
	}
	
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException 
	{
		cstmer.clickOnCustomersMenuItem();
		Thread.sleep(2000);
	}

	@When("click on Add new button")
	public void click_on_add_new_button() 
	{
		cstmer.clickOnAddnew();
		//log.info("Add new button feature working");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
		String expectedtitle="Add a new customer / nopCommerce administration";
		String actualtitle= cstmer.getPageTitle();
		if(actualtitle.equals(expectedtitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{
		//cstmer.enterEmail("ka6s5k@gmail.com");
		Thread.sleep(2000);
		cstmer.enterEmail(genrateemailid()+ "@gmail.com" );                                                           
		cstmer.enterPassword("test1");
		cstmer.enterFirstName("sahab");
		cstmer.enterLastName("khu");
		cstmer.enterGender("Female");
		cstmer.enterDob("6/13/1985");
		cstmer.enterCompanyName("phonix");
		cstmer.enterAdminContent("Admin Content");
		cstmer.enterManagerOfVendor("Vendor 1 ");
		Thread.sleep(6000);
		//log.info("cutomer information entered");
	}

	@When("click on Save button")
	public void click_on_save_button() 
	{
		cstmer.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedmasg)

	{
		String actualmasg=driver.findElement(By.tagName("Body")).getText();
		if(actualmasg.contains(expectedmasg))
		{

			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);

		}

	}
	@When("Enter customer EMail")
	public void enter_customer_e_mail() 
	{
		cstmrpage.enter_email("victoria_victoria@nopCommerce.com"); 
		//log.info("for search through email");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException 
	{
		cstmrpage.press_searchbotton();
		Thread.sleep(2000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table()
	{
		String expectedresult="victoria_victoria@nopCommerce.com";
		Assert.assertTrue(cstmrpage.searchbyemail(expectedresult));
	}
	@When("Enter customer FirstName")
	public void enter_customer_first_name() 
	{
		//log.info("Search through name");
		cstmrpage.enter_firstname("Virat");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() 
	{
		cstmrpage.enter_lastname("Kohli");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table()
	{
		String expectname="Virat Kohli";
		Assert.assertTrue(cstmrpage.searchbyname(expectname));
	}

	@After
	public void teardown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			String fileWithPath = "C:\\Users\\kumar\\eclipse-workspace\\CucumberFramwork\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Step 1 Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			// Step 2 Move image file to new destination
			File DestFile=new File(fileWithPath);
			//Step 3 Copy file at destination	
			FileUtils.copyFile(SrcFile, DestFile);
			
		}
		driver.close();
	}
	/*
	 * @BeforeStep public void beforestep() {
	 * System.out.println("Before every step "); }
	 * 
	 * @AfterStep public void afterestep() {
	 * System.out.println("after every step "); }
	 */


}
