package test.selenium.it;

public class DetailSheetSmoke02 extends TestBase {
	
	//2-1
	public void test001() throws InterruptedException{
		selenium.open("/TreeOfLife/index.html");
		assertEquals("Tree of Life", selenium.getTitle());
		selenium.click("xpath=(//p[@id='dogName' and text()='Ann'])");
		assertTrue(selenium.isElementPresent("//div[@id='detailSheet']/img[@src='img/dogs/boxer1.jpg']"));
		assertTrue(selenium.isTextPresent("Ann"));
		selenium.click("//div[@id='detailSheet']/img[@src='img/icon_close.png']");
		Thread.sleep(2000);
		assertFalse(selenium.isElementPresent("id=detailSheet"));
	}
}
