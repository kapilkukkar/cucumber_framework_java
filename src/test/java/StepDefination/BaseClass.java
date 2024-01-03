package StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddCustomer;
import PageObject.LoginPage;
import PageObject.SearchCutomerPage;
import Utilites.ReadConfig;

public class BaseClass 
{

	public static WebDriver driver;
	public LoginPage lgpage;
	public AddCustomer cstmer;
	public SearchCutomerPage cstmrpage;
	public  Logger log;
	public ReadConfig readconfig; 
	
	
	public String genrateemailid()
	{
		return (RandomStringUtils.randomAlphanumeric(5));
		
	}
}
