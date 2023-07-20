package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

import static util.PropertyLoader.*;

/**
 * @author jussaragranja
 * browsers path config
 */

public class Browser {

    public static WebDriver driver;
    public static String OS = System.getProperty("os.name").toLowerCase();

    public static void browserOpen() {
        if (driver == null) {
            if (BROWSER.equalsIgnoreCase("chrome")){
                try {
                    System.setProperty("webdriver.chrome.driver", getFileDriverChrome().getAbsolutePath());
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (BROWSER.equalsIgnoreCase("firefox")) {
                try {
                    System.setProperty("webdriver.gecko.driver", getFileDriverFirefox().getAbsolutePath());
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static boolean isWindows(){
        return OS.contains("win");
    }

    public static boolean isMac(){
        return OS.contains("mac");
    }

    public static boolean isUnix(){
        return (OS.contains("nix") || OS.contains("nux") || OS
                .indexOf("aix") > 0);
    }

    public static File getFileDriverChrome() throws Exception {
        File file;
        if (isWindows()){
            file = new File(CHROME_DRIVER_WIN_PATH);
        } else if (isMac()){
            file = new File(CHROME_DRIVER_MAC_PATH);
        } else if (isUnix()){
            file = new File(CHROME_DRIVER_LINUX_PATH);
        } else {
            throw new Exception("Unsupported operating system");
        }
        return file;
    }

    public static File getFileDriverFirefox() throws Exception {
        File file;
        if (isWindows()){
            file = new File(FIREFOX_DRIVER_WIN_PATH);
        } else if (isMac()){
            file = new File(FIREFOX_DRIVER_MAC_PATH);
        }else if(isUnix()){
            file = new File(FIREFOX_DRIVER_LINUX_PATH);
        } else {
            throw new Exception("Unsupported operating system");
        }
        return file;
    }

}