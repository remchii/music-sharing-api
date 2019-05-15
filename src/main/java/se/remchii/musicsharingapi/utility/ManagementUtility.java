package se.remchii.musicsharingapi.utility;

import com.auth0.client.auth.AuthAPI;
import com.auth0.client.mgmt.ManagementAPI;
import com.auth0.client.mgmt.filter.FieldsFilter;
import com.auth0.exception.APIException;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import com.auth0.json.mgmt.users.User;
import com.auth0.net.AuthRequest;
import com.auth0.net.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import se.remchii.musicsharingapi.property.Auth0Properties;

import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableConfigurationProperties(Auth0Properties.class)
public class ManagementUtility {

    private static final Logger LOG = LoggerFactory.getLogger(ManagementUtility.class);
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");
    private final Auth0Properties properties;
    private ManagementAPI management = null;
    private LocalDateTime tokenExpirationTime;

    public ManagementUtility(Auth0Properties properties) {
        this.properties = properties;
        if (management == null) {
            initialize();
        }
    }

    private void initialize() {
        AuthRequest authRequest = getAuthRequest();
        try {
            TokenHolder tokenHolder = authRequest.execute();
            management = new ManagementAPI(properties.getDomain(), tokenHolder.getAccessToken());
            tokenExpirationTime = LocalDateTime.now().plusMinutes(tokenHolder.getExpiresIn() - 5);
        } catch (Auth0Exception e) {
            LOG.error("Failed to initialize Management API");
        }
        LOG.info("Initialized Management API");
    }

    private void refreshToken() {
        AuthRequest authRequest = getAuthRequest();
        try {
            TokenHolder tokenHolder = authRequest.execute();
            management.setApiToken(tokenHolder.getAccessToken());
            tokenExpirationTime = LocalDateTime.now().plusMinutes(tokenHolder.getExpiresIn() - 5);
        } catch (Auth0Exception e) {
            LOG.error("Failed to refresh Management API token");
        }
        LOG.info("Refreshed token for Management API");
    }

    private boolean isTokenExpired() {
        return tokenExpirationTime.isBefore(LocalDateTime.now());
    }

    private AuthRequest getAuthRequest() {
        AuthAPI authApi = new AuthAPI(properties.getDomain(), CLIENT_ID, CLIENT_SECRET);
        return authApi.requestToken("https://" + properties.getDomain() + "/api/v2/");
    }

    public void test() {
        System.out.println(isTokenExpired());
        FieldsFilter filter = new FieldsFilter();
        Request<List<User>> request = management.users().listByEmail("johndoe@auth0.com", filter);
        try {
            List<User> response = request.execute();
            System.out.println("Executed request");
        } catch (APIException exception) {
            exception.printStackTrace();
        } catch (Auth0Exception exception) {
            exception.printStackTrace();
        }
    }
}
