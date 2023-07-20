package util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jussaragranja
 */
public class PropertyLoader {

    private static final String PROPERTIES_FILE = "test.properties";
    public static String URL;
    public static String BROWSER;
    public static String CHROME_DRIVER_WIN_PATH;
    public static String CHROME_DRIVER_LINUX_PATH;
    public static String CHROME_DRIVER_MAC_PATH;
    public static String FIREFOX_DRIVER_WIN_PATH;
    public static String FIREFOX_DRIVER_LINUX_PATH;
    public static String FIREFOX_DRIVER_MAC_PATH;
    private static final String SRC_SELENIUM = "/src/test/resources/";

    public static Properties getProperties(){
        Properties properties = new Properties();
        InputStream file = ClassLoader.getSystemResourceAsStream(PROPERTIES_FILE);
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        try {
            properties.load(file);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return properties;
    }

    static {
        Properties properties = getProperties();
        BROWSER                     = properties.getProperty("browser");
        URL                     = properties.getProperty("url");
        CHROME_DRIVER_WIN_PATH      = new File("").getAbsolutePath() + SRC_SELENIUM + "driver/windows/chromedriver.exe";
        CHROME_DRIVER_LINUX_PATH    = new File("").getAbsolutePath() + SRC_SELENIUM + "driver/linux/chromedriver";
        CHROME_DRIVER_MAC_PATH      = new File("").getAbsolutePath() + SRC_SELENIUM + "driver/mac/chromedriver";
        FIREFOX_DRIVER_WIN_PATH     = new File("").getAbsolutePath() + SRC_SELENIUM + "driver/windows/geckodriver.exe";
        FIREFOX_DRIVER_LINUX_PATH   = new File("").getAbsolutePath() + SRC_SELENIUM + "driver/linux/geckodriver";
        FIREFOX_DRIVER_MAC_PATH     = new File("").getAbsolutePath() + SRC_SELENIUM + "driver/mac/geckodriver";
    }

}