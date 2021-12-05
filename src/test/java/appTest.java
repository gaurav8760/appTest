import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import java.net.URL;
        import java.util.List;
        import java.net.MalformedURLException;
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.AndroidElement;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.openqa.selenium.remote.DesiredCapabilities;
public class appTest {
    public static String userName = "<username>";
    public static String accessKey = "<accesskey>";
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Google Pixel 3");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("app", "lt://APP1001131637005466834502");
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        AppiumDriver driver = new AppiumDriver(new
                URL("https://gauravkb:DqLVVOF1ll4TTMyXXt3gslp8NZ8Ynon3vwcRd4eFTV5GLavGh9@beta-hub.lambdatest.com/wd/hub"), capabilities);
        try {
            AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
            searchElement.click();
            AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
            insertTextElement.sendKeys("LambdaTest" + Keys.ENTER);
            Thread.sleep(5000);
            List allProductsName = (List) driver.findElement(By.className("android.widget.TextView"));

            assert(allProductsName.size() > 0);
//            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            e.printStackTrace();
        }catch (AssertionError a){
//            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            a.printStackTrace();
        }
// The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
        driver.quit();
    }
}