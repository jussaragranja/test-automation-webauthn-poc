package pages;

import elements.LoginElements;
import org.junit.jupiter.api.Assertions;

/**
 * @author jussaragranja
 */
public class LoginPage extends BasePage {

    private final LoginElements loginElements = new LoginElements();


    public void validateLoginSuccess(String user) throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertEquals("You're logged in!", loginElements.getTitleh3().getText());
        Assertions.assertEquals(user, loginElements.getCredentialName().getText());
    }

}