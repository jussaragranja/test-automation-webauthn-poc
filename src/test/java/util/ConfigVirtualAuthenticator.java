package util;

import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import static util.Browser.driver;

/**
 * @author jussaragranja
 * set virtual authenticator properties and configuration
 */
public class ConfigVirtualAuthenticator {

    public static VirtualAuthenticator virtualAuthenticatorCreateCredential(){
        VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
                .setTransport(VirtualAuthenticatorOptions.Transport.INTERNAL)
                .setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
                .setHasUserVerification(true)
                .setIsUserVerified(true);

        return ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);
    }

}
