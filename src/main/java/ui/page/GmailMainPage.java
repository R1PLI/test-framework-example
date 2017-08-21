package ui.page;

import com.codeborne.selenide.Selenide;
import ui.core.IPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GmailMainPage implements IPage {
	@Override
	public GmailMainPage open() {
		Selenide.open("/");
		return this;
	}

	public LoginPage clickSignInButton() {
		$(byText("Sign In")).click();
		return new LoginPage();
	}

}
