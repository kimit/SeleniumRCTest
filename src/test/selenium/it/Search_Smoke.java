package test.selenium.it;

import com.thoughtworks.selenium.Wait;

public class Search_Smoke extends TestBase {

	// Test to search a single item
	public void test001() {
		selenium.open("/TreeOfLife/index.html");
		selenium.waitForPageToLoad("3000");
		selenium.type("css=#searchBox", "john");
		selenium.click("css=#searchDiv > img");
		waitForElementPresent("css=#leaf2[style]");
		assertNotSame("1", selenium.getEval("window.document.getElementById('leaf2').style.opacity"));
		waitForElementPresent("css=#leaf1[style]");
		assertEquals("1", selenium.getEval("window.document.getElementById('leaf1').style.opacity"));
	}
	
	//Test matching multiple items
	public void test002()
	{
		selenium.open("/TreeOfLife/index.html");
		selenium.waitForPageToLoad("3000");
		selenium.type("css=#searchBox", "senno");
		selenium.click("css=#searchDiv > img");
		waitForElementPresent("css=#leaf2[style]");
		assertNotSame("1", selenium.getEval("window.document.getElementById('leaf2').style.opacity"));
		assertNotSame("1", selenium.getEval("window.document.getElementById('leaf4').style.opacity"));
		waitForElementPresent("css=#leaf1[style]");
		assertEquals("1", selenium.getEval("window.document.getElementById('leaf1').style.opacity"));
	}
	
	private void waitForElementPresent(final String locator)
	{
		Wait wait = new Wait()
		{
			@Override
			public boolean until(){ return selenium.isElementPresent(locator);} 
		};
		wait.wait("Failed to waitForElementPresent() at" + locator + ".", 5000);
		
	}

}
