package logging.easyMdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasyMDCConfiguration {

    @Bean
    EasyMDCAspect easyMDCAspect(){
        return new EasyMDCAspect();
    }
}
