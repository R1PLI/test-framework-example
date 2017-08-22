package ui.core;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.page.GmailMainPage;
import ui.page.LoginPage;
import ui.page.SearchPage;


abstract public class BaseTest {

	protected GmailMainPage gmailMainPage;
	protected SearchPage searchPage;
	protected LoginPage loginPage;

	@BeforeClass
	public void driverSetUp() {
		ChromeDriverManager.getInstance().setup();
		Configuration.browser = "chrome";
	}

	@BeforeMethod
	public void setUp() {
		gmailMainPage = new GmailMainPage();
		searchPage = new SearchPage();
		loginPage = new LoginPage();
	}
}
