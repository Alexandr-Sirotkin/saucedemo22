package tests;

import driver.DriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

  @AfterClass
  public void stopBrowser() {
    DriverSingleton.getInstance().closeDriver();
  }
}
