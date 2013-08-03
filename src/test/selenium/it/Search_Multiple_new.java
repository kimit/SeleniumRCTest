package test.selenium.it;

public class Search_Multiple_new extends TestBase
{

	public void test001() throws InterruptedException
	{
		// Open the page
		selenium.open("/TreeOfLife/index.html");
		selenium.waitForPageToLoad("3000");
		// Search for Senno (2 items)
		selenium.type("css=#searchBox", "Senno");
		selenium.click("css=#searchDiv > img");
		WaitFunc.waitElement(selenium, "css=#leaf2 > img", 1000);
		// Check if only Leaf2 and Leaf4 are showing an orange leaf
		assertEquals("img/leaf_found.png", selenium.getAttribute("css=#leaf2 > img@src"));
		assertEquals("img/leaf_found.png", selenium.getAttribute("css=#leaf4 > img@src"));
		assertEquals("img/leaf.png", selenium.getAttribute("css=#leaf1 >img@src"));
		
		Thread.sleep(5000);
		
		// Check if the image of Leaf2 and Leaf4 reverts to the green one 
		assertEquals("img/leaf.png", selenium.getAttribute("css=#leaf2 > img@src"));
		assertEquals("img/leaf.png", selenium.getAttribute("css=#leaf4 > img@src"));		
	}
}
