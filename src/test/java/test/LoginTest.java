package test;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

import static util.ConfigVirtualAuthenticator.virtualAuthenticatorCreateCredential;

/**
 * @author jussaragranja
 */
public class LoginTest extends TestBase {

    @Test
    public void loginSuccessTest() throws InterruptedException {
        virtualAuthenticatorCreateCredential();
        String user = "test_"+ new Random().nextInt(10000);

        new HomePage()
                .validatePage()
                .writeExampleUsername(user)
                .changenAdvancedSettings()
                .clickButtonRegister()
                .validateMsgSuccess()
                .clickButtonLogin();

        new LoginPage()
                .validateLoginSuccess(user);
    }

}