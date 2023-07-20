package test;

import elements.HomeElements;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;

import java.util.Random;

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
        BasePage.wait(homeElements.getMsgErroNoUser());
        assertEquals("Please enter a username to register", homeElements.getMsgErroNoUser().getText());
    }

}
