//package tests;
//
//import static org.testng.Assert.assertTrue;
//
//import driver.DriverSingleton;
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//public class FileDownloadTest extends BaseTest {
//
//  private static String BASE_URL = "http://the-internet.herokuapp.com";
//
//  @Test
//  public void fileShouldBeDownloaded() throws InterruptedException {
//    DriverSingleton.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    DriverSingleton.getInstance().getDriver().get(BASE_URL + "/download");
//    String fileToDownloadName = "test-file.txt";
//    DriverSingleton.getInstance().getDriver().findElement(By.xpath(String.format("//*[text()='%s']", fileToDownloadName))).click();
//    Thread.sleep(2000);
//    File folder = new File(System.getProperty("user.dir"));
//    File[] files = folder.listFiles();
//    boolean found = false;
//    File file = null;
//    for (File fileItem : files) {
//      if (fileItem.isFile()) {
//        String fileName = fileItem.getName();
//        System.out.println("File " + fileItem.getName());
//        if (fileName.matches(fileToDownloadName)) {
//          file = new File(fileName);
//          found = true;
//        }
//      }
//    }
//    try {
//      assertTrue(found, "Downloaded document is not found");
//    } finally {
//      file.deleteOnExit();
//    }
//  }
//
//}
