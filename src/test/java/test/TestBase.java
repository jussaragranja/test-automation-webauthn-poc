package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static util.Browser.browserOpen;
import static util.Browser.driver;
import static util.PropertyLoader.URL;


/**
 * @author jussaragranja
 * methods to be executed before and after tests
 */
public class TestBase {

    /*
     * Instance of a new driver
     * Before Test
     */
    @BeforeEach
    public void before(){
        browserOpen();
        driver.get(URL);
    }

    /*
     * Close driver
     * After Test
     */
    @AfterEach
    public void after(){
        if(driver != null){
            driver.quit();
        }
        driver = null;
    }

}