package test;

import elements.HomeElements;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;

import java.awt.*;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ConfigVirtualAuthenticator.virtualAuthenticatorCreateCredential;

/**
 * @author jussaragranja
 */
public class RegisterTest extends TestBase {

    @Test
    public void registerSuccessTest(){
        virtualAuthenticatorCreateCredential();
        String user = "test_"+ new Random().nextInt(10000);

        new HomePage()
                .validatePage()
                .writeExampleUsername(user)
                .changenAdvancedSettings()
                .clickButtonRegister();

        HomeElements homeElements = new HomeElements();
        BasePage.wait(homeElements.getMsgSuccess());
        assertEquals("Success! Now try to authenticate...", homeElements.getMsgSuccess().getText());
    }

    @Test
    public void registerWithoutUserExceptionTest(){
        virtualAuthenticatorCreateCredential();

        new HomePage()
                .validatePage()
                .writeExampleUsername("")
                .changenAdvancedSettings()
                .clickButtonRegister();

        HomeElements homeElements = new HomeElements();
        BasePage.wait(homeElements.getMsgError());
        assertEquals("Please enter a username to register", homeElements.getMsgError().getText());
    }

    @Test
    public void registerNoAuthenticatorExceptionTest() throws AWTException {
        new HomePage()
                .validatePage()
                .writeExampleUsername("test_"+ new Random().nextInt(10000))
                .changenAdvancedSettings()
                .clickButtonRegister()
                .closeAlert();

        HomeElements homeElements = new HomeElements();
        assertThat(homeElements.getMsgError().getText(), containsString("The operation either timed out or was not allowed."));

    }

}
