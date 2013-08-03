package test.selenium.it;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;

public class WaitFunc {
	
	public static void waitElement(Selenium selenium, String locator, long timeout)
		throws InterruptedException
	{
		Wait wait = new WaitForElementPresent(selenium, locator, timeout);
		
		synchronized (wait) {
			wait.wait("Failed to waitForElementPresent at " + locator + ".", timeout);
			//System.out.print("I am wait.");
		}
	}

}
