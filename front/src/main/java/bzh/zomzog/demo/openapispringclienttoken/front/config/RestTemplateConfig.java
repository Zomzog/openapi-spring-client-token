package bzh.zomzog.demo.openapispringclienttoken.front.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.additionalInterceptors((httpRequest, bytes, clientHttpRequestExecution) -> {
            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                OAuth2AuthenticationDetails oauthsDetails = (OAuth2AuthenticationDetails) details;
                String type = oauthsDetails.getTokenType();
                String token = oauthsDetails.getTokenValue();
                log.debug("Intercepting HTTP request and adding OAuth2 authentication header");
                httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, type + " " + token);
            } else {
                throw new RuntimeException("Not oauth2");
            }
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        }).build();
    }
}
