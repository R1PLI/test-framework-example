package ui.page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class InboxPage implements IPage {

	private static final By ariaLabelXpath = By.xpath("//*[@aria-label=\"Account Information\"]/div/div/descendant::div[1]");
	private static final By accountTooltipButton = By.xpath("//*[@aria-label=\"Account Information\"]/parent::div");

	@Override
	public InboxPage open() {
		Selenide.open("/");
		return this;
	}

	public String getTextFromAreaLabel() {
		$(accountTooltipButton).click();
		return $(ariaLabelXpath).getText();
	}
}
