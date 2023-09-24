package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

public class LoginPage extends Page {

  @FindBy(xpath = "//input[@id='user-name']")
  private WebElement usernameField;

  @FindBy(xpath = "//input[@id='password']")
  private WebElement passwordField;

  @FindBy(xpath = "//input[@id='login-button']")
  private WebElement loginButton;

  public LoginPage openPage(String url) {
    driver.get(url);
    return this;
  }

  public LoginPage fillInUserName(String userName) {
    Waiter.waitVisibilityOf(usernameField).sendKeys(userName);
    return this;
  }

  public LoginPage fillInPassword(String password) {
    Waiter.waitVisibilityOf(passwordField).sendKeys(password);
    return this;
  }

  public void clickLoginButton() {
    Waiter.waitElementToBeClickable(loginButton).click();
  }
}
