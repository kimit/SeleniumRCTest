package test.selenium.it;

import java.io.IOException;
import java.util.Properties;

import junit.framework.TestCase;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.server.RemoteControlConfiguration;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class TestBase extends TestCase {
	private SeleniumServer seleniumServer;
	protected Selenium selenium;
	
	private Properties prop = new Properties();
	// テスト対象のサーバURL(ドメイン)＆ブラウザ設定
	private String testUrl;
	private String testBrowser;
	
	protected void setUp() throws Exception {
		// プロパティファイル読み込み
		try {
			prop.load(this.getClass().getResourceAsStream("testconfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// テスト対象のサーバURL＆ブラウザ設定をプロパティから読み込む
		testUrl = prop.getProperty("SeleniumTest.URL");
		testBrowser = prop.getProperty("SeleniumTest.Browser");
		
		// SeleniumServerを起動する。
		seleniumServer = new SeleniumServer();
		seleniumServer.start();
		
		// selenium インスタンス起動。プロパティから読み込んだ設定を使用
		selenium = new DefaultSelenium("localhost", 
				RemoteControlConfiguration.getDefaultPort(), testBrowser, testUrl);
		selenium.start();		
	}
	
	protected void tearDown() throws Exception {
		// Selenium インスタンスを停止。
		selenium.stop();
		
		// SeleniumServerを停止する。
		seleniumServer.stop();
	}
}
