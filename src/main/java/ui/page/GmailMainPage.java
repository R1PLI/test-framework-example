package ui.page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class GmailMainPage implements IPage {
	@Override
	public GmailMainPage open() {
		Selenide.open("/");
		return this;
	}
	public InboxPage submitCreds(String email, String password) {
		$("#identifierId").setValue(email).pressEnter();
		$(By.name("password")).setValue(password).pressEnter();
		return new InboxPage();
	}

}
