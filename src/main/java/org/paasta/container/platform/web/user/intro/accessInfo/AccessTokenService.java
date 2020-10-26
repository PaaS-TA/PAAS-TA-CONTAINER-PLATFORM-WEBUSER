package org.paasta.container.platform.web.user.intro.accessInfo;

import org.paasta.container.platform.web.user.common.Constants;
import org.paasta.container.platform.web.user.common.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * AccessToken service 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2020.10.14
 */
@Service
public class AccessTokenService {

    private final RestTemplateService restTemplateService;

    /**
     * Instantiates a new Access Token service.
     *
     * @param restTemplateService the rest template service
     */
    @Autowired
    public AccessTokenService(RestTemplateService restTemplateService) {this.restTemplateService = restTemplateService;}


    /**
     * Secret 을 조회한다.
     *
     * @param namespace       the namespace
     * @param accessTokenName the access token name
     * @return the AccessToken
     */
    AccessToken getToken(String namespace, String accessTokenName) {
        return restTemplateService.send(Constants.TARGET_CP_API, Constants.URI_API_SECRETS_DETAIL
                .replace("{namespace:.+}", namespace)
                .replace("{accessTokenName:.+}", accessTokenName),
            HttpMethod.GET, null, AccessToken.class);
    }

}
