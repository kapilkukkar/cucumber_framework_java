package StepDefination;

import io.cucumber.java.en.When;

public class StepDefGiven extends BaseClass
{


	@When("User opens URL {string}")
	public void user_opens_url(String url)	
	{
		driver.get(url);
	}
}
