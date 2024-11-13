package sritel_web_portal.demo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

                if (requestAttributes != null) {
                    String authToken = requestAttributes.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
                    if (authToken != null) {
                        // Add Authorization token to the Feign request
                        requestTemplate.header(HttpHeaders.AUTHORIZATION, authToken);
                    }
                }
            }
        };
    }
}

