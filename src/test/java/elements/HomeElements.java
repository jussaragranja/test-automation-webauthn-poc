
package elements;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.Browser.driver;

/**
 * @author jussaragranja
 */
@Data
public class HomeElements {

    public HomeElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    private WebElement titleh2;

    @FindBy(id = "input-email")
    private WebElement inputName;

    @FindBy(id = "register-button")
    private WebElement buttonRegister;

    @FindBy(id = "login-button")
    private WebElement buttonAuthenticate;

    @FindBy(xpath = "//button[@class='btn btn-secondary mb-3']")
    private WebElement buttonAdvancedSettings;

    @FindBy(id = "attachment")
    private WebElement selectAttachment;

    @FindBy(id = "attestation")
    private WebElement selectAttestation;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement msgSuccess;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement msgError;

}
