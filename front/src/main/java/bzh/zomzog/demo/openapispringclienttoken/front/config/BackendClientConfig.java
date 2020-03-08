package bzh.zomzog.demo.openapispringclienttoken.front.config;

import bzh.zomzog.demo.openapispringclienttoken.front.controller.ApiClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Configuration
public class BackendClientConfig {

    private final ApiClient apiClient;

    @PostConstruct
    public void config(){
        apiClient.setBasePath("http://localhost:8081");
    }

}
