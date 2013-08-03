package test.selenium.it;

public class Search_Smoke_New extends TestBase {

	public void test001_smoke() throws InterruptedException {
		// Open the page
		selenium.open("/TreeOfLife/index.html");
		selenium.waitForPageToLoad("3000");
		// Search for "John"
		selenium.type("css=#searchBox","John");
		selenium.click("css=#searchDiv > img");
		
		WaitFunc.waitElement(selenium, "css=#leaf2 > img", 1000);
		
		// Check only leaf2 shows "found" image
		assertEquals("img/leaf_found.png", selenium.getAttribute("css=#leaf2 > img@src") );
		assertEquals("img/leaf.png", selenium.getAttribute("css=#leaf1 > img@src") );
		
		Thread.sleep(5000);
		
		// Check leaf2 image reverts to the original
		assertEquals("img/leaf.png", selenium.getAttribute("css=#leaf2 > img@src") );
	}
}
