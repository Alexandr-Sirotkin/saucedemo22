package driver;

import static utils.Waiter.WAIT_2_SECONDS;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

  private WebDriverFactory() {
  }

  public static WebDriver getWebDriver() {
    WebDriver driver;
    switch (System.getProperty("browser", "chrome")) {
      case "firefox": {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      }
      case "opera": {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        break;
      }
      default:{
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(chromeOptions);
      }
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_2_SECONDS));
    return driver;
  }
}
