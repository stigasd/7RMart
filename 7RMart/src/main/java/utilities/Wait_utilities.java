package utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_utilities {

	public static final long IMPLICIT_WAIT = 5;

	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static final long FLUENT_WAIT = 30;
	public static final long POLL_WAIT = 15;

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlertToBeVisible(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementIsSelectable(WebDriver driver, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementSelectionStateToBe(Element, false));
	}

	public void waitForClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void WaitForElement(WebDriver driver, WebElement target) {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT))
				.pollingEvery(Duration.ofSeconds(PAGE_LOAD_WAIT)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
}