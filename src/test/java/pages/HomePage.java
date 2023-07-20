package pages;

import elements.HomeElements;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jussaragranja
 */
public class HomePage extends BasePage {

    private final HomeElements homeElements = new HomeElements();

    public HomePage validatePage(){
        Assertions.assertEquals("WebAuthn.io", homeElements.getTitleh2().getText());
        return this;
    }

    public HomePage writeExampleUsername(String user){
        writeInField(homeElements.getInputName(), user);
        return this;
    }

    public HomePage clickButtonRegister(){
        click(homeElements.getButtonRegister());
        return this;
    }

    public void clickButtonLogin(){
        click(homeElements.getButtonAuthenticate());
    }

    public HomePage changenAdvancedSettings(){
        click(homeElements.getButtonAdvancedSettings());
        selectElementByVisibleValue(homeElements.getSelectAttachment(), "platform");
        selectElementByVisibleValue(homeElements.getSelectAttestation(), "direct");
        return this;
    }

    public HomePage validateMsgSuccess(){
        wait(homeElements.getMsgSuccess());
        assertEquals("Success! Now try to authenticate...", homeElements.getMsgSuccess().getText());
        return this;
    }

}
