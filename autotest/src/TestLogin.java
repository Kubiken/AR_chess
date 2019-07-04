import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestLogin
{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "D1AGAD1812603334");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.metasystem.metatrakubi");
        dc.setCapability("appActivity", "ru.vsk.autometrica.presentationlayer.activities.SplashActivity");
        dc.setCapability("automationName","UiAutomator2");
        //dc.setCapability("noReset","true");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        TimeUnit.SECONDS.sleep(5);

        test1Login(driver); /*- Запускать по отдельнольности, после логина происходит подвисание, с чем связано не ясно.
         По отдельности тесты 1 и 2-5 работают. Для первого теста закомментить параметр noReset в setCapabilities
         upd: Необходимо было добавить в capabilities uiAutomator2(по дефолту используется uiAutomator1)*/

        TimeUnit.SECONDS.sleep(5);
        test2SupportAgentDialog(driver);
        TimeUnit.SECONDS.sleep(5);
        test3PasswordChange(driver);
        TimeUnit.SECONDS.sleep(5);
        test4Menu(driver);
        TimeUnit.SECONDS.sleep(5);
        test5Leaderboard(driver);

    }

    public static void test1Login(AndroidDriver<AndroidElement> driver) throws InterruptedException
    {
        MobileElement el1 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/frag_login_login");
        el1.clear();
        el1.sendKeys("testj@gmail.com");
        MobileElement el2 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/frag_login_pass");
        el2.clear();
        el2.sendKeys("123qwe");
        (new TouchAction(driver)).tap(PointOption.point( 366, 271)).perform();
        MobileElement el3 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/frag_login_enter_btn");
        el3.click();
        TimeUnit.SECONDS.sleep(5);
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        el4.click();
        TimeUnit.SECONDS.sleep(5);
        el4 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        el4.click();

        System.out.println("Test 1 completed");

    }

    public static void test2SupportAgentDialog(AndroidDriver<AndroidElement> driver) throws InterruptedException
    {


        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_contact_as");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/chat_input_field");
        el3.sendKeys("Just test message");
        MobileElement el4 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/chat_float_send");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_main");
        el6.click();

        System.out.println("\nTest 2 completed");

    }

    public static void test3PasswordChange(AndroidDriver<AndroidElement> driver) throws InterruptedException
    {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_settings");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_change_pass");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_pass_old");
        el4.sendKeys("123qwe");
        MobileElement el5 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_pass");
        el5.sendKeys("qwe123");
        MobileElement el6 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_pass_2");
        el6.sendKeys("qwe123");
        MobileElement el7 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_change_pass_new");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_change_pass");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_pass_old");
        el9.sendKeys("qwe123");
        MobileElement el10 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_pass");
        el10.sendKeys("123qwe");
        MobileElement el11 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_pass_2");
        el11.sendKeys("123qwe");
        MobileElement el12 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/setting_change_pass_new");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_main");
        el14.click();

        System.out.println("\nTest 3 completed");

    }

    public static void test4Menu(AndroidDriver<AndroidElement> driver) throws InterruptedException {

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_trips");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_results");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_contact_as");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_settings_guide");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_settings");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_exit");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/md_buttonDefaultNegative");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_main");
        el14.click();

        System.out.println("Test 4 completed");
    }

    public static void test5Leaderboard(AndroidDriver<AndroidElement> driver) throws InterruptedException
    {
        String maneuvers = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget." +
                "RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                "LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/" +
                "android.widget.TextView[1]").getText();
        String speeding = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget" +
                ".DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]" +
                "/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]").getText();
        String mileage = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4." +
                "widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget." +
                "LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]").getText();
        String phoneUsage = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget." +
                "DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android." +
                "widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/" +
                "android.widget.LinearLayout/android.widget.TextView[1]").getText();
        int overall = (Integer.parseInt(maneuvers)+Integer.parseInt(speeding)+Integer.parseInt(mileage)+Integer.parseInt(phoneUsage))/4;

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_results");
        el2.click();

        TimeUnit.SECONDS.sleep(5);

        List<AndroidElement> wl = driver.findElements(By.id("com.metasystem.metatrakubi:id/leaderboard_pager"));
         MobileElement us = wl.get(0).findElementById("com.metasystem.metatrakubi:id/rating_user_view_scoring");
         int leaderboardOverall = Integer.parseInt(us.getText());

        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.metasystem.metatrakubi:id/leftmenu_main");
        el4.click();

        System.out.println("dashboard score - "+overall+"\nleaderboard score - "+leaderboardOverall);
        System.out.println("\nTest 5 completed");

    }
}
