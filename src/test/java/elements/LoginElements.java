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
public class LoginElements {

    public LoginElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h3")
    private WebElement titleh3;

    @FindBy(xpath = "/html/body/main/section[1]/div/div[1]/div/h3/strong")
    private WebElement credentialName;

}
