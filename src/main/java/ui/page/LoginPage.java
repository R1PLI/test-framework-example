package ui.page;

import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements IPage {

	@Override
	public LoginPage open() {
		return this;
	}

	public InboxPage submitCreds(String email, String password) {
		$("#identifierId").setValue(email).pressEnter();
		$(By.name("password")).setValue(password).pressEnter();
		return new InboxPage();
	}
}
