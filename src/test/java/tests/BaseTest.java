package tests;

import driver.DriverSingleton;
import org.testng.annotations.AfterClass;

public class BaseTest {

  @AfterClass
  public void stopBrowser() {
    DriverSingleton.getInstance().closeDriver();
  }
}
