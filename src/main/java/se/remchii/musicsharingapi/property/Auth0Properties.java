package se.remchii.musicsharingapi.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("auth0")
public class Auth0Properties {

    private String apiAudience;
    private String issuer;

    public String getApiAudience() {
        return apiAudience;
    }

    public void setApiAudience(String apiAudience) {
        this.apiAudience = apiAudience;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
