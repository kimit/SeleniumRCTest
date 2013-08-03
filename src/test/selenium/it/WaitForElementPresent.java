package test.selenium.it;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

public class WaitForElementPresent extends Wait 
{
	Selenium selenium;
	String locator;
	long timeout;
	
	public WaitForElementPresent (Selenium selenium, String locator, long timeout)
	{
		this.selenium = selenium;
		this.locator = locator;
		this.timeout = timeout;
	}
	
	@Override
	public boolean until() {
		return selenium.isElementPresent(locator);
	};
}
