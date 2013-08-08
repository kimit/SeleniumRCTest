package test.selenium.it;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DetailSheetSmoke01.class, DetailSheetSmoke02.class,
		Search_Multiple_new.class, Search_Smoke_New.class })
public class AllTests {

}
