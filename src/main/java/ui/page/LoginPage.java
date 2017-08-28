package ui.page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements IPage {

	private static final By emailSubmitArea = By.cssSelector("#identifierId");
	private static final By passwordSubmitArea = By.name("password");

	@Override
	public LoginPage open() {
		Selenide.open("/");
		return this;
	}

	public InboxPage submitCreds(String email, String password) {
		$(emailSubmitArea).val(email).pressEnter();
		$(passwordSubmitArea).val(password).pressEnter();
		return new InboxPage();
	}
}
