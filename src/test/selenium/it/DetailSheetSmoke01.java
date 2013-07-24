package test.selenium.it;

public class DetailSheetSmoke01 extends TestBase {

	// Testing: click a leaf and get the specific details
	public void test001(){
		selenium.open("/TreeOfLife/index.html");
		assertEquals("Tree of Life", selenium.getTitle());
		selenium.click("//p[@id='dogName' and text()='John']");
		assertTrue(selenium.isElementPresent("//div[@id='detailSheet']/img[@src='img/dogs/boxer2.jpg']"));
		assertTrue(selenium.isTextPresent("John"));
		selenium.click("//div[@id='detailSheet']/img[@src='img/icon_close.png']");
		assertFalse(selenium.isElementPresent("id=detailSheet"));
	}
}
