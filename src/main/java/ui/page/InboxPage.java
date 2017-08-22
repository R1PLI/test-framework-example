package ui.page;

import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class InboxPage implements IPage{

	private static final By ariaLabelXpath = By.xpath("//*[@aria-label=\"Account Information\"]/div[1]/div[1]/div[1]");
	private static final By accountTooltipButton = By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]");

	@Override
	public InboxPage open() {
		return this;
	}

	public String getTextFromAreaLabel() {
		$(accountTooltipButton).click();
		return $(ariaLabelXpath).getText();
	}
}
