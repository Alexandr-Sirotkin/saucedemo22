package utils;

import driver.DriverSingleton;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

  public final static  int WAIT_2_SECONDS = 2;
  private final static  int WAIT_5_SECONDS = 5;
  private final static  int WAIT_500_MILLISECONDS = 500;

  private Waiter() {
  }

  public static WebElement waitVisibilityOf(WebElement element) {
    return new WebDriverWait(DriverSingleton.getInstance().getDriver(), Duration.ofSeconds(WAIT_5_SECONDS))
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitElementToBeClickable(WebElement element) {
    return new WebDriverWait(DriverSingleton.getInstance().getDriver(), Duration.ofSeconds(WAIT_5_SECONDS))
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void fluentWaitElementToBeClickable(WebElement element) {
    new FluentWait<>(DriverSingleton.getInstance().getDriver())
        .withTimeout(Duration.ofSeconds(WAIT_5_SECONDS))
        .pollingEvery(Duration.ofSeconds(WAIT_500_MILLISECONDS))
        .ignoring(NoSuchElementException.class)
        .until((ExpectedCondition<Boolean>) webDriver -> element.isDisplayed() && element.isEnabled());
  }
}
